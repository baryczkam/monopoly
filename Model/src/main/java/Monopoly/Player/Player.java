package Monopoly.Player;

import Monopoly.Board.PropertyField;
import Monopoly.SpecialCard.JailCard;
import Monopoly.SpecialCard.SpecialCard;
import Monopoly.SpecialCard.SpecialCardInterface;
import Monopoly.SpecialCard.Status;

import java.util.List;

public class Player extends Participant{
    private Pawn pawn;
    private Status canExitJail = Status.OUT_JAIL;
    private List<JailCard> cards;

    public Player(int money, List<PropertyField> listOfProperties, Pawn pawn, Status canExitJail, List<JailCard> cards) {
        super(money, listOfProperties);
        this.pawn = pawn;
        this.canExitJail = canExitJail;
        this.cards = cards;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public Status getCanExitJail() {
        return canExitJail;
    }

    public void setCanExitJail(Status canExitJail) {
        this.canExitJail = canExitJail;
    }

    public List<JailCard> getCards() {
        return cards;
    }

    public void setCards(List<JailCard> cards) {
        this.cards = cards;
    }

    public void setStatus(){
        if(!getCards().isEmpty() && getCanExitJail() == Status.IN_JAIL){
            setCanExitJail(Status.OUT_JAIL);
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
