public class TextBox extends javafx.scene.control.TextField implements Component {
    private Mediator mediator;

    public TextBox() {
        super("TextBox");
    }
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "TextBox";
    }
}
