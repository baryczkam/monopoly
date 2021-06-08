package monopoly;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BuildingStage.buildStage(stage,"/Main_Window.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
