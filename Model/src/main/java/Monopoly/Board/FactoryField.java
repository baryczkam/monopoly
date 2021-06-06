package Monopoly.Board;

import Monopoly.Player.Participant;
import Monopoly.Player.Player;

public class FactoryField extends PropertyField{
    public FactoryField(int fieldIndex, int costPurchaseProperty, Participant owner, int actionCost) {
        super(fieldIndex, costPurchaseProperty, owner, actionCost);
    }

    @Override
    public void payStayCost(Player player, int index){
        int ile = 0;
        for(PropertyField field : getOwner().getListOfProperties()) {
            if(field instanceof FactoryField) {
                ile++;
            }
        }
        if (ile == 1){
            player.setMoney(player.getMoney() - getActionCost()*index);
            ((Player) getOwner()).setMoney(((Player) getOwner()).getMoney() + getActionCost()*index);
        }
        if (ile == 2){
            player.setMoney(player.getMoney() - getActionCost()*index*2.5);
            ((Player) getOwner()).setMoney(((Player) getOwner()).getMoney() + getActionCost()*index*2);
        }
    }
}
