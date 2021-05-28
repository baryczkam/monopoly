package monopoly;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class loadGame_Window implements Initializable {

    public void loadGame() {

    }

    List<String> lstFile;

    @FXML
    private Label labSingleFile;

    @FXML
    private Button chooseFile;

    @FXML
    void fileChooser() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("File",lstFile));
        File f = fc.showOpenDialog(null);
        if (f != null) {
            labSingleFile.setText("Selected file: " + f.getAbsolutePath());
        }
    }

    @FXML
    public void startNewGameWindow() {
        BuildingStage.buildStage("/Game_Window.fxml");
    }

    @FXML
    public void returnToMainWindow() {
        BuildingStage.buildStage("/Main_Window.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lstFile = new ArrayList<>();
        lstFile.add("*.TXT");
        lstFile.add("*.txt");
    }
}
