package monopoly;
import javafx.scene.control.Button;

public class loadGameButton extends Button implements Component {
    private Mediator mediator;

    public loadGameButton() {
        super("LoadGame");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "loadGameButton";
    }
}