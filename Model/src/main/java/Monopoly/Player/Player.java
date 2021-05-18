package Monopoly.Player;

import Monopoly.Board.PropertyField;
import Monopoly.SpecialCard.JailCard;
import Monopoly.SpecialCard.Status;

import java.util.List;

public class Player extends Participant{
    private int money;
    private Pawn pawn;
    private Status isInJail = Status.OUT_JAIL;
    private boolean canExitJail = false;
    private List<JailCard> cards;

    public Player(int money, List<PropertyField> listOfProperties, Pawn pawn, Status isInJail, boolean canExitJail,List<JailCard> cards) {
        super(listOfProperties);
        this.money = money;
        this.pawn = pawn;
        this.isInJail = isInJail;
        this.canExitJail = canExitJail;
        this.cards = cards;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
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

    public List<JailCard> getCards() {
        return cards;
    }

    public void setCards(List<JailCard> cards) {
        this.cards = cards;
    }

    public void setStatus(){
        if(!getCards().isEmpty() && getIsInJail() == Status.IN_JAIL){
            setIsInJail(Status.OUT_JAIL);
            getCards().remove(getCards().get(0));
        }
    }

    public void jailCardAdd(JailCard card){
        getCards().add(card);
    }

    public void buyProperty(PropertyField propertyField){
        if(getMoney() - propertyField.getCostPurchaseProperty() >= 0){
            setMoney(getMoney() - propertyField.getCostPurchaseProperty());
            propertyField.setOwner(this);
            getListOfProperties().add(propertyField);

        }
    }
}
