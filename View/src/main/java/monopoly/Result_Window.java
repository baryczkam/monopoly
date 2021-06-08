package monopoly;
import Monopoly.Monopoly;
import Monopoly.Player.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.Vector;

public class Result_Window {

    public static Vector<Player> players;
    public int winnerNumber;

    @FXML
    private Label winner;

    @FXML
    public void initialize() {
        players = Game_Window.players;
        winnerNumber = Game_Window.turn;
        winner.setText(Monopoly.getPlayerName(players.get(winnerNumber)));
    }
}
