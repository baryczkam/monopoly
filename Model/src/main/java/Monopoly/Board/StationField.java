package Monopoly.Board;

import Monopoly.Player.Participant;
import Monopoly.Player.Player;

public class StationField extends PropertyField{
    public StationField(int fieldIndex, int costPurchaseProperty, Participant owner, int actionCost) {
        super(fieldIndex, costPurchaseProperty, owner, actionCost);
    }

    @Override
    public void payStayCost(Player player, int index){
        int ile = 0;
        for(PropertyField field : getOwner().getListOfProperties()) {
            if(field instanceof StationField) {
                ile++;
            }
        }
        if(ile == 1){
            player.setMoney(player.getMoney() - getActionCost());
            getOwner().setMoney(getOwner().getMoney() + getActionCost());
        }
        if(ile == 2){
            player.setMoney(player.getMoney() - getActionCost()*2);
            getOwner().setMoney(getOwner().getMoney() + getActionCost()*2);
        }
        if(ile == 3){
            player.setMoney(player.getMoney() - getActionCost()*4);
            getOwner().setMoney(getOwner().getMoney() + getActionCost()*4);
        }
        if(ile == 4){
            player.setMoney(player.getMoney() - getActionCost()*8);
            getOwner().setMoney(getOwner().getMoney() + getActionCost()*8);
        }
    }
}
