package GameOfLife;
import GameOfLife.Cell.Cell;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class GameOfLifeTest {
    GameOfLife gol;

    @BeforeEach
    void createFilledGrid2dArray(){
        gol = new GameOfLife();

    }


    @Test
    void whenStartGameGridShouldBeEqualToStartGrid() {
        gol.startGame(3,3);
        assertEquals(9,gol.allCells().size());

    }

    @Test
    void checkIfLastGenerationIsEqualToNextGeneration(){
        List<Cell> one = new ArrayList<>();
        List<Cell> two = new ArrayList<>();

        one.add(new Cell(0,0));
        one.add(new Cell(2,0));

        two.add(new Cell(0,0));
        Cell cell = new Cell(2,0);
        two.add(cell);

        gol.getPreviousGenerationCells().add(one);
        gol.getPreviousGenerationCells().add(two);

        assertTrue(gol.lastGenerationSameAsNext());
    }

    @Test
    void getAliveNeighboursOfCornerCaseCell() {
        int[][] grid = new int[][]{
                {0,1,0,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,1,1,1,0,0,0}
        };

        gol.startGame(grid);
        assertEquals(3,gol.getAliveAmountOfNeighbours(0,0));

    }

    @Test
    void getAliveNeighborsOfCenterCaseCell(){
        int[][] grid2 = new int[][]{
                {0,1,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,1,1,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,1,1,1,0,0,0}
        };

        gol.startGame(grid2);

        assertEquals(5,gol.getAliveAmountOfNeighbours(1,1));

    }

    @Test
    void startGameWithGridSizeCreateCellObjects() {
        gol.startGame(3,3);

    }

    @Test
    void givenGridMaxSizeCellsSHouldBeCreated() {
        gol.startGame(3,3);
        assertEquals(9, gol.getCurrentGenerationCells().size());
    }

    @Test
    void addAliveCellsToListWithCellsCheckIfAlive(){
        gol.startGame(10,10);
        gol.getCurrentGenerationCells().get(92).alive();
        gol.getCurrentGenerationCells().get(93).alive();
        gol.getCurrentGenerationCells().get(94).alive();
        gol.getCurrentGenerationCells().get(95).alive();
        gol.getAliveAmountOfNeighbours(5,8);
        assertEquals(2, gol.getAliveAmountOfNeighbours(9,4));
    }




    @Test
    @DisplayName("1. Any live cell with fewer than two live neighbors" +
            " dies, as if caused by underpopulation.")
    void aliveCellHasFewerThanTwoNeighbors(){




    }

    @Test
    void convertGridToArray_test() {
       int[][] grid2 = new int[][]{
               {0,0,0,0,0,0,0,0,0,0},
               {0,0,0,0,0,0,0,0,0,0},
               {0,0,0,0,0,0,0,0,0,0},
               {0,0,0,1,0,0,0,0,0,0},
               {0,0,0,1,0,0,0,0,0,0},
               {0,0,0,1,0,0,0,0,0,0},
               {0,0,0,1,1,1,0,0,0,0},
               {0,0,0,0,0,0,0,0,0,0},
               {0,0,0,0,0,0,0,0,0,0},
               {0,0,0,1,1,1,1,0,0,0}
       };

       gol.startGame(grid2);

        assertEquals(100, gol.getCurrentGenerationCells().size());
       assertTrue(gol.getCurrentGenerationCells().get(94).isAlive());

    }

    /*



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