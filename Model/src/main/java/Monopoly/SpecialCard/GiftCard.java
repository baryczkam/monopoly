package Monopoly.SpecialCard;

import Monopoly.Player.Player;
import Monopoly.Player.PlayerInterface;

public class GiftCard extends SpecialCard{
    private int money;

    public GiftCard(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public void performAction(Player player) {
        player.setMoney(player.getMoney() + this.getMoney());
    }
}
