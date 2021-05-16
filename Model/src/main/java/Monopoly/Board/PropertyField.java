package Monopoly.Board;

import Monopoly.Player.PlayerInterface;
import Monopoly.SpecialCard.Status;

public class PropertyField extends Field{
    private int costPurchaseProperty;
    private int costPurchaseBuilding;
    private Status status;
    private PlayerInterface owner;
    private NumberOfBuildings numberOfBuildings;

    private int stayCost;


    public PropertyField(int fieldIndex, PlayerInterface player, int costPurchaseProperty, int costPurchaseBuilding, Status status, PlayerInterface owner, NumberOfBuildings numberOfBuildings, int stayCost) {
        super(fieldIndex, player);
        this.costPurchaseProperty = costPurchaseProperty;
        this.costPurchaseBuilding = costPurchaseBuilding;
        this.status = status;
        this.owner = owner;
        this.numberOfBuildings = numberOfBuildings;
        this.stayCost = stayCost;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public NumberOfBuildings getNumberOfBuildings() {
        return numberOfBuildings;
    }

    public void setNumberOfBuildings(NumberOfBuildings numberOfBuildings) {
        this.numberOfBuildings = numberOfBuildings;
    }

    public int getCostPurchaseProperty() {
        return costPurchaseProperty;
    }

    public void setCostPurchaseProperty(int costPurchaseProperty) {
        this.costPurchaseProperty = costPurchaseProperty;
    }

    public int getCostPurchaseBuilding() {
        return costPurchaseBuilding;
    }

    public void setCostPurchaseBuilding(int costPurchaseBuilding) {
        this.costPurchaseBuilding = costPurchaseBuilding;
    }

    public PlayerInterface getOwner() {
        return owner;
    }

    public void setOwner(PlayerInterface owner) {
        this.owner = owner;
    }

    public int getStayCost() {
        return stayCost;
    }

    public void setStayCost(int stayCost) {
        this.stayCost = stayCost;
    }
}
