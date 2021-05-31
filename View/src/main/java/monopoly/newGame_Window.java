package monopoly;

import Monopoly.Board.Field;
import Monopoly.Board.Board;
import Monopoly.Board.PropertyField;
import Monopoly.GameManager.GameManager;
import Monopoly.Player.Pawn;
import Monopoly.SpecialCard.SpecialCard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import Monopoly.Player.Player;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static javafx.collections.FXCollections.observableArrayList;

public class newGame_Window implements Mediator {

    public static Vector<Player> players;
    public Board board;
    private static Stage stage;
    public int numberOfPlayers;
    List<PropertyField> propertyFields1 = new ArrayList<>();
    List<PropertyField> propertyFields2 = new ArrayList<>();
    List<PropertyField> propertyFields3 = new ArrayList<>();
    List<PropertyField> propertyFields4 = new ArrayList<>();

    @FXML
    private ComboBox<Integer> chooseNumberOfPlayers;

    @FXML
    private ComboBox<String> choosePawn1;

    @FXML
    private ComboBox<String> choosePawn2;

    @FXML
    private ComboBox<String> choosePawn3;

    @FXML
    private ComboBox<String> choosePawn4;

    @FXML
    private Tab player1;

    @FXML
    private Tab player2;

    @FXML
    private Tab player3;

    @FXML
    private Tab player4;

    @FXML
    private Button addPlayer1;

    @FXML
    private Button addPlayer2;

    @FXML
    private Button addPlayer3;

    @FXML
    private Button addPlayer4;

    @FXML
    public void initialize() {
        chooseNumberOfPlayers.setItems(observableArrayList(1,2,3,4));
        choosePawn1.setItems(observableArrayList("Auto","But","Kapelusz","Pies","Statek","Taczka"));
        choosePawn2.setItems(observableArrayList("Auto","But","Kapelusz","Pies","Statek","Taczka"));
        choosePawn3.setItems(observableArrayList("Auto","But","Kapelusz","Pies","Statek","Taczka"));
        choosePawn4.setItems(observableArrayList("Auto","But","Kapelusz","Pies","Statek","Taczka"));
        GameManager gameManager = new GameManager();
        gameManager.initializeBoard();
        players = new Vector<>();
    }

    public void setNumberOfPlayers() {
        numberOfPlayers = chooseNumberOfPlayers.getValue();
        if (numberOfPlayers == 1) {
            player1.setDisable(false);
            player2.setDisable(true);
            player3.setDisable(true);
            player4.setDisable(true);
        }
        if (numberOfPlayers == 2) {
            player1.setDisable(false);
            player2.setDisable(false);
            player3.setDisable(true);
            player4.setDisable(true);
        }
        if (numberOfPlayers == 3) {
            player1.setDisable(false);
            player2.setDisable(false);
            player3.setDisable(false);
            player4.setDisable(true);
        }
        if (numberOfPlayers == 4) {
            player1.setDisable(false);
            player2.setDisable(false);
            player3.setDisable(false);
            player4.setDisable(false);
        }
    }

    public void createPlayer1() {
        if (writeName1.getText() != "" && choosePawn1.getValue() != null) {
            Pawn pawn1 = new Pawn(Board.getInstance(null,null).getField(0),choosePawn1.getValue());
            Player player1 = new Player(500,propertyFields1,pawn1,writeName1.getText());
            players.add(player1);
//            System.out.println(players.get(0).getPawn().getPawnName());
            addPlayer1.setDisable(true);
            choosePawn2.getItems().removeAll(choosePawn1.getValue());
            choosePawn3.getItems().removeAll(choosePawn1.getValue());
            choosePawn4.getItems().removeAll(choosePawn1.getValue());
            choosePawn1.setDisable(true);
            writeName1.setDisable(true);
        }
    }

    public void createPlayer2() {
        if (writeName2.getText() != "" && choosePawn2.getValue() != null) {
            Pawn pawn2 = new Pawn(Board.getInstance(null,null).getField(0),choosePawn2.getValue());
            Player player2 = new Player(500,propertyFields2,pawn2,writeName2.getText());
            players.add(player2);
            addPlayer2.setDisable(true);
            choosePawn1.getItems().removeAll(choosePawn2.getValue());
            choosePawn3.getItems().removeAll(choosePawn2.getValue());
            choosePawn4.getItems().removeAll(choosePawn2.getValue());
            choosePawn2.setDisable(true);
            writeName2.setDisable(true);
        }
    }

