package GameOfLife;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class GameOfLifeTest {
    GameOfLife gol;
    Grid testGrid;
    int[][] grid;

    @BeforeEach
    void createFilledGrid2dArray(){
         int[][] gridAsArray = new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0}
        };

        grid = new int[][]{
                {1, 0, 0},
                {1, 1, 0},
                {1, 0, 1}
        };


        gol = new GameOfLife();
        gol.startGame(grid);
        gol.startGame(3,3);

        //testGrid = new Grid(gridOfInts);
        //gol = new GameOfLife(testGrid);
    }

    @Disabled
    @Test
    void checkSameGridIsInGolInstance(){
        // assertEquals(gol.getGrid().getGridArray(), testGrid.getGridArray());
    }

    @Disabled
    @Test
    @DisplayName("if value is 1, cell is alive")
    void checkIfCellIsAlive(){
        //assertEquals(gol.getGrid().getGridArray()[0][0], 1);
    }

    @Disabled
    @Test
    void turnIntToCell(){
       //assertTrue(gol.turnIntToCell(1));
    }
    @Disabled
    @Test
    @DisplayName("if value is 1, cell is alive")
    void checkIfCellIsAliveInNextGeneration(){
       // assertEquals(gol.getGrid().getGridArray()[0][0], 1);
    }

    @Test
    void whenStartGameGridShouldBeEqualToStartGrid() {


        assertEquals(grid,gol.nextGeneration());

    }

    @Test
    void checkIfLastGenerationIsEqualToNextGeneration(){
        gol.getListOfGenerations().add(grid);
        assertTrue(gol.lastGenerationSameAsNext());
    }

    @Test
    void getAliveNeighboursOfCornerCaseCell() {

        assertEquals(3,gol.getAliveAmountOfNeighbours(0,0));

    }

    @Test
    void getAliveNeighborsOfCenterCaseCell(){

        assertEquals(8,gol.getAliveAmountOfNeighbours(1,1));

    }

    @Test
    void startGameWithGridSizeCreateCellObjects() {
        gol.startGame(3,3);

    }

    @Test
    void givenGridMaxSizeCellsSHouldBeCreated() {
        gol.startGame(3,3);
        assertEquals(9, gol.getAllCells().size());
    }




    /*

        @DisplayName("1. Any live cell with fewer than two live neighbors" +
            " dies, as if caused by underpopulation.")

    }
    @Test
    @DisplayName(" 2. Any live cell with more than three live neighbors dies, as if by" +
            "    overcrowding.")
    void method2(){

    }
    @Test
    @DisplayName(" 3. Any live cell with two or three live neighbors lives on to the next" +
            "    generation.")
    void method3(){

    }
    @Test
    @DisplayName("4. Any dead cell with exactly three live neighbors becomes a live cell.")
    void method4(){

    }

     */






}