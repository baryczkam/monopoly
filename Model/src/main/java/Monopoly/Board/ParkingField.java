package Monopoly.Board;

import Monopoly.Player.PlayerInterface;

public class ParkingField extends SpecialField{

    private int moneyPayment;


    public ParkingField(int fieldIndex, int moneyPayment) {
        super(fieldIndex);
        this.moneyPayment = moneyPayment;
    }

    public int getMoneyPayment() {
        return moneyPayment;
    }

    public void setMoneyPayment(int moneyPayment) {
        this.moneyPayment = moneyPayment;
    }
}
