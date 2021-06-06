package Monopoly.Board;

import Monopoly.Player.Participant;
import Monopoly.Player.Player;

public class PropertyField extends Field{
    private int costPurchaseProperty;
    private Participant owner;
    private double actionCost;

    public PropertyField(int fieldIndex, int costPurchaseProperty, Participant owner, double actionCost) {
        super(fieldIndex);
        this.costPurchaseProperty = costPurchaseProperty;
        this.owner = owner;
        this.actionCost = actionCost;
    }

    public int getCostPurchaseProperty() {
        return costPurchaseProperty;
    }

    public void setCostPurchaseProperty(int costPurchaseProperty) {
        this.costPurchaseProperty = costPurchaseProperty;
    }

    public Participant getOwner() {
        return owner;
    }

    public void setOwner(Participant owner) {
        this.owner = owner;
    }

    public void payStayCost(Player player, int index){

    }

    public double getActionCost() {
        return actionCost;
    }

    public void setActionCost(int actionCost) {
        this.actionCost = actionCost;
    }
}
