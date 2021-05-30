import Monopoly.Board.Field;
import Monopoly.SpecialCard.SpecialCard;
import org.junit.Test;
import Monopoly.Board.Board;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;


public class BoardTest {

    @Test
    public void boardConstruktorTest() throws RuntimeException {
        List<Field> field = new ArrayList<>();
        Field fieldPoint = new Field(0);
        field.add(fieldPoint);
        List<Field> field2 = new ArrayList<>();
        List<SpecialCard> specialCards = new ArrayList<>();
        Board board = Board.getInstance(field,specialCards);
        Board board2 = Board.getInstance(field2,specialCards);
        Assertions.assertNotEquals(field,field2);
        Assertions.assertEquals(board,board2);
    }
}
