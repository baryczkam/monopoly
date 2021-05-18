package Monopoly.SpecialCard;

import Monopoly.Player.Player;
import Monopoly.Player.PlayerInterface;

public class GiftCard extends SpecialCard{
    private int money;

    public GiftCard(PlayerInterface player, int money) {
        super(player);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public void performAction(Player Player) {
        Player.setMoney(Player.getMoney() + this.getMoney());
    }
}
