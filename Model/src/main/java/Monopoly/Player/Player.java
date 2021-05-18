package Monopoly.Player;

import Monopoly.Board.JailField;
import Monopoly.Board.PropertyField;
import Monopoly.SpecialCard.JailCard;
import Monopoly.SpecialCard.Status;

import java.util.List;

public class Player extends Participant{
    private int money;
    private Pawn pawn;
    private Status isInJail = Status.OUT_JAIL;
    private boolean canExitJail = false;

    public Player(int money, List<PropertyField> listOfProperties, Pawn pawn, Status isInJail, boolean canExitJail) {
        super(listOfProperties);
        this.money = money;
        this.pawn = pawn;
        this.isInJail = isInJail;
        this.canExitJail = canExitJail;
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

    public void setStatus(){
        if(getPawn().getCurrentLocation() instanceof JailField)
            {
                this.setIsInJail(Status.IN_JAIL);
            }
        }

}
