package monopoly;

import Monopoly.Player.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

//import javax.swing.text.html.ImageView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Vector;

public class Cards_Window {

//    public void showContent() {}

    public Vector<Player> players;
    public int turn;

    @FXML
    private Button closeBtn;

    @FXML
    private ImageView propertyCard1;

    @FXML
    private ImageView propertyCard2;

    @FXML
    private ImageView propertyCard3;

    @FXML
    private ImageView propertyCard4;

    @FXML
    private ImageView propertyCard5;

    @FXML
    private ImageView propertyCard6;

    @FXML
    private ImageView propertyCard7;

    @FXML
    private ImageView propertyCard8;

    @FXML
    private ImageView propertyCard9;

    @FXML
    private ImageView propertyCard10;

    @FXML
    private ImageView propertyCard11;

    @FXML
    private ImageView propertyCard12;

    @FXML
    private ImageView propertyCard13;

    @FXML
    private ImageView propertyCard14;

    @FXML
    private ImageView propertyCard15;

    @FXML
    private ImageView propertyCard16;

    @FXML
    private ImageView propertyCard17;

    @FXML
    private ImageView propertyCard18;

    @FXML
    private ImageView propertyCard19;

    @FXML
    private ImageView propertyCard20;

    @FXML
    private ImageView propertyCard21;

    @FXML
    private ImageView propertyCard22;

    @FXML
    private ImageView specialCard1;

    @FXML
    private ImageView specialCard2;

    @FXML
    private ImageView stationCard1;

    @FXML
    private ImageView stationCard2;

    @FXML
    private ImageView stationCard3;

    @FXML
    private ImageView stationCard4;

    @FXML
    private ImageView factoryCard1;

    @FXML
    private ImageView factoryCard2;

    @FXML
    public void initialize() {
        players = Game_Window.players;
        turn = Game_Window.turn;
        if (players.get(turn).getListOfProperties() != null) {
            setPropertyImage();
        }
    }

    public void setPropertyImage() {
        for (int i = 0; i < players.get(turn).getListOfProperties().size(); i++) {
            String path = "\\images\\karty_dzielnice\\";
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 1) {
                path += "dzielnica1.png";
                propertyCard1.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 3) {
                path += "dzielnica2.png";
                propertyCard2.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 6) {
                path += "dzielnica3.png";
                propertyCard3.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 8) {
                path += "dzielnica4.png";
                propertyCard4.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 9) {
                path += "dzielnica5.png";
                propertyCard5.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 11) {
                path += "dzielnica6.png";
                propertyCard6.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 13) {
                path += "dzielnica7.png";
                propertyCard7.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 14) {
                path += "dzielnica8.png";
                propertyCard8.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 16) {
                path += "dzielnica9.png";
                propertyCard9.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 18) {
                path += "dzielnica10.png";
                propertyCard10.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 19) {
                path += "dzielnica11.png";
                propertyCard11.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 21) {
                path += "dzielnica12.png";
                propertyCard12.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 23) {
                path += "dzielnica13.png";
                propertyCard13.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 24) {
                path += "dzielnica14.png";
                propertyCard14.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 26) {
                path += "dzielnica15.png";
                propertyCard15.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 27) {
                path += "dzielnica16.png";
                propertyCard17.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 29) {
                path += "dzielnica17.png";
                propertyCard17.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 31) {
                path += "dzielnica18.png";
                propertyCard18.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 32) {
                path += "dzielnica19.png";
                propertyCard19.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 34) {
                path += "dzielnica20.png";
                propertyCard20.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 37) {
                path += "dzielnica21.png";
                propertyCard21.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 39) {
                path += "dzielnica22.png";
                propertyCard22.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 5) {
                path += "dworzec_zachodni.png";
                stationCard1.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 15) {
                path += "dworzec_gdanski.png";
                stationCard2.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 25) {
                path += "dworzec_wschodni.png";
                stationCard3.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 35) {
                path += "dworzec_centralny.png";
                stationCard4.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 12) {
                path += "elektrownia.png";
                factoryCard1.setImage(new Image(path));
            }
            if(players.get(turn).getListOfProperties().get(i).getFieldIndex() == 28) {
                path += "wodociagi.png";
                factoryCard2.setImage(new Image(path));
            }
        }
    }


}
