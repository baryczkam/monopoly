package Monopoly.Player;

import Monopoly.Board.Field;

import java.util.Random;

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
    public int throwDice(){
//        Random r = new Random();
//        int ile = 0;
//        int a = r.nextInt(7);
//        int b = r.nextInt(7);
//            if(a == b){
//                ile++;
//            }
//        return a + b;
        return 1;
    }
    public void performActionField(){

    }

}
