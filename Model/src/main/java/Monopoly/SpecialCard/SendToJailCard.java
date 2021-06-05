package Monopoly.SpecialCard;

import Monopoly.Board.Board;
import Monopoly.Player.Player;
import Monopoly.Player.Status;

import java.io.Serializable;

public class SendToJailCard extends JailCard implements Serializable {
    public SendToJailCard() {
    }

    @Override
    public void performAction(Player player){
        player.getPawn().setCurrentLocation(Board.getInstance(null,null).getJailField());
        player.setIsInJail(Status.IN_JAIL);
    }
}
