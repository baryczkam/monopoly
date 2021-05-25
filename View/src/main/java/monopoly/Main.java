package monopoly;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class Main extends Application {

    private static final Logger logger = Logger.getLogger(Main_Window.class.getName());

    public static void main(String[] args) {
        //logger.info("Start application");
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Monopoly");
    }
}
