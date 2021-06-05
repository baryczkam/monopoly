package Monopoly.SpecialCard;

import Monopoly.Player.Player;

import java.io.Serializable;

public class PayCard implements SpecialCard, Serializable {
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
