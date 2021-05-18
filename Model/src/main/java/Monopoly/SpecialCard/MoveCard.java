package Monopoly.SpecialCard;

import Monopoly.Board.Field;
import Monopoly.Player.Pawn;
import Monopoly.Player.Player;
import Monopoly.Player.PlayerInterface;

public class MoveCard extends SpecialCard{
    private Field destinationField;

    public MoveCard(PlayerInterface player, Field destinationField) {
        super(player);
        this.destinationField = destinationField;
    }

    public Field getDestinationField() {
        return destinationField;
    }

    public void setDestinationField(Field destinationField) {
        this.destinationField = destinationField;
    }

    @Override
    public void performAction(Player Player) {
        Player.getPawn().setCurrentLocation(destinationField);
    }
}
