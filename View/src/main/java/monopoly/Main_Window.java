package monopoly;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Main_Window implements Mediator {

    public void initialize() {
        registerComponent(new newGameButton());
        registerComponent(new loadGameButton());
        registerComponent(new informationButton());
    }

    @FXML
    private Button newGameBtn;

    @FXML
    private Button loadGameBtn;

    @FXML
    private Button informationBtn;

    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (component.getName()) {
            case "newGameButton" -> {
                newGameBtn = (newGameButton) component;
            }
            case "loadGameButton" -> {
                loadGameBtn = (loadGameButton) component;
            }
            case "informationButton" -> {
                informationBtn = (informationButton) component;
            }
        }
    }

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
}
