package Monopoly.Board;

import Monopoly.Player.PlayerInterface;

public class Field {
    private int fieldIndex;
//    private PlayerInterface player;


//    public Field(int fieldIndex, PlayerInterface player) {
//        this.fieldIndex = fieldIndex;
//        this.player = player;
//    }

    


    public Field(int fieldIndex) {
        this.fieldIndex = fieldIndex;
    }

    public int getFieldIndex() {
        return fieldIndex;
    }

    public void setFieldIndex(int fieldIndex) {
        this.fieldIndex = fieldIndex;
    }

//    public PlayerInterface getPlayer() {
//        return player;
//    }
//
//    public void setPlayer(PlayerInterface player) {
//        this.player = player;
//    }
}
