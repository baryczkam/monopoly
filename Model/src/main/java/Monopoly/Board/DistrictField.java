package Monopoly.Board;

import Monopoly.Player.Participant;
import Monopoly.Player.Player;
import Monopoly.Player.Status;

import java.util.stream.Collectors;

public class DistrictField extends PropertyField{

    private ColorDistrictField color;

    public DistrictField(int fieldIndex, int costPurchaseProperty, Participant owner, int actionCost, ColorDistrictField color) {
        super(fieldIndex, costPurchaseProperty, owner, actionCost);
        this.color = color;
    }

    public ColorDistrictField getColor() {
        return color;
    }

    public void setColor(ColorDistrictField color) {
        this.color = color;
    }

    @Override
    public void payStayCost(Player player, int index){
        ColorDistrictField color1 = ((DistrictField) player.getPawn().getCurrentLocation()).getColor();
        Participant owner1 = ((DistrictField) player.getPawn().getCurrentLocation()).getOwner();
        int ile = Board.getInstance(null,null).getFieldList().stream()
        .filter(field -> field instanceof DistrictField)
        .filter(field -> ((DistrictField) field).getOwner().equals(owner1))
        .filter(field -> ((DistrictField) field).getColor().equals(color1))
        .collect(Collectors.toList()).size();


        if (this.color.equals(ColorDistrictField.BROWN) || this.color.equals(ColorDistrictField.BLUE)){
            if(ile == 2){
                player.setMoney(player.getMoney() - getActionCost()*2);
                ((Player) getOwner()).setMoney(((Player) getOwner()).getMoney() + getActionCost()*2);
            }
        }
        if (!(this.color.equals(ColorDistrictField.BROWN)) && !(this.color.equals(ColorDistrictField.BLUE))){
            if(ile == 3){
                player.setMoney(player.getMoney() - getActionCost()*2);
                ((Player) getOwner()).setMoney(((Player) getOwner()).getMoney() + getActionCost()*2);
            }
        }

        if (this.color.equals(ColorDistrictField.BROWN) || this.color.equals(ColorDistrictField.BLUE)){
            if(ile == 1){
                player.setMoney(player.getMoney() - getActionCost());
                ((Player) getOwner()).setMoney(((Player) getOwner()).getMoney() + getActionCost());
            }
        }
        if(!this.color.equals(ColorDistrictField.BROWN) && !this.color.equals(ColorDistrictField.BLUE)){
            if(ile < 3 && ile > 0){
                player.setMoney(player.getMoney() - getActionCost());
                ((Player) getOwner()).setMoney(((Player) getOwner()).getMoney() + getActionCost());
            }
        }
    }

}
