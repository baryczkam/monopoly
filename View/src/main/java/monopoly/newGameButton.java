package monopoly;
import javafx.scene.control.Button;

public class newGameButton extends Button implements Component {
    private Mediator mediator;

    public newGameButton() {
        super("NewGame");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "newGameButton";
    }
}