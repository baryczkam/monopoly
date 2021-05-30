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
    public newGame_Window newGame_window;
//    public Vector<Player> players;
//    public Board board;

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

    public Game_Window() {
//        this.newGame_window = newGame_window;
    }

    @FXML
    public void initialize() {
        GameManager gameManager = new GameManager();
        gameManager.initializeBoard();
    }
//    public void createBoard(Board board){
//        this.board = board;
//    }

    public void createWindow(newGame_Window newGame_window){
        this.newGame_window = newGame_window;
    }

//    public void createPlayers(Vector<Player> players) {
//        this.players = players;
//    }

//    public void setPlayers(Vector<Player> players) {
//        this.players = players;
//    }

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

    public newGame_Window getNewGame_window() {
        return newGame_window;
    }
}
