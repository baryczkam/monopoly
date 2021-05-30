package Monopoly.Board;


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
