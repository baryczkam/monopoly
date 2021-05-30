package Monopoly.SpecialCard;

import Monopoly.Board.Field;
import Monopoly.Player.Player;

public class MoveFieldCard extends MoveCard{

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
        player.getPawn().setCurrentLocation(destinationField);
    }

}
