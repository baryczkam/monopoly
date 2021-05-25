package monopoly;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BuildingStage {
    private static Stage stage;

    private static void setStage(Stage stage) {
        BuildingStage.stage = stage;
    }

    private static Parent fxml(String path) throws IOException {
        return new FXMLLoader(BuildingStage.class.getResource(path)).load();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void buildStage(String path) {
        setStage(stage);
        Scene scene = null;
        try {
            scene = new Scene(fxml(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public static void buildStage(Stage stage, String path) {
        setStage(stage);
        Scene scene = null;
        try {
            scene = new Scene(fxml(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Monopoly");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

}
