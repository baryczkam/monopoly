package Monopoly.SpecialCard;

import Monopoly.Board.Board;
import Monopoly.Board.Field;
import Monopoly.Player.Player;

import java.io.Serializable;

public class GoToStartCard extends MoveCard implements Serializable {

    public GoToStartCard() {

    }

    @Override
    public void performAction(Player player) {
        player.getPawn().setCurrentLocation(Board.getInstance(null,null).getStartField());
        player.setMoney(player.getMoney() + 200);
    }
}
