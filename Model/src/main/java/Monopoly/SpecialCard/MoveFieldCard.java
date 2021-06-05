package Monopoly.SpecialCard;

import Monopoly.Board.Board;
import Monopoly.Board.Field;
import Monopoly.Player.Player;

import java.io.Serializable;

public class MoveFieldCard extends MoveCard implements Serializable {

    private Field destinationField;

    public Field getDestinationField() {
        return destinationField;
    }

    public void setDestinationField(Field destinationField) {
        this.destinationField = destinationField;
    }

    public MoveFieldCard(Field destinationField) {
        this.destinationField = destinationField;
    }

    @Override
    public void performAction(Player player) {
        if(player.getPawn().getCurrentLocation().getFieldIndex() > getDestinationField().getFieldIndex()){
            player.setMoney(player.getMoney() + 200);
        }
        player.getPawn().setCurrentLocation(this.destinationField);
    }

}
