package GameOfLife;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {



    @Test
    void createGridForGame(){
        Board grid = new Board(9);
        int gridSizeAnswer = 9;
        assertEquals(gridSizeAnswer, grid.getBoardSize());
    }

}
