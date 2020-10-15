package GameOfLife;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {


    @Disabled
    @Test
    void createGridForGame(){
        Grid grid = new Grid(9);
        int gridSizeAnswer = 9;
        assertEquals(gridSizeAnswer, grid.getGridSize());
    }

}
