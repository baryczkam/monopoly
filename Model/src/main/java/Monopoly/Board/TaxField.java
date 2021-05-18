package Monopoly.Board;

import Monopoly.Player.PlayerInterface;

public class TaxField extends SpecialField{
    private int taxCost;


    public TaxField(int fieldIndex, int taxCost) {
        super(fieldIndex);
        this.taxCost = taxCost;
    }

    public int getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(int taxCost) {
        this.taxCost = taxCost;
    }

//    public int payTax(){
//
//
//    }
}
