package Monopoly.Player;

import Monopoly.Board.Field;

public class Pawn {
    private Field currentLocation;
//    private PlayerInterface owner;


    public Pawn(Field currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Field getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Field currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void move(){

    }
    public void throwDice(){

    }
    public void performActionField(){

    }

}
