package monopoly;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.shape.Rectangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javafx.stage.Stage;
import java.util.ResourceBundle;

public class Main_Window {

    @FXML
    private Button newGameBtn;

    @FXML
    private Button loadGameBtn;

    @FXML
    private Button informationBtn;

    @FXML
    public void openNewGameWindow() {
        BuildingStage.buildStage("/newGame_Window.fxml");
    }

    @FXML
    public void openLoadGameWindow() {
        BuildingStage.buildStage("/loadGame_Window.fxml");
    }

    @FXML
    public void openInformationWindow() {
        BuildingStage.buildStage("/information_Window.fxml");
    }


    @FXML
    public void initialize() {

    }



    public void xyz() {


    }
}
