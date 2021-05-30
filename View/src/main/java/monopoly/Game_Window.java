package monopoly;

import Monopoly.Board.Board;
import Monopoly.GameManager.GameManager;
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
import java.util.Vector;

public class Game_Window {

    public Dice dice;
    public PawnPosition pawnPosition;
    public Vector<Player> players;

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

    public Game_Window() {}

    @FXML
    public void initialize() {
        GameManager gameManager = new GameManager();
        gameManager.initializeBoard();
    }

    public void rollTheDice() throws InterruptedException {
        dice = new Dice();
        pawnPosition = new PawnPosition();
        dice.throwTheDice(players.get(0));
        eyelets.setText("" + dice.getNumberOfEyelets());
        int whichField = players.get(0).getPawn().getCurrentLocation().getFieldIndex();
        dice.movePawn(Board.getInstance(null,null),players.get(0));
        pawnPosition.changePawnPosition(pionekAuto,players.get(0).getPawn().getCurrentLocation().getFieldIndex());
    }

    public void buyProperty() {}
    public void expandProperty() {}
    public void takeSpecialCard() {}
    public void whoseTurn() {}
    public void prisonField() {}

    public void transferMessage(Vector<Player> players) {
        this.players = players;
    }
}
