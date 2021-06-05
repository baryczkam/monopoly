package Monopoly.SpecialCard;

import Monopoly.Player.Player;

import java.io.Serializable;

public class RenovationCard implements SpecialCard, Serializable {
    private int value;

    public RenovationCard(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void performAction(Player player) {
        player.setMoney(player.getMoney() - player.getListOfProperties().size()*getValue());
    }

}
