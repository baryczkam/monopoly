package Monopoly.Board;

import Monopoly.Player.Bank;
import Monopoly.Player.Participant;
import Monopoly.Player.Player;
import Monopoly.Player.PlayerInterface;
import Monopoly.SpecialCard.Status;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PropertyField extends Field{
    private int costPurchaseProperty;
//    private int costPurchaseBuilding;
//    private Status status;
    private Participant owner;
//    private NumberOfBuildings numberOfBuildings;

    private int stayCost;

    public PropertyField(int fieldIndex, int costPurchaseProperty, Participant owner, int stayCost) {
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


    public Participant getOwner() {
        return owner;
    }

    public void setOwner(Participant owner) {
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

//    public void buyProperty(Player player){
//        if(getOwner() instanceof Bank) {
//            if(player.getMoney() - getCostPurchaseProperty() >= 0){
//                player.setMoney(player.getMoney() - getCostPurchaseProperty());
//                setOwner(player);
//                player.getListOfProperties().add(this);
//            }
//        }
//    }
//
//    public void payStayCost(Player player){
//        if(!(getOwner() == player) && !(getOwner() instanceof Bank)) {
//            player.setMoney(player.getMoney() - getStayCost());
//            getOwner().setMoney(getOwner().getMoney() + getStayCost());
//        }
//    }
}
