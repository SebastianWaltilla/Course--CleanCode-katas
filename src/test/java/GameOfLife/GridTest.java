package GameOfLife;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    int[][] gridParameter;

    @BeforeEach
    void createNew2dArray(){

        gridParameter = new int[9][9];
        for (int[] row : gridParameter){
            Arrays.fill(row, 1);
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
