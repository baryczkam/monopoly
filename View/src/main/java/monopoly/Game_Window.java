package monopoly;
import Monopoly.Board.*;
import Monopoly.Monopoly;
import Monopoly.Player.Bank;
import Monopoly.Player.Player;
import Monopoly.Player.Status;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Vector;

public class Game_Window {

    public Dice dice;
    public PawnPosition pawnPosition;
    public static Vector<Player> players;
    public Vector<ImageView> pawns;
    public static int turn;
    public int numberOfSpecialCard;
    public static int tempTurn;
    public int licznik;

    @FXML
    private ImageView specialCard;

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    private ImageView imageView3;

    @FXML
    private ImageView imageView4;

    @FXML
    private ImageView imageAuto;

    @FXML
    private ImageView imageBut;

    @FXML
    private ImageView imageKapelusz;

    @FXML
    private ImageView imagePies;

    @FXML
    private ImageView imageStatek;

    @FXML
    private ImageView imageTaczka;

    @FXML
    private Label eyelets;

    @FXML
    private Button saveGameBtn;

    @FXML
    private Button showCards;

    @FXML
    private Button rollTheDice;

    @FXML
    private Button buyProperty;

    @FXML
    private Button endOfTurn;

    @FXML
    private Label playerName;

    @FXML
    private Label playerPawn;

    @FXML
    private Label playerMoney;

    @FXML
    private Button socialCashBtn;

    @FXML
    private Button chanceBtn;



    Alert wiadomosc = new Alert(AlertType.INFORMATION);
    Alert wiadomoscWiezienie = new Alert(AlertType.NONE, "Idziesz do więzienia.",ButtonType.OK);
    Alert wiadomoscCzynsz = new Alert(AlertType.NONE,"Stoisz na polu innego gracza - płacisz mu czynsz.",ButtonType.OK);
    Alert wiadomoscPrzegrana = new Alert(AlertType.NONE,"Przegrywasz.",ButtonType.OK);

    @FXML
    public void initialize() {
        turn = 0;
        dice = new Dice();
        pawnPosition = new PawnPosition();
        pawns = new Vector<>();
        players = newGame_Window.players;
        endOfTurn.setDisable(true);
        buyProperty.setDisable(true);

        wiadomosc.setTitle("Błąd zakupu");
        wiadomosc.setHeaderText("Nie można kupić tego pola");
        wiadomosc.setContentText("Masz za mało pieniędzy.");

        wiadomoscWiezienie.setTitle("Więzienie");

        wiadomoscCzynsz.setTitle("Czynsz");

        if (players.size() == 1) {
            pawns.add(imageView1);
        }

        if (players.size() == 2) {
            pawns.add(imageView1);
            pawns.add(imageView2);
        }

        if (players.size() == 3) {
            pawns.add(imageView1);
            pawns.add(imageView2);
            pawns.add(imageView3);
        }

        if (players.size() == 4) {
            pawns.add(imageView1);
            pawns.add(imageView2);
            pawns.add(imageView3);
            pawns.add(imageView4);
        }

        addPawnToPlayer();

        playerName.setText(Monopoly.getPlayerName(players.get(0)));
        playerPawn.setText(Monopoly.getPawnName(players.get(0)));
        playerMoney.setText("" + players.get(0).getMoney());
        licznik = players.size();
    }


