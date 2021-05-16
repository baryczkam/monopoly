package Monopoly.SpecialCard;

import Monopoly.Player.PlayerInterface;

public class SpecialCard {
    private PlayerInterface player;

    public SpecialCard(PlayerInterface player) {
        this.player = player;
    }

    public PlayerInterface getPlayer() {
        return player;
    }

    public void setPlayer(PlayerInterface player) {
        this.player = player;
    }

    public void performAction(){

    }
}
