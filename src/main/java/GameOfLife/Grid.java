package GameOfLife;

public class Grid {


    private int[][] grid;

    public Grid(int gridSize) {
        grid = createEmptyGrid2dArray(gridSize);
    }

    public Grid(int[][] newGrid){
        grid = newGrid;
    }


    public int[][] createEmptyGrid2dArray(int gridSize) {
        return new int[gridSize][gridSize];
    }


    public int getGridSize() {
        return 9;
    }

    public int[][] getGrid() {
        return grid;
    }
}