    public void rollTheDice() throws InterruptedException {
        dice.throwTheDice(players.get(turn));
        if(dice.getNumberOfEyelets() == -1) {
            eyelets.setText("TRZY DUBLETY");
        }
        else {
            eyelets.setText("" + dice.getNumberOfEyelets());
        }
        dice.movePawn(players.get(turn));

        if (Monopoly.getCurrentLocation(players.get(turn)) instanceof ChanceCardField) {
            endOfTurn.setDisable(true);
            chanceBtn.setDisable(false);
        }

        if (Monopoly.getCurrentLocation(players.get(turn)) instanceof SocialCashCardField) {
            endOfTurn.setDisable(true);
            socialCashBtn.setDisable(false);
        }

        playerMoney.setText("" + players.get(turn).getMoney());
        pawnPosition.changePawnPosition(pawns.get(turn),Monopoly.indexOfCurrentLocation(players.get(turn)));
        rollTheDice.setDisable(true);

        if (Monopoly.isInJail(players.get(turn)) == Status.IN_JAIL && Monopoly.isInJailTurn(players.get(turn)) == 0) {
            wiadomoscWiezienie.show();
        }

        if (Monopoly.getCurrentLocation(players.get(turn)) instanceof PropertyField &&
                !(Monopoly.getOwnerOfCurrentLocation(players.get(turn)) instanceof Bank) &&
                !((Monopoly.getOwnerOfCurrentLocation(players.get(turn)) == players.get(turn)))) {
            wiadomoscCzynsz.show();
        }

        if (!(Monopoly.getCurrentLocation(players.get(turn)) instanceof ChanceCardField ||
                Monopoly.getCurrentLocation(players.get(turn)) instanceof SocialCashCardField))  {
            endOfTurn.setDisable(false);
        }

        if (Monopoly.getCurrentLocation(players.get(turn))  instanceof PropertyField &&
                Monopoly.getOwnerOfCurrentLocation(players.get(turn)) instanceof Bank) {
            buyProperty.setDisable(false);
        }

        if (Monopoly.checkLost(players.get(turn))) {
            licznik -= 1;
            wiadomoscPrzegrana.show();
        }
    }

    public void buyPropertyFromBank() {
        if (Monopoly.checkProperty(players.get(turn))) {
            Monopoly.buyProperty(players.get(turn));
            buyProperty.setDisable(true);
            playerMoney.setText("" + players.get(turn).getMoney());
        }
        else {
            wiadomosc.show();
        }
    }

    public void changeTurn() {
        tempTurn = turn;
        if(turn == (players.size() - 1)) {
            turn = 0;
        }
        else turn++;
        while(Monopoly.checkLost(players.get(turn))) {
            if(turn == (players.size() - 1)) {
                turn = 0;
            }
            else turn++;
        }
        if (licznik == 1) {
            showGameResult();
        }
        else {
            rollTheDice.setDisable(false);
            buyProperty.setDisable(true);
        }
        endOfTurn.setDisable(true);
        playerName.setText(Monopoly.getPlayerName(players.get(turn)));
        playerPawn.setText(Monopoly.getPawnName(players.get(turn)));
        playerMoney.setText("" + players.get(turn).getMoney());
        specialCard.setImage(null);
    }

    public void addPawnToPlayer() {
        for (int i = 0; i < players.size(); i++) {
            if (Monopoly.getPawnName(players.get(i)) == "Auto") {
                pawns.get(i).setImage(imageAuto.getImage());
            }
            if (Monopoly.getPawnName(players.get(i)) == "But") {
                pawns.get(i).setImage(imageBut.getImage());
            }
            if (Monopoly.getPawnName(players.get(i)) == "Kapelusz") {
                pawns.get(i).setImage(imageKapelusz.getImage());
            }
            if (Monopoly.getPawnName(players.get(i)) == "Pies") {
                pawns.get(i).setImage(imagePies.getImage());
            }
            if (Monopoly.getPawnName(players.get(i)) == "Statek") {
                pawns.get(i).setImage(imageStatek.getImage());
            }
            if (Monopoly.getPawnName(players.get(i)) == "Taczka") {
                pawns.get(i).setImage(imageTaczka.getImage());
            }
        }
    }

