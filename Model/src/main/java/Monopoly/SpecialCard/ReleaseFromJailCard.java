package Monopoly.SpecialCard;

import Monopoly.Player.Player;
import Monopoly.Player.PlayerInterface;

public class ReleaseFromJailCard extends JailCard{
    public ReleaseFromJailCard(PlayerInterface player, Status status) {
        super(player, status);
    }

    public void performAction(Player Player) {
        if(!Player.getCanExitJail())
            Player.setCanExitJail(true);
    }
}
