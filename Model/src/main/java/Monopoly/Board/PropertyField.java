package Monopoly.Board;

import Monopoly.Player.Player;
import Monopoly.Player.PlayerInterface;
import Monopoly.SpecialCard.Status;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PropertyField extends Field{
    private int costPurchaseProperty;
//    private int costPurchaseBuilding;
//    private Status status;
    private Player owner;
//    private NumberOfBuildings numberOfBuildings;

    private int stayCost;

    public PropertyField(int fieldIndex, int costPurchaseProperty, Player owner, int stayCost) {
        super(fieldIndex);
        this.costPurchaseProperty = costPurchaseProperty;
        this.owner = owner;
        this.stayCost = stayCost;
    }

    public int getCostPurchaseProperty() {
        return costPurchaseProperty;
    }

    public void setCostPurchaseProperty(int costPurchaseProperty) {
        this.costPurchaseProperty = costPurchaseProperty;
    }

//    public int getCostPurchaseBuilding() {
//        return costPurchaseBuilding;
//    }
//
//    public void setCostPurchaseBuilding(int costPurchaseBuilding) {
//        this.costPurchaseBuilding = costPurchaseBuilding;
//    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getStayCost() {
        return stayCost;
    }

    public void setStayCost(int stayCost) {
        this.stayCost = stayCost;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("costPurchaseProperty", costPurchaseProperty)
                .append("owner", owner)
                .append("stayCost", stayCost)
                .toString();
    }
}
