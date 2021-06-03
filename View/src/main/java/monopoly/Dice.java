package monopoly;
import Monopoly.Player.Player;
import Monopoly.Board.Board;

public class Dice {

    private int numberOfEyelets;

    public Dice() {

    }

    public int getNumberOfEyelets() {
        return numberOfEyelets;
    }

    public void setNumberOfEyelets(int numberOfEyelets) {
        this.numberOfEyelets = numberOfEyelets;
    }

    public int throwTheDice(Player player) {
//        setNumberOfEyelets(-1);
        setNumberOfEyelets(player.throwDice());
        return getNumberOfEyelets();
    }

    public void movePawn(Player player) {
        player.move(getNumberOfEyelets());
    }
}