    public void drawSpecialCard() {
        numberOfSpecialCard = Monopoly.numerKarty(players.get(turn));
        setSpecialCardImage();
        Monopoly.takeCard(players.get(turn), numberOfSpecialCard);
        pawnPosition.changePawnPosition(pawns.get(turn),Monopoly.indexOfCurrentLocation(players.get(turn)));
        playerMoney.setText("" + players.get(turn).getMoney());
        socialCashBtn.setDisable(true);
        chanceBtn.setDisable(true);
        endOfTurn.setDisable(false);
        if (Monopoly.getCurrentLocation(players.get(turn))  instanceof PropertyField &&
                Monopoly.getOwnerOfCurrentLocation(players.get(turn)) instanceof Bank) {
            buyProperty.setDisable(false);
        }
    }

    public void setSpecialCardImage() {
        String path = "\\images\\karty_specjalne\\";
        if(numberOfSpecialCard == 0)
            path += "karta_szansa1.png";
        if(numberOfSpecialCard == 1)
            path += "karta_szansa2.png";
        if(numberOfSpecialCard == 2)
            path += "karta_szansa3.png";
        if(numberOfSpecialCard == 3)
            path += "karta_szansa4.png";
        if(numberOfSpecialCard == 4)
            path += "karta_szansa5.png";
        if(numberOfSpecialCard == 5)
            path += "karta_szansa6.png";
        if(numberOfSpecialCard == 6)
            path += "karta_szansa7.png";
        if(numberOfSpecialCard == 7)
            path += "karta_szansa8.png";
        if(numberOfSpecialCard == 8)
            path += "karta_szansa9.png";
        if(numberOfSpecialCard == 9)
            path += "karta_szansa10.png";
        if(numberOfSpecialCard == 10)
            path += "karta_szansa11.png";
        if(numberOfSpecialCard == 11)
            path += "karta_szansa12.png";
        if(numberOfSpecialCard == 12)
            path += "karta_szansa13.png";
        if(numberOfSpecialCard == 13)
            path += "karta_szansa14.png";
        if(numberOfSpecialCard == 14)
            path += "karta_szansa15.png";
        if(numberOfSpecialCard == 15)
            path += "karta_szansa16.png";
        if(numberOfSpecialCard == 16)
            path += "karta_kasa_spoleczna1.png";
        if(numberOfSpecialCard == 17)
            path += "karta_kasa_spoleczna2.png";
        if(numberOfSpecialCard == 18)
            path += "karta_kasa_spoleczna3.png";
        if(numberOfSpecialCard == 19)
            path += "karta_kasa_spoleczna4.png";
        if(numberOfSpecialCard == 20)
            path += "karta_kasa_spoleczna5.png";
        if(numberOfSpecialCard == 21)
            path += "karta_kasa_spoleczna6.png";
        if(numberOfSpecialCard == 22)
            path += "karta_kasa_spoleczna7.png";
        if(numberOfSpecialCard == 23)
            path += "karta_kasa_spoleczna8.png";
        if(numberOfSpecialCard == 24)
            path += "karta_kasa_spoleczna9.png";
        if(numberOfSpecialCard == 25)
            path += "karta_kasa_spoleczna10.png";
        if(numberOfSpecialCard == 26)
            path += "karta_kasa_spoleczna11.png";
        if(numberOfSpecialCard == 27)
            path += "karta_kasa_spoleczna12.png";
        if(numberOfSpecialCard == 28)
            path += "karta_kasa_spoleczna13.png";
        if(numberOfSpecialCard == 29)
            path += "karta_kasa_spoleczna14.png";
        if(numberOfSpecialCard == 30)
            path += "karta_kasa_spoleczna15.png";
        if(numberOfSpecialCard == 31)
            path += "karta_kasa_spoleczna16.png";
        specialCard.setImage(new Image(path));
    }

    public void showPlayersCards() {
        try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Cards_Window.fxml"));
            Parent root = loader.load();
            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Karty gracza: " + Monopoly.getPlayerName(players.get(turn)));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void showGameResult() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Result_Window.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Koniec rozgrywki");
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void saveGame() {
        try {
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/saveGame_Window.fxml"));
            Parent root = loader.load();
            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("ZAPIS GRY");
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
