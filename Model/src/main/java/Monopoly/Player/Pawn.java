package Monopoly.Player;

import Monopoly.Board.Field;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Pawn {
    private Field currentLocation;
//    private boolean stun;
//    private int stunTurn;

    public Pawn(Field currentLocation, boolean stun) {
        this.currentLocation = currentLocation;
//        this.stun = stun;
//        this.stunTurn = 0;
    }

//    public boolean isStun() {
//        return stun;
//    }
//
//    public void setStun(boolean stun) {
//        this.stun = stun;
//    }

    public Field getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Field currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void performActionField(){

    }

//    public int getStunTurn() {
//        return stunTurn;
//    }
//
//    public void setStunTurn(int stunTurn) {
//        this.stunTurn = stunTurn;
//    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("currentLocation", currentLocation)
//                .append("stun", stun)
                .toString();
    }
}
