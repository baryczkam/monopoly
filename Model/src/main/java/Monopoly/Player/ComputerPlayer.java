package Monopoly.Player;

import Monopoly.Board.PropertyField;
import Monopoly.SpecialCard.JailCard;
import Monopoly.SpecialCard.Status;

import java.util.List;

public class ComputerPlayer extends Player{
    public ComputerPlayer(int money, List<PropertyField> listOfProperties, Pawn pawn, Status canExitJail, List<JailCard> cards) {
        super(money, listOfProperties, pawn, canExitJail, cards);
    }

    public void simulateBuy(){

    }
    public void simulateUpgrade(){

    }
    public void simulateSell(){

    }
}
