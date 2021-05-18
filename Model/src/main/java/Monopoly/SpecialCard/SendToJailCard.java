package Monopoly.SpecialCard;

import Monopoly.Board.JailField;
import Monopoly.Player.Player;
import Monopoly.Player.PlayerInterface;

public class SendToJailCard extends JailCard{
    public SendToJailCard(PlayerInterface player, Status status) {
        super(player, status);
    }
    public void performAction(Player Player){
        Player.setIsInJail(Status.IN_JAIL);
//        Player.getPawn().setCurrentLocation(JailField);
    }
}
