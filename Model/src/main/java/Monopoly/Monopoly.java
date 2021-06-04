package Monopoly;

import Monopoly.Board.Field;
import Monopoly.Board.PropertyField;
import Monopoly.Player.Participant;
import Monopoly.Player.Pawn;
import Monopoly.Player.Player;
import Monopoly.Player.Status;

import java.util.List;

/**
 * Fasada odpowiedzialna za wykonanie wszystkich operacji w programie.
 */
public class Monopoly {

    public static void move(Player player) {
        player.move();
    }

    public static void move(Player player, int iloscPol) {
        player.move(iloscPol);
    }

    public static int throwDice(Player player) {
        return player.throwDice();
    }

    public static boolean checkProperty(Player player) {
        return player.checkProperty();
    }

    public static void buyProperty(Player player) {
        player.buyProperty();
    }

    public static void payStayCost(Player player, int index) {
        player.payStayCost(index);
    }

    public static void payTax(Player player) {
        player.payTax();
    }

    public static void getMoneyFromParkingField(Player player) {
        player.getMoneyFromParkingField();
    }

    public static int numerKarty(Player player) {
        return player.numerKarty();
    }

    public static void takeCard(Player player, int numerKarty) {
        player.takeCard(numerKarty);
    }

    public static void goToJail(Player player) {
        player.goToJail();
    }

    public static boolean checkLost(Player player) {
        return player.checkLost();
    }

    public static List<PropertyField> getListOfProperties(Player player) {
        return player.getListOfProperties();
    }

    public static Field getCurrentLocation(Player player) {
        return player.getPawn().getCurrentLocation();
    }

    public static Status isInJail(Player player) {
        return player.getIsInJail();
    }

    public static int isInJailTurn(Player player) {
        return player.getInJailTurn();
    }

    public static Participant getOwnerOfCurrentLocation(Player player) {
        return ((PropertyField) player.getPawn().getCurrentLocation()).getOwner();
    }

    public static String getPawnName(Player player) {
        return player.getPawn().getPawnName();
    }

    public static int indexOfCurrentLocation(Player player) {
        return player.getPawn().getCurrentLocation().getFieldIndex();
    }

    public static String getPlayerName(Player player) {
        return player.getPlayerName();
    }

    public static Player createPlayer(int money, List<PropertyField> listOfProperties, Pawn pawn, String playerName) {
        return new Player(money, listOfProperties, pawn, playerName);
    }

    public static Pawn createPawn(Field currentLocation, String pawnName) {
        return new Pawn(currentLocation, pawnName);
    }
}
