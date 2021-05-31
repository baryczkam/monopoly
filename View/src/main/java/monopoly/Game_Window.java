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


//    @FXML
//    private ImageView pionekAuto;
    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    private ImageView imageView3;

    @FXML
    private ImageView imageView4;

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
        if (numberOfPlayers == 1) {
            setPawnImage(imageView1,1);
            pawns.add(imageView1);
        }
        if (numberOfPlayers == 2) {
//            setPawnImage(imageView1,1);
//            setPawnImage(imageView2,2);
            imageView1.setImage(new Image("..\\resources\\images\\pionki\\Pionek_auto.png"));
            pawns.add(imageView1);
            pawns.add(imageView2);
        }
        if (numberOfPlayers == 3) {
            setPawnImage(imageView1,1);
            setPawnImage(imageView2,2);
            setPawnImage(imageView3,3);
            pawns.add(imageView1);
            pawns.add(imageView2);
            pawns.add(imageView3);
        }
        if (numberOfPlayers == 4) {
            setPawnImage(imageView1,1);
            setPawnImage(imageView2,2);
            setPawnImage(imageView3,3);
            setPawnImage(imageView4,4);
            pawns.add(imageView1);
            pawns.add(imageView2);
            pawns.add(imageView3);
            pawns.add(imageView4);
        }
//        System.out.println(pawns.get(0).getImage());
    }

    public void setPawnImage(ImageView pawn, int number) {
//        String path = "@images/pionki/";
        String path = "images\\pionki\\";
        if(players.get(number).getPawn().getPawnName() == "Auto")
            path += "Pionek_auto.png";
        if(players.get(number).getPawn().getPawnName() == "But")
            path += "Pionek_but.png";
        if(players.get(number).getPawn().getPawnName() == "Kapelusz")
            path += "Pionek_kapelusz.png";
        if(players.get(number).getPawn().getPawnName() == "Pies")
            path += "Pionek_pies.png";
        if(players.get(number).getPawn().getPawnName() == "Statek")
            path += "Pionek_statek.png";
        if(players.get(number).getPawn().getPawnName() == "Taczka")
            path += "Pionek_taczka.png";
        pawn.setImage(new Image(path));
    }

//    public void rollTheDice() throws InterruptedException {
//        dice.throwTheDice(players.get(turn));
//        eyelets.setText("" + dice.getNumberOfEyelets());
////        int whichField = players.get(turn).getPawn().getCurrentLocation().getFieldIndex();
//        dice.movePawn(Board.getInstance(null,null),players.get(turn));
//        pawnPosition.changePawnPosition(pawns.get(turn),players.get(turn).getPawn().getCurrentLocation().getFieldIndex());
//    }
    public void rollTheDice() throws InterruptedException {
        dice.throwTheDice(players.get(turn));
        eyelets.setText("" + dice.getNumberOfEyelets());
    //        int whichField = players.get(turn).getPawn().getCurrentLocation().getFieldIndex();
        dice.movePawn(players.get(turn));
        pawnPosition.changePawnPosition(imageView1,players.get(turn).getPawn().getCurrentLocation().getFieldIndex());
    }

    public void changeTurn() {
        if(turn == (players.size() - 1)) {
            turn = 0;
        }
        else turn++;
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
}
