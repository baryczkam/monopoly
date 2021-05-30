package Monopoly.SpecialCard;

import Monopoly.Board.Board;
import Monopoly.Board.Field;
import Monopoly.Player.Player;

public class MoveIndexCard extends MoveCard{
    private int index;

    public MoveIndexCard(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void performAction(Player player) {
        player.getPawn().setCurrentLocation(Board.getInstance(null,null).getField(player.getPawn().getCurrentLocation().getFieldIndex() + getIndex()));
    }
}
