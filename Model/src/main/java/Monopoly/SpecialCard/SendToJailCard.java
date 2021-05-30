package Monopoly.SpecialCard;

import Monopoly.Board.Board;
import Monopoly.Player.Player;
import Monopoly.Player.Status;

public class SendToJailCard extends JailCard{
    public SendToJailCard() {
    }

    @Override
    public void performAction(Player player){
        player.getPawn().setCurrentLocation(Board.getInstance(null,null).getJailField());
        player.setIsInJail(Status.IN_JAIL);
    }
}
