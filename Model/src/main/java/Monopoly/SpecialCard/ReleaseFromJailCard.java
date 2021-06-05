package Monopoly.SpecialCard;

import Monopoly.Player.Player;

import java.io.Serializable;

public class ReleaseFromJailCard extends JailCard implements Serializable {
    public ReleaseFromJailCard() {
    }

    @Override
    public void performAction(Player player) {
        player.setCanExitJail(true);
    }
}
