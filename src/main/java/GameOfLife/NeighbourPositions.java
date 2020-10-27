package GameOfLife;
import GameOfLife.Cell.Cell;
import java.util.ArrayList;
import java.util.List;

public class NeighbourPositions {

    public static List<Cell> neighbours(Cell cell){
        int xIn = cell.getX();
        int yIn = cell.getY();


    List<Cell> cellPositionOfNeighbours = new ArrayList<>();
        cellPositionOfNeighbours.add(new Cell(xIn - 1, yIn - 1));
        cellPositionOfNeighbours.add(new Cell(xIn, yIn - 1));
        cellPositionOfNeighbours.add(new Cell(xIn + 1, yIn - 1));
        cellPositionOfNeighbours.add(new Cell(xIn - 1, yIn));
        cellPositionOfNeighbours.add(new Cell(xIn + 1, yIn));
        cellPositionOfNeighbours.add(new Cell(xIn - 1, yIn + 1));
        cellPositionOfNeighbours.add(new Cell(xIn, yIn + 1));
        cellPositionOfNeighbours.add(new Cell(xIn + 1, yIn + 1));

        return cellPositionOfNeighbours;
    }

}
