package GameOfLife;
import java.util.Arrays;

public class Grid {

    private final int[][] gridArray;

    public Grid(int gridSize) {
        gridArray = createEmptyGrid2dArray(gridSize);
    }

    public Grid(int[][] newGrid){
        gridArray = newGrid;
    }

    public int[][] createEmptyGrid2dArray(int gridSize) {
        return new int[gridSize][gridSize];
    }

    public int size() {
        return gridArray.length;
    }

    public int[][] getGridArray() {
        return gridArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid1 = (Grid) o;
        return Arrays.equals(gridArray, grid1.gridArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(gridArray);
    }

    @Override
    public String toString() {
        String gridString = "";
        for (int row = 0; row < gridArray.length; row++) {
            for (int col = 0; col < gridArray[row].length; col++) {
                gridString = gridString + gridArray[row][col] + "\t";
            }
            gridString = gridString + "\n";
        }
        return gridString;
    }
}
