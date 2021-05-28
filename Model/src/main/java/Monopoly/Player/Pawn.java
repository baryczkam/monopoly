package Monopoly.Player;

import Monopoly.Board.Field;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Pawn {
    private Field currentLocation;
    private String pawnName;

    public Pawn(Field currentLocation, String pawnName) {
        this.currentLocation = currentLocation;
        this.pawnName = pawnName;
    }


    public Field getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Field currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void performActionField(){

    }

    public String getPawnName() {
        return pawnName;
    }

    public void setPawnName(String pawnName) {
        this.pawnName = pawnName;
    }

    @Override
    public String toString() {
        return "Pawn{" +
                "currentLocation=" + currentLocation +
                ", pawnName='" + pawnName + '\'' +
                '}';
    }
}
