package monopoly;
import javafx.scene.control.Button;

public class informationButton extends Button implements Component {
    private Mediator mediator;

    public informationButton() {
        super("Information");
    }
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "informationButton";
    }
}