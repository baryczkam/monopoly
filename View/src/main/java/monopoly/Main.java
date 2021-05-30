package monopoly;

import Monopoly.Board.Board;
import Monopoly.Board.Field;
import Monopoly.Board.PropertyField;
import Monopoly.Player.Pawn;
import javafx.application.Application;
import javafx.stage.Stage;
import Monopoly.Player.Player;

import java.util.*;

import java.io.IOException;
import java.util.logging.Logger;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BuildingStage.buildStage(stage,"/Main_Window.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
