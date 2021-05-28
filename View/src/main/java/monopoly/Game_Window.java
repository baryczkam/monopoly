package monopoly;

import Monopoly.Board.Board;
import Monopoly.Board.Field;
import Monopoly.Board.PropertyField;
import Monopoly.Player.Pawn;
import Monopoly.Player.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Game_Window {

    private Dice dice;
    private Player player;
    private Board board;
    private PawnPosition pawnPosition;

    @FXML
    private ImageView pionekAuto;

    @FXML
    private Label eyelets;



    public void rollTheDice() throws InterruptedException {
        Field field1 = new Field(0);
        Field field2 = new Field(1);
        Field field3 = new Field(2);
        Field field4 = new Field(3);
        Field field5 = new Field(4);
        Field field6 = new Field(5);
        Field field7 = new Field(6);
        Field field8 = new Field(7);
        Field field9 = new Field(8);
        Field field10 = new Field(9);
        Field field11 = new Field(10);
        Field field12 = new Field(11);
        Field field13 = new Field(12);
        Field field14 = new Field(13);
        Field field15 = new Field(14);
        Field field16 = new Field(15);
        Field field17 = new Field(16);
        Field field18 = new Field(17);
        Field field19 = new Field(18);
        Field field20 = new Field(19);
        Field field21 = new Field(20);
        Field field22 = new Field(21);
        Field field23 = new Field(22);
        Field field24 = new Field(23);
        Field field25 = new Field(24);
        Field field26 = new Field(25);
        Field field27 = new Field(26);
        Field field28 = new Field(27);
        Field field29 = new Field(28);
        Field field30 = new Field(29);
        Field field31 = new Field(30);
        Field field32 = new Field(31);
        Field field33 = new Field(32);
        Field field34 = new Field(33);
        Field field35 = new Field(34);
        Field field36 = new Field(35);
        Field field37 = new Field(36);
        Field field38 = new Field(37);
        Field field39 = new Field(38);
        Field field40 = new Field(39);
        dice = new Dice();
        Field field = new Field(0);
        Pawn pawn = new Pawn(field1,false);
        List<PropertyField> propertyFields = new ArrayList<>();

//        List<Field> fieldList = new ArrayList<>();
//        board = new Board(fieldList);
        List<Field> fields = new ArrayList<>();
        fields.add(field1);
        fields.add(field2);
        fields.add(field3);
        fields.add(field4);
        fields.add(field5);
        fields.add(field6);
        fields.add(field7);
        fields.add(field8);
        fields.add(field9);
        fields.add(field10);
        fields.add(field11);
        fields.add(field12);
        fields.add(field13);
        fields.add(field14);
        fields.add(field15);
        fields.add(field16);
        fields.add(field17);
        fields.add(field18);
        fields.add(field19);
        fields.add(field20);
        fields.add(field21);
        fields.add(field22);
        fields.add(field23);
        fields.add(field24);
        fields.add(field25);
        fields.add(field26);
        fields.add(field27);
        fields.add(field28);
        fields.add(field29);
        fields.add(field30);
        fields.add(field31);
        fields.add(field32);
        fields.add(field33);
        fields.add(field34);
        fields.add(field35);
        fields.add(field36);
        fields.add(field37);
        fields.add(field38);
        fields.add(field39);
        fields.add(field40);
        Board board = Board.getInstance(fields);
        pawnPosition = new PawnPosition("auto");
        player = new Player(100,propertyFields,pawn);
        dice.throwTheDice(player);
        eyelets.setText("" + dice.getNumberOfEyelets());
        int whichField = player.getPawn().getCurrentLocation().getFieldIndex();
        dice.movePawn(board,player);
        pawnPosition.changePawnPosition(pionekAuto,player.getPawn().getCurrentLocation().getFieldIndex(),dice.getNumberOfEyelets());


    }



    public void buyProperty() {}
    public void expandProperty() {}
    public void takeSpecialCard() {}
    public void whoseTurn() {}
    public void prisonField() {}

    @FXML
    private Button saveGameBtn;

    @FXML
    private Button rollTheDice;

    @FXML
    private Button buyProperty;

    @FXML
    private Button endOfTurn;



}
