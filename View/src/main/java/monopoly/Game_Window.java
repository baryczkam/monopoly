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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Game_Window {

    public Dice dice;
    public PawnPosition pawnPosition;
    public Vector<Player> players;
    public Vector<ImageView> pawns;
    public int numberOfPlayers;
    public int turn;
    public newGame_Window newGameWindow = new newGame_Window();

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    private ImageView imageView3;

    @FXML
    private ImageView imageView4;

    @FXML
    private ImageView imageAuto;

    @FXML
    private ImageView imageBut;

    @FXML
    private ImageView imageKapelusz;

    @FXML
    private ImageView imagePies;

    @FXML
    private ImageView imageStatek;

    @FXML
    private ImageView imageTaczka;

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
        turn = 0;
        dice = new Dice();
        pawnPosition = new PawnPosition();
        pawns = new Vector<>();
        players = newGame_Window.players;

        if (players.size() == 1) {
            pawns.add(imageView1);
        }

        if (players.size() == 2) {
            pawns.add(imageView1);
            pawns.add(imageView2);
        }

        if (players.size() == 3) {
            pawns.add(imageView1);
            pawns.add(imageView2);
            pawns.add(imageView3);
        }

        if (players.size() == 4) {
            pawns.add(imageView1);
            pawns.add(imageView2);
            pawns.add(imageView3);
            pawns.add(imageView4);
        }

        addPawnToPlayer();
    }


    public void rollTheDice() throws InterruptedException {
        dice.throwTheDice(players.get(turn));
        eyelets.setText("" + dice.getNumberOfEyelets());
        dice.movePawn(players.get(turn));
        pawnPosition.changePawnPosition(pawns.get(turn),players.get(turn).getPawn().getCurrentLocation().getFieldIndex());
        rollTheDice.setDisable(true);
    }

    public void changeTurn() {
        if(turn == (players.size() - 1)) {
            turn = 0;
        }
        else turn++;
        rollTheDice.setDisable(false);
    }

    public void buyProperty() {}
    public void expandProperty() {}
    public void takeSpecialCard() {}
    public void whoseTurn() {}
    public void prisonField() {}

    public void transferMessage(Vector<Player> players, int numberOfPlayers) {
        this.players = players;
        this.numberOfPlayers = numberOfPlayers;
    }

    public void addPawnToPlayer() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPawn().getPawnName() == "Auto") {
                pawns.get(i).setImage(imageAuto.getImage());
            }
            if (players.get(i).getPawn().getPawnName() == "But") {
                pawns.get(i).setImage(imageBut.getImage());
            }
            if (players.get(i).getPawn().getPawnName() == "Kapelusz") {
                pawns.get(i).setImage(imageKapelusz.getImage());
            }
            if (players.get(i).getPawn().getPawnName() == "Pies") {
                pawns.get(i).setImage(imagePies.getImage());
            }
            if (players.get(i).getPawn().getPawnName() == "Statek") {
                pawns.get(i).setImage(imageStatek.getImage());
            }
            if (players.get(i).getPawn().getPawnName() == "Taczka") {
                pawns.get(i).setImage(imageTaczka.getImage());
            }
        }
    }

}
