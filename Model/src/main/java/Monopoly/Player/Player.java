package Monopoly.Player;

import Monopoly.Board.Board;
import Monopoly.Board.JailField;
import Monopoly.Board.PropertyField;
import Monopoly.SpecialCard.JailCard;
import Monopoly.SpecialCard.Status;

import java.util.List;
import java.util.Random;

public class Player extends Participant{
    private Pawn pawn;
    private Status isInJail;
    private int inJailTurn;
    private boolean canExitJail;

    public Player(int money, List<PropertyField> listOfProperties, Pawn pawn) {
        super(money, listOfProperties);
        this.pawn = pawn;
        this.isInJail = Status.OUT_JAIL;
        this.canExitJail = false;
        this.inJailTurn = 0;
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

    public void move(Board board){
        int rzutKostka = throwDice();
        this.move(board, rzutKostka);
    }

    public void move(Board board, int iloscPol){

        //wylosował 3 dublety wiec do wiezienia i sie nie rusza
        if(iloscPol == -1) {
            getPawn().setCurrentLocation(board.getJailField());
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
        if (getPawn().getCurrentLocation().getFieldIndex() + iloscPol > 40) {
            getPawn().setCurrentLocation(board.getField(Math.abs(40 - (getPawn().getCurrentLocation().getFieldIndex() + iloscPol))));
            setMoney(getMoney()+200);
        } else {
            getPawn().setCurrentLocation(board.getField(getPawn().getCurrentLocation().getFieldIndex() + iloscPol));
        }
    }

    public int throwDice(){
        Random r = new Random();
        int a = r.nextInt(6) + 1;
        int b = r.nextInt(6) + 1;
        if(a == b){
            if (this.isInJail.equals(Status.IN_JAIL)) {
                this.canExitJail = true;
                return 0;
            }
            int c = r.nextInt(6) + 1;
            int d = r.nextInt(6) + 1;
            if(c == d){
                int e = r.nextInt(6) + 1;
                int f = r.nextInt(6) + 1;
//                    int f = e;
                if(e == f){
                    return -1;
                }
                return a + b + c + d + e + f;
            }
            return a + b + c + d;
        }
        return a + b;
    }

    public void setStatus(Status inJail){
        if(getPawn().getCurrentLocation() instanceof JailField)
            {
                this.setIsInJail(Status.IN_JAIL);
            }
//        if(getPawn().isStun() == true){
//            this.setIsInJail(Status.IN_JAIL);
//        }
    }

    public int getInJailTurn() {
        return inJailTurn;
    }

    public void setInJailTurn(int inJailTurn) {
        this.inJailTurn = inJailTurn;
    }
}
