package monopoly;

import Monopoly.Board.*;
import Monopoly.GameManager.GameManager;
import Monopoly.Monopoly;
import Monopoly.Player.Bank;
import Monopoly.Player.Pawn;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Game_Window {

    public Dice dice;
    public PawnPosition pawnPosition;
    public static Vector<Player> players;
    public Vector<ImageView> pawns;
    public static int turn;
    public int numberOfSpecialCard;

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

        playerName.setText(players.get(0).getPlayerName());
        playerPawn.setText(players.get(0).getPawn().getPawnName());
        playerMoney.setText("" + players.get(0).getMoney());
    }


    public void rollTheDice() throws InterruptedException {
        dice.throwTheDice(players.get(turn));
        eyelets.setText("" + dice.getNumberOfEyelets());
        dice.movePawn(players.get(turn));

        if (players.get(turn).getPawn().getCurrentLocation() instanceof ChanceCardField) {
            endOfTurn.setDisable(true);
            chanceBtn.setDisable(false);
        }

        if (players.get(turn).getPawn().getCurrentLocation() instanceof SocialCashCardField) {
            endOfTurn.setDisable(true);
            socialCashBtn.setDisable(false);
        }

        playerMoney.setText("" + players.get(turn).getMoney());
        pawnPosition.changePawnPosition(pawns.get(turn),players.get(turn).getPawn().getCurrentLocation().getFieldIndex());
        rollTheDice.setDisable(true);

        if (players.get(turn).getIsInJail() == Status.IN_JAIL && players.get(turn).getInJailTurn() == 0) {
            wiadomoscWiezienie.show();
        }

        if (players.get(turn).getPawn().getCurrentLocation() instanceof PropertyField &&
                !(Monopoly.getOwnerOfCurrentLocation(players.get(turn)) instanceof Bank) &&
                !(((PropertyField) players.get(turn).getPawn().getCurrentLocation()).getOwner() == players.get(turn))) {
            wiadomoscCzynsz.show();
        }

        if (!(players.get(turn).getPawn().getCurrentLocation() instanceof ChanceCardField ||
                players.get(turn).getPawn().getCurrentLocation() instanceof SocialCashCardField))  {
            endOfTurn.setDisable(false);
        }

        if (players.get(turn).getPawn().getCurrentLocation() instanceof PropertyField &&
                ((PropertyField) players.get(turn).getPawn().getCurrentLocation()).getOwner() instanceof Bank) {
            buyProperty.setDisable(false);
        }
    }

    public void buyPropertyFromBank() {
        if (players.get(turn).checkProperty()) {
            players.get(turn).buyProperty();
            buyProperty.setDisable(true);
            playerMoney.setText("" + players.get(turn).getMoney());
        }
        else {
            wiadomosc.show();
        }
    }

    public void changeTurn() {
        if(turn == (players.size() - 1)) {
            turn = 0;
        }
        else turn++;
        rollTheDice.setDisable(false);
        endOfTurn.setDisable(true);
        playerName.setText(players.get(turn).getPlayerName());
        playerPawn.setText(players.get(turn).getPawn().getPawnName());
        playerMoney.setText("" + players.get(turn).getMoney());
        buyProperty.setDisable(true);
        specialCard.setImage(null);
    }

    public void expandProperty() {}
    public void takeSpecialCard() {}
    public void whoseTurn() {}
    public void prisonField() {}

    public void addPawnToPlayer() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPawn().getPawnName() == "Auto") {
                pawns.get(i).setImage(imageAuto.getImage());
            }
            if (players.get(i).getPawn().getPawnName() == "But") {
                pawns.get(i).setImage(imageBut.getImage());
            }
            if (players.get(i).getPawn().getPawnName() == "Kapelusz") {
                pawns.get(i).setImage(imageKapelusz.getImage());
            }
            if (players.get(i).getPawn().getPawnName() == "Pies") {
                pawns.get(i).setImage(imagePies.getImage());
            }
            if (players.get(i).getPawn().getPawnName() == "Statek") {
                pawns.get(i).setImage(imageStatek.getImage());
            }
            if (players.get(i).getPawn().getPawnName() == "Taczka") {
                pawns.get(i).setImage(imageTaczka.getImage());
            }
        }
    }

    public void drawSpecialCard() {
        numberOfSpecialCard = players.get(turn).numerKarty();
        setSpecialCardImage();
        players.get(turn).takeCard(numberOfSpecialCard);
        pawnPosition.changePawnPosition(pawns.get(turn),players.get(turn).getPawn().getCurrentLocation().getFieldIndex());
        playerMoney.setText("" + players.get(turn).getMoney());
        socialCashBtn.setDisable(true);
        chanceBtn.setDisable(true);
        endOfTurn.setDisable(false);
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
            stage.setTitle("Karty gracza: " + players.get(turn).getPlayerName());
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
