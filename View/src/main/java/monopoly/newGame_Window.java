package monopoly;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
//import javafx.scene.control.ChoiceBox;
//import javafx.scene.control.monopoly.ComboBox;
//import javafx.scene.control.TextField;

public class newGame_Window implements Mediator {

    @FXML
//    private ChoiceBox chooseNumberOfPlayers;
    private ComboBox chooseNumberOfPlayers;

    @FXML
    private TextBox writeName;

    @FXML
//    private ChoiceBox choosePawn;
    private ComboBox choosePawn;

    @FXML
    private Button startNewGame;

    @FXML
    public void startNewGameWindow() {
        BuildingStage.buildStage("/Game_Window.fxml");
    }
}
