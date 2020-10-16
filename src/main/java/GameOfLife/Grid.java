package GameOfLife;

import java.util.Arrays;

public class Grid {


    private final int[][] grid;

    public Grid(int gridSize) {
        grid = createEmptyGrid2dArray(gridSize);
    }

    public Grid(int[][] newGrid){
        grid = newGrid;
    }

    public int[][] createEmptyGrid2dArray(int gridSize) {
        return new int[gridSize][gridSize];
    }

    public int size() {
        return grid.length;
    }

    public int[][] getGrid() {
        return grid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid1 = (Grid) o;
        return Arrays.equals(grid, grid1.grid);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(grid);
    }

    @Override
    public String toString() {
        return "Grid{" +
                "grid=" + Arrays.toString(grid) +
                '}';
    }
}
