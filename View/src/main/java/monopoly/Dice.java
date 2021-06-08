package monopoly;
import Monopoly.Monopoly;
import Monopoly.Player.Player;

public class Dice {

    private int numberOfEyelets;

    public Dice() {}

    public int getNumberOfEyelets() {
        return numberOfEyelets;
    }

    public void setNumberOfEyelets(int numberOfEyelets) {
        this.numberOfEyelets = numberOfEyelets;
    }

    public int throwTheDice(Player player) {
//        setNumberOfEyelets(-1);
        setNumberOfEyelets(Monopoly.throwDice(player));
        return getNumberOfEyelets();
    }

    public void movePawn(Player player) {
        Monopoly.move(player,getNumberOfEyelets());
    }
}
