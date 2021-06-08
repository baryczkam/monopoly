package monopoly;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Objects;

public class saveGame_Window {

    public void saveGame() {}

    @FXML
    private TextField fileName;

    @FXML
    private Button saveFileName;

    @FXML
    private Label labSingleFile;

    @FXML
    void fileChooser() {
        if (fileName.getText() != "") {
            labSingleFile.setText("Miejsce zapisu: " + fileName.getText());
        }
    }
}
