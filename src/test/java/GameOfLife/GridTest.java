package GameOfLife;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    String[][] gridParameter;

    @BeforeEach
    void createNew2dArray(){

        gridParameter = new String[9][9];
        for (String[] row : gridParameter){
            Arrays.fill(row, "+");
        }
    }


    @Test
    void createGrid(){
        Grid grid = new Grid(9);
        int gridSizeAnswer = 9;
        assertEquals(gridSizeAnswer, grid.getGridSize());
    }

    @Test
    void createGridFrom2dArray(){
        Grid grid = new Grid(gridParameter);
        grid.getGrid();
    }




}
