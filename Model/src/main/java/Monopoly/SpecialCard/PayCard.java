package Monopoly.SpecialCard;

import Monopoly.Player.PlayerInterface;

public class PayCard extends SpecialCard{
    private int amountMoneyToPay;

    public PayCard(PlayerInterface player, int amountMoneyToPay) {
        super(player);
        this.amountMoneyToPay = amountMoneyToPay;
    }

    public int getAmountMoneyToPay() {
        return amountMoneyToPay;
    }

    public void setAmountMoneyToPay(int amountMoneyToPay) {
        this.amountMoneyToPay = amountMoneyToPay;
    }

    @Override
    public void performAction() {
        super.performAction();
    }
}
