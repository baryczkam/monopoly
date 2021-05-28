package Monopoly.Player;

import Monopoly.Board.PropertyField;
import Monopoly.SpecialCard.JailCard;
import Monopoly.SpecialCard.Status;

import java.util.List;

public class HumanPlayer extends Player{
    public HumanPlayer(int money, List<PropertyField> listOfProperties, Pawn pawn, String playerName) {
        super(money, listOfProperties, pawn, playerName);
    }

    public void takeFieldAction(){

    }
}
