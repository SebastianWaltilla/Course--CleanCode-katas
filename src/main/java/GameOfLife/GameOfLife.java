package GameOfLife;

public class GameOfLife {

    private Grid grid;

    public GameOfLife(Grid newGrid) {
    grid = newGrid;
    }

    public Grid getGrid() {
        return grid;
    }

    public void startNewGame(Grid newGrid) {
        grid = newGrid;
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


