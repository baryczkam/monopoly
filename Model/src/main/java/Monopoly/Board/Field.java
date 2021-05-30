package Monopoly.Board;

import Monopoly.Player.PlayerInterface;

public class Field {
    private int fieldIndex;

    public Field(int fieldIndex) {
        this.fieldIndex = fieldIndex;
    }

    public int getFieldIndex() {
        return fieldIndex;
    }

    public void setFieldIndex(int fieldIndex) {
        this.fieldIndex = fieldIndex;
    }

}
