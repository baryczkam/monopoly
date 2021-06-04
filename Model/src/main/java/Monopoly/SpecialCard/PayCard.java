package Monopoly.SpecialCard;

import Monopoly.Player.Player;
import Monopoly.Player.PlayerInterface;

public class PayCard implements SpecialCard{
    private int amountMoneyToPay;

    public PayCard(int amountMoneyToPay) {
        this.amountMoneyToPay = amountMoneyToPay;
    }

    public int getAmountMoneyToPay() {
        return amountMoneyToPay;
    }

    public void setAmountMoneyToPay(int amountMoneyToPay) {
        this.amountMoneyToPay = amountMoneyToPay;
    }

    @Override
    public void performAction(Player player) {
        player.setMoney(player.getMoney() - this.getAmountMoneyToPay());
    }
}
