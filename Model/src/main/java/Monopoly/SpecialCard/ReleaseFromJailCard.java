package Monopoly.SpecialCard;

import Monopoly.Player.Player;
import Monopoly.Player.PlayerInterface;

public class ReleaseFromJailCard extends JailCard{
    public ReleaseFromJailCard() {
    }

    @Override
    public void performAction(Player player) {
        player.setCanExitJail(true);
    }
}
