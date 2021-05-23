public class Button extends javafx.scene.control.Button implements Component {
    private Mediator mediator;

    public Button() {
        super("Button");
    }
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "Button";
    }
}
