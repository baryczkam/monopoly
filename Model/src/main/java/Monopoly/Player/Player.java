package Monopoly.Player;

import Monopoly.Board.*;
import Monopoly.SpecialCard.SpecialCard;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Player extends Participant{
    private int money;
    private Pawn pawn;
    private Status isInJail;
    private int inJailTurn;
    private boolean canExitJail;
    private String playerName;


    public Player(int money, List<PropertyField> listOfProperties, Pawn pawn, String playerName) {
        super(listOfProperties);
        this.money = money;
        this.pawn = pawn;
        this.isInJail = Status.OUT_JAIL;
        this.canExitJail = false;
        this.inJailTurn = 0;
        this.playerName = playerName;
    }

    public boolean isCanExitJail() {
        return canExitJail;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public Status getIsInJail() {
        return isInJail;
    }

    public void setIsInJail(Status isInJail) {
        this.isInJail = isInJail;
    }

    public boolean getCanExitJail() {
        return canExitJail;
    }

    public void setCanExitJail(boolean canExitJail) {
        this.canExitJail = canExitJail;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void move(){
        int rzutKostka = throwDice();
        this.move(rzutKostka);
    }

    public void move(int iloscPol){
        if(!checkLost()){
            //wylosował 3 dublety wiec do wiezienia i sie nie rusza
            if(iloscPol == -1) {
                getPawn().setCurrentLocation(Board.getInstance(null,null).getJailField());
                this.setIsInJail(Status.IN_JAIL);
                return;
            }

            //jest w wiezieniu juz 2 tury wiec wychodzi
            if (this.isInJail.equals(Status.IN_JAIL) && this.inJailTurn == 2) {
                this.inJailTurn = 0;
                this.setIsInJail(Status.OUT_JAIL);
            }

            //jest w wiezieniu krócej niz 2 tury ale ma karte wyjscia czy cos wiec wychodzi
            if (this.isInJail.equals(Status.IN_JAIL) && this.canExitJail) {
                this.inJailTurn = 0;
                this.setIsInJail(Status.OUT_JAIL);
                this.canExitJail = false;
            }

            //jest w wiezieniu, jeszcze nie odsiedział 2 tur więc się nie rusza
            if(this.isInJail.equals(Status.IN_JAIL) && this.inJailTurn != 2) {
                this.inJailTurn++;
                return;
            }

            //ruch
            if (getPawn().getCurrentLocation().getFieldIndex() + iloscPol > 39) {
                getPawn().setCurrentLocation(Board.getInstance(null,null).getField(Math.abs(40 - (getPawn().getCurrentLocation().getFieldIndex() + iloscPol))));
                setMoney(getMoney()+200);
            } else {
                getPawn().setCurrentLocation(Board.getInstance(null,null).getField(getPawn().getCurrentLocation().getFieldIndex() + iloscPol));
            }
            payStayCost(iloscPol);
            payTax();
            getMoneyFromParkingField();
            goToJail();
        }
    }

    public int throwDice(){
        Random r = new Random();
        int a = r.nextInt(6) + 1;
        int b = r.nextInt(6) + 1;
        if(a == b){
            if (this.isInJail.equals(Status.IN_JAIL)) {
                this.canExitJail = true;
                return a + b;
            }
            int c = r.nextInt(6) + 1;
            int d = r.nextInt(6) + 1;
            if(c == d){
                int e = r.nextInt(6) + 1;
                int f = r.nextInt(6) + 1;
                if(e == f){
                    return -1;
                }
                return a + b + c + d + e + f;
            }
            return a + b + c + d;
        }
        return a + b;
    }

//    public void setStatus(Status inJail){
//        if(getPawn().getCurrentLocation() instanceof JailField)
//            {
//                this.setIsInJail(Status.IN_JAIL);
//            }
//    }

    // sprawdza czy dzialke mozna kupic (czy nalezy do banku)
    public boolean checkProperty(){
        if(Objects.nonNull(getPawn()) && Objects.nonNull(getPawn().getCurrentLocation()) && getPawn().getCurrentLocation() instanceof PropertyField && ((PropertyField) getPawn().getCurrentLocation()).getOwner() instanceof Bank){
            if(Objects.nonNull(getMoney()) && getMoney() - ((PropertyField) getPawn().getCurrentLocation()).getCostPurchaseProperty() >= 0){
                return true;
            }
        }
        return false;
    }

    // kupuje dzialke
    public void buyProperty(){
        if(checkProperty()){
            setMoney(getMoney() - ((PropertyField) getPawn().getCurrentLocation()).getCostPurchaseProperty());
            ((PropertyField) getPawn().getCurrentLocation()).getOwner().getListOfProperties().remove(getPawn().getCurrentLocation());
            ((PropertyField) getPawn().getCurrentLocation()).setOwner(this);
            getListOfProperties().add(((PropertyField) getPawn().getCurrentLocation()));
        }
    }

    // placimy za staniecie na pole ktore nie nalezy do nas i nalezy do innego gracza (nie nalezy do banku)
    public void payStayCost(int index){
        if(getPawn().getCurrentLocation() instanceof PropertyField){
            if(Objects.nonNull(getPawn()) && Objects.nonNull(getPawn().getCurrentLocation()) && Objects.nonNull(getMoney()) && !(((PropertyField) getPawn().getCurrentLocation()).getOwner() == this) && !(((PropertyField) getPawn().getCurrentLocation()).getOwner() instanceof Bank)){
                if(!((Player) ((PropertyField) getPawn().getCurrentLocation()).getOwner()).checkLost())
                ((PropertyField) getPawn().getCurrentLocation()).payStayCost(this,index);
            }
        }
    }

    // placimy za stanecie na polu TaxField, pieniadze przekazywane sa do pola ParkingField
    public void payTax(){
        if(getPawn().getCurrentLocation() instanceof TaxField){
            if(Objects.nonNull(getPawn()) && Objects.nonNull(getPawn().getCurrentLocation()) && Objects.nonNull(getMoney()) && Objects.nonNull(((TaxField) getPawn().getCurrentLocation()).getTaxCost())){
                if(getMoney() - ((TaxField) getPawn().getCurrentLocation()).getTaxCost() >= 0){
                    setMoney(getMoney() - ((TaxField) getPawn().getCurrentLocation()).getTaxCost());
                    Board.getInstance(null,null).getParkingField().setMoneyPayment(Board.getInstance(null,null).getParkingField().getMoneyPayment() + ((TaxField) getPawn().getCurrentLocation()).getTaxCost());
                }
            }
        }
    }

    // pobieramy pieniadze z ParkingField jesli na nim staniemy
    public void getMoneyFromParkingField(){
        if(getPawn().getCurrentLocation() instanceof ParkingField){
            if(Objects.nonNull(getPawn()) && Objects.nonNull(getPawn().getCurrentLocation()) && Objects.nonNull(getMoney()) && Objects.nonNull(((ParkingField) getPawn().getCurrentLocation()).getMoneyPayment())){
                setMoney(getMoney() + ((ParkingField) getPawn().getCurrentLocation()).getMoneyPayment());
                ((ParkingField) getPawn().getCurrentLocation()).setMoneyPayment(0);
            }
        }
    }

    // pobieramy karte i wykonujemy czynnosc w zaleznosci jaka to jest karta

    public int numerKarty(){
        Random r = new Random();
        int numerKarty = 0;
        if(getPawn().getCurrentLocation() instanceof ChanceCardField){
            numerKarty = r.nextInt(Board.getInstance(null,null).getSpecialCardList().size()/2);
        }
        if(getPawn().getCurrentLocation() instanceof SocialCashCardField){
            numerKarty = r.nextInt(Board.getInstance(null,null).getSpecialCardList().size()/2) + 16;
        }
        return numerKarty;
    }

    /**
     * Wykorzystany jest tutaj wzorzec strategii. Logika dotycząca konkretnych akcji jest rozproszona zgodnie
     * z typem po różnych klasach rozszeżających SpecialCard(Strategy),
     * natomiast na podstawie wylosowanego numeru(Context) podejmowana jest dopiero konkretna akcja.
     * @param numerKarty
     */
    public void takeCard(int numerKarty){
        Pawn pawn = getPawn();
        if(Objects.isNull(pawn) || !(pawn.getCurrentLocation() instanceof SpecialCardField)){
            return;
        }
        Board board = Board.getInstance(null, null);

        if(Objects.isNull(board)){
            return;
        }

        List<SpecialCard> specialCardList = board.getSpecialCardList();

        if(Objects.isNull(specialCardList) || specialCardList.size() == 0){
            return;
        }

        SpecialCard specialCard = specialCardList.get(numerKarty);

        specialCard.performAction(this);
    }

    // idziemy do wiezienia gdy staniemy na polu GoToJailField
    public void goToJail(){
        if(getPawn().getCurrentLocation() instanceof GoToJailField){
            if(Objects.nonNull(getPawn()) && Objects.nonNull(getPawn().getCurrentLocation())){
                getPawn().setCurrentLocation(Board.getInstance(null,null).getJailField());
                this.setIsInJail(Status.IN_JAIL);
            }
        }
    }

    public boolean checkLost(){
        if(getMoney() < 0){
            return true;
        }
        return false;
    }



    public int getInJailTurn() {
        return inJailTurn;
    }

    public void setInJailTurn(int inJailTurn) {
        this.inJailTurn = inJailTurn;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pawn=" + pawn +
                ", isInJail=" + isInJail +
                ", inJailTurn=" + inJailTurn +
                ", canExitJail=" + canExitJail +
                ", money=" + getMoney() +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}
