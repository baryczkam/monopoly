package monopoly;

import Monopoly.Board.Field;
import Monopoly.Board.Board;
import Monopoly.Board.PropertyField;
import Monopoly.Player.Pawn;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import Monopoly.Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static javafx.collections.FXCollections.observableArrayList;

public class newGame_Window implements Mediator {

    public Vector<Player> players;
    public Board board;

    @FXML
    private ComboBox<String> chooseNumberOfPlayers;

    @FXML
    private ComboBox<String> choosePawn1;

    @FXML
    private ComboBox<String> choosePawn2;

    @FXML
    private ComboBox<String> choosePawn3;

    @FXML
    private ComboBox<String> choosePawn4;

    @FXML
    public void initialize() {
        chooseNumberOfPlayers.setItems(observableArrayList("1","2","3","4"));
        choosePawn1.setItems(observableArrayList("Auto","But","Kapelusz","Pies","Statek","Taczka"));
        choosePawn2.setItems(observableArrayList("Auto","But","Kapelusz","Pies","Statek","Taczka"));
        choosePawn3.setItems(observableArrayList("Auto","But","Kapelusz","Pies","Statek","Taczka"));
        choosePawn4.setItems(observableArrayList("Auto","But","Kapelusz","Pies","Statek","Taczka"));
    }

    @FXML
    private TextField writeName1;

    @FXML
    private TextField writeName2;

    @FXML
    private TextField writeName3;

    @FXML
    private TextField writeName4;

    @FXML
    private Button startNewGame;

    @FXML
    private Button returnBtn;

    public newGame_Window(Vector<Player> players, Board board) {
        this.players = players;
        this.board = board;
    }

    public Vector<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    @FXML
    public void startNewGameWindow() {
        BuildingStage.buildStage("/Game_Window.fxml");
    }

    @FXML
    public void returnToMainWindow() {
        BuildingStage.buildStage("/Main_Window.fxml");
    }

    public void createPlayer() {
        Pawn pawn = new Pawn(getBoard().getField(0),"auto");
        List<PropertyField> propertyFields = new ArrayList<>();
        Player player1 = new Player(100,propertyFields,pawn,"gracz");
        players.add(player1);
    }
}
