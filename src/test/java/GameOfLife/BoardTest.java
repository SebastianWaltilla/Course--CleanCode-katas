package GameOfLife;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {





    @Test
    void createGridForGame(){
        Grid grid = new Grid(9);
        int gridSizeAnswer = 9;
        assertEquals(gridSizeAnswer, grid.getGridSize());
    }

    @Test
    void CreateNewGridWithOldGrid(){
        Grid grid = new Grid(9);
        Grid newGrid = new Grid(grid);
        assertTrue(newGrid instanceof Grid);
    }

    @Test
    void createStartGridWhereEmptyPosisionIsFilledWithAPlus(){
        Grid grid = new Grid(19);
        grid.getGrid().get;


    }


}
