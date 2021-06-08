package monopoly;
import Monopoly.Board.Board;
import Monopoly.Board.PropertyField;
import Monopoly.GameManager.GameManager;
import Monopoly.Monopoly;
import Monopoly.Player.Pawn;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import Monopoly.Player.Player;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static javafx.collections.FXCollections.observableArrayList;

public class newGame_Window {

    public static Vector<Player> players;
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
    public void initialize() {
        chooseNumberOfPlayers.setItems(observableArrayList(1,2,3,4));
        choosePawn1.setItems(observableArrayList("Auto","But","Kapelusz","Pies","Statek","Taczka"));
        choosePawn2.setItems(observableArrayList("Auto","But","Kapelusz","Pies","Statek","Taczka"));
        choosePawn3.setItems(observableArrayList("Auto","But","Kapelusz","Pies","Statek","Taczka"));
        choosePawn4.setItems(observableArrayList("Auto","But","Kapelusz","Pies","Statek","Taczka"));
        GameManager gameManager = new GameManager();
        gameManager.initializeBoard();
        players = new Vector<>();
        startNewGame.setDisable(true);
    }

    public void setNumberOfPlayers() {
        if (chooseNumberOfPlayers.getValue() != null) {
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
    }

    public void createPlayer1() {
        if (writeName1.getText() != "" && choosePawn1.getValue() != null) {
            Pawn pawn1 = Monopoly.createPawn(Board.getInstance(null,null).getField(0),choosePawn1.getValue());
//            Player player1 = Monopoly.createPlayer(-1,propertyFields1,pawn1,writeName1.getText());
            Player player1 = Monopoly.createPlayer(500,propertyFields1,pawn1,writeName1.getText());
            players.add(player1);
            addPlayer1.setDisable(true);
            choosePawn2.getItems().removeAll(choosePawn1.getValue());
            choosePawn3.getItems().removeAll(choosePawn1.getValue());
            choosePawn4.getItems().removeAll(choosePawn1.getValue());
            choosePawn1.setDisable(true);
            writeName1.setDisable(true);
            if (players.size() == numberOfPlayers) {
                startNewGame.setDisable(false);
            }
        }
        else {
            wiadomoscDodawanieGraczy.show();
        }
    }

    public void createPlayer2() {
        if (writeName2.getText() != "" && choosePawn2.getValue() != null) {
            Pawn pawn2 = Monopoly.createPawn(Board.getInstance(null,null).getField(0),choosePawn2.getValue());
//            Player player2 = Monopoly.createPlayer(11,propertyFields2,pawn2,writeName2.getText());
            Player player2 = Monopoly.createPlayer(500,propertyFields2,pawn2,writeName2.getText());
            players.add(player2);
            addPlayer2.setDisable(true);
            choosePawn1.getItems().removeAll(choosePawn2.getValue());
            choosePawn3.getItems().removeAll(choosePawn2.getValue());
            choosePawn4.getItems().removeAll(choosePawn2.getValue());
            choosePawn2.setDisable(true);
            writeName2.setDisable(true);
            if (players.size() == numberOfPlayers) {
                startNewGame.setDisable(false);
            }
        }
        else {
            wiadomoscDodawanieGraczy.show();
        }
    }

    public void createPlayer3() {
        if (writeName3.getText() != "" && choosePawn3.getValue() != null) {
            Pawn pawn3 = Monopoly.createPawn(Board.getInstance(null,null).getField(0),choosePawn3.getValue());
            Player player3 = Monopoly.createPlayer(500,propertyFields3,pawn3,writeName3.getText());
            players.add(player3);
            addPlayer3.setDisable(true);
            choosePawn1.getItems().removeAll(choosePawn3.getValue());
            choosePawn2.getItems().removeAll(choosePawn3.getValue());
            choosePawn4.getItems().removeAll(choosePawn3.getValue());
            choosePawn3.setDisable(true);
            writeName3.setDisable(true);
            if (players.size() == numberOfPlayers) {
                startNewGame.setDisable(false);
            }
        }
        else {
            wiadomoscDodawanieGraczy.show();
        }
    }

    public void createPlayer4() {
        if (writeName4.getText() != "" && choosePawn4.getValue() != null) {
            Pawn pawn4 = Monopoly.createPawn(Board.getInstance(null,null).getField(0),choosePawn4.getValue());
            Player player4 = Monopoly.createPlayer(500,propertyFields4,pawn4,writeName4.getText());
            players.add(player4);
            addPlayer4.setDisable(true);
            choosePawn1.getItems().removeAll(choosePawn4.getValue());
            choosePawn2.getItems().removeAll(choosePawn4.getValue());
            choosePawn3.getItems().removeAll(choosePawn4.getValue());
            choosePawn4.setDisable(true);
            writeName4.setDisable(true);
            if (players.size() == numberOfPlayers) {
                startNewGame.setDisable(false);
            }
        }
        else {
            wiadomoscDodawanieGraczy.show();
        }
    }

    Alert wiadomoscDodawanieGraczy = new Alert(Alert.AlertType.NONE, "Wszystkie pola muszą być wypełnione, żeby dodać gracza.",ButtonType.OK);

    @FXML
    public void startNewGameWindow() {
        BuildingStage.buildStage("/Game_Window.fxml");
    }

    @FXML
    public void returnToMainWindow() {
        BuildingStage.buildStage("/Main_Window.fxml");
    }

}