    public void createPlayer3() {
        if (writeName3.getText() != "" && choosePawn3.getValue() != null) {
            Pawn pawn3 = new Pawn(Board.getInstance(null,null).getField(0),choosePawn3.getValue());
            Player player3 = new Player(500,propertyFields3,pawn3,writeName3.getText());
            players.add(player3);
            addPlayer3.setDisable(true);
            choosePawn1.getItems().removeAll(choosePawn3.getValue());
            choosePawn2.getItems().removeAll(choosePawn3.getValue());
            choosePawn4.getItems().removeAll(choosePawn3.getValue());
            choosePawn3.setDisable(true);
            writeName3.setDisable(true);
        }
    }

    public void createPlayer4() {
        if (writeName4.getText() != "" && choosePawn4.getValue() != null) {
            Pawn pawn4 = new Pawn(Board.getInstance(null, null).getField(0), choosePawn4.getValue());
            Player player4 = new Player(500, propertyFields4, pawn4, writeName4.getText());
            players.add(player4);
            addPlayer4.setDisable(true);
            choosePawn1.getItems().removeAll(choosePawn4.getValue());
            choosePawn2.getItems().removeAll(choosePawn4.getValue());
            choosePawn3.getItems().removeAll(choosePawn4.getValue());
            choosePawn4.setDisable(true);
            writeName4.setDisable(true);
        }
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

    @FXML
    public void startNewGameWindow() {
        BuildingStage.buildStage("/Game_Window.fxml");
    }

    @FXML
    public void returnToMainWindow() {
        BuildingStage.buildStage("/Main_Window.fxml");
    }

    public void createBoard() {
        Field field1 = new Field(0);
        Field field2 = new Field(1);
        Field field3 = new Field(2);
        Field field4 = new Field(3);
        Field field5 = new Field(4);
        Field field6 = new Field(5);
        Field field7 = new Field(6);
        Field field8 = new Field(7);
        Field field9 = new Field(8);
        Field field10 = new Field(9);
        Field field11 = new Field(10);
        Field field12 = new Field(11);
        Field field13 = new Field(12);
        Field field14 = new Field(13);
        Field field15 = new Field(14);
        Field field16 = new Field(15);
        Field field17 = new Field(16);
        Field field18 = new Field(17);
        Field field19 = new Field(18);
        Field field20 = new Field(19);
        Field field21 = new Field(20);
        Field field22 = new Field(21);
        Field field23 = new Field(22);
        Field field24 = new Field(23);
        Field field25 = new Field(24);
        Field field26 = new Field(25);
        Field field27 = new Field(26);
        Field field28 = new Field(27);
        Field field29 = new Field(28);
        Field field30 = new Field(29);
        Field field31 = new Field(30);
        Field field32 = new Field(31);
        Field field33 = new Field(32);
        Field field34 = new Field(33);
        Field field35 = new Field(34);
        Field field36 = new Field(35);
        Field field37 = new Field(36);
        Field field38 = new Field(37);
        Field field39 = new Field(38);
        Field field40 = new Field(39);
        List<Field> fields = new ArrayList<>();
        fields.add(field1);
        fields.add(field2);
        fields.add(field3);
        fields.add(field4);
        fields.add(field5);
        fields.add(field6);
        fields.add(field7);
        fields.add(field8);
        fields.add(field9);
        fields.add(field10);
        fields.add(field11);
        fields.add(field12);
        fields.add(field13);
        fields.add(field14);
        fields.add(field15);
        fields.add(field16);
        fields.add(field17);
        fields.add(field18);
        fields.add(field19);
        fields.add(field20);
        fields.add(field21);
        fields.add(field22);
        fields.add(field23);
        fields.add(field24);
        fields.add(field25);
        fields.add(field26);
        fields.add(field27);
        fields.add(field28);
        fields.add(field29);
        fields.add(field30);
        fields.add(field31);
        fields.add(field32);
        fields.add(field33);
        fields.add(field34);
        fields.add(field35);
        fields.add(field36);
        fields.add(field37);
        fields.add(field38);
        fields.add(field39);
        fields.add(field40);
        List<SpecialCard> specialCards = new ArrayList<>();
        board = Board.getInstance(fields,specialCards);
        players = new Vector<>();
    }

//    public void createPlayer() {
//        Pawn pawn = new Pawn(board.getField(0),"auto");
//        List<PropertyField> propertyFields = new ArrayList<>();
//        Player player1 = new Player(100,propertyFields,pawn,"gracz");
//        players.add(player1);
//    }
}
