package monopoly;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.ResourceBundle;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        BuildingStage.buildStage(stage,"/Main_Window.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }


}
