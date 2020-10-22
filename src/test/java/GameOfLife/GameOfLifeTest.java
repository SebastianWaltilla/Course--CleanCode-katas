package GameOfLife;
import GameOfLife.Cell.Cell;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class GameOfLifeTest {
    GameOfLife gol;
    Grid testGrid;
    int[][] grid;
    private List<Cell> allCells;

    @BeforeEach
    void createFilledGrid2dArray(){

        gol = new GameOfLife();
        gol.startGame(grid);
        gol.startGame(3,3);

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
        gol.startGame(3,3);
        assertEquals(9,gol.allCells().size());

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