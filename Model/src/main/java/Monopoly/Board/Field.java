package Monopoly.Board;


import java.io.Serializable;

public class Field implements Serializable {
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
