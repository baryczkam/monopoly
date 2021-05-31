package monopoly;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class information_Window {

    @FXML
    private Button returnBtn;

    @FXML
    public void returnToMainWindow() {
        BuildingStage.buildStage("/Main_Window.fxml");
    }
}
