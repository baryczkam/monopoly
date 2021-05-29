package monopoly;

import Monopoly.Board.Board;
import Monopoly.Board.Field;
import Monopoly.Board.PropertyField;
import Monopoly.Player.Pawn;
import Monopoly.Player.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Game_Window {

    private Dice dice;
    private PawnPosition pawnPosition;
    private newGame_Window newGame_window;

    @FXML
    private ImageView pionekAuto;

    @FXML
    private Label eyelets;

    @FXML
    private Button saveGameBtn;

    @FXML
    private Button rollTheDice;

    @FXML
    private Button buyProperty;

    @FXML
    private Button endOfTurn;

    public Game_Window(newGame_Window newGame_window) {
        this.newGame_window = newGame_window;
    }

    public void rollTheDice() throws InterruptedException {
        dice = new Dice();
        pawnPosition = new PawnPosition("auto");
        dice.throwTheDice(newGame_window.getPlayers().get(0));
        eyelets.setText("" + dice.getNumberOfEyelets());
        int whichField = newGame_window.getPlayers().get(0).getPawn().getCurrentLocation().getFieldIndex();
        dice.movePawn(newGame_window.getBoard(),newGame_window.getPlayers().get(0));
        pawnPosition.changePawnPosition(pionekAuto,newGame_window.getPlayers().get(0).getPawn().getCurrentLocation().getFieldIndex(),dice.getNumberOfEyelets());
    }

    public void buyProperty() {}
    public void expandProperty() {}
    public void takeSpecialCard() {}
    public void whoseTurn() {}
    public void prisonField() {}

    public void changePlayer(){
        newGame_window.getPlayers().get(0).setPlayerName("Marian");
    }

}
