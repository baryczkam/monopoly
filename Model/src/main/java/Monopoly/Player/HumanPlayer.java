package Monopoly.Player;

import Monopoly.Board.PropertyField;
import Monopoly.SpecialCard.JailCard;
import Monopoly.SpecialCard.Status;

import java.util.List;

public class HumanPlayer extends Player{
    public HumanPlayer(int money, List<PropertyField> listOfProperties, Pawn pawn) {
        super(money, listOfProperties, pawn);
    }

    public void takeFieldAction(){

    }
}
