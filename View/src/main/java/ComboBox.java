public class ComboBox extends javafx.scene.control.ComboBox implements Component {
    private Mediator mediator;


    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "ComboBox";
    }
}
