package monopoly;

public class Button extends javafx.scene.control.Button implements Component {
    private Mediator mediator;

    public Button() {
        super("monopoly.Button");
    }
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "monopoly.Button";
    }
}
