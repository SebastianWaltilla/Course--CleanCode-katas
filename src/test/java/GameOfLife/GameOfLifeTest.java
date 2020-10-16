package GameOfLife;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {


    @Test
    void checkIfGridOnlyContains0And1s(){
        Grid grid = new Grid(gridSize19);
        assertTrue(grid.correctSetup());
    }



    @Test
    @DisplayName("1. Any live cell with fewer than two live neighbors" +
            " dies, as if caused by" +
            "    underpopulation.")
    void checkIfCellIsAlive(){

        Grid grid = new Grid(20);
        GameOfLife gol = new GameOfLife();

        gol.create(grid);

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