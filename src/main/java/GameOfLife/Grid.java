package GameOfLife;

public class Grid {


    private int[][] grid;

    public Grid(int gridSize) {
        grid = createEmptyGrid2dArray(gridSize);
    }
    public Grid(Grid grid) {
    }

    public int getGridSize() {
        return 9;
    }

    public int[][] getGrid() {
        return grid;
    }
}