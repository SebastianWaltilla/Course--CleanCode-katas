package GameOfLife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    Grid grid;
    GameOfLife gol;

    @BeforeEach
    void init(){
        Grid grid = new Grid(20);
        GameOfLife gol = new GameOfLife(grid);
    }

    @Test
    @DisplayName("1. Any live cell with fewer than two live neighbors" +
            " dies, as if caused by underpopulation.")
    void CheckNumbersOfNeighborsForeSpecificCell(){
        gol.startNewGame();
    }



    @Test

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