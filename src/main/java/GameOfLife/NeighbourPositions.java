package GameOfLife;
import GameOfLife.Cell.Cell;
import java.util.ArrayList;
import java.util.List;

public class NeighbourPositions {

    public static List<Cell> neighbours(Cell cell){

    List<Cell> cellPositionOfNeighbours = new ArrayList<>();
        cellPositionOfNeighbours.add(downLeft(cell));
        cellPositionOfNeighbours.add(down(cell));
        cellPositionOfNeighbours.add(downRight(cell));
        cellPositionOfNeighbours.add(left(cell));
        cellPositionOfNeighbours.add(right(cell));
        cellPositionOfNeighbours.add(aboveLeft(cell));
        cellPositionOfNeighbours.add(above(cell));
        cellPositionOfNeighbours.add(aboveRight(cell));

        return cellPositionOfNeighbours;
    }

    private static  Cell downLeft(Cell c){
        return new Cell(c.getX() -1, c.getY() -1);
    }

    private static  Cell down(Cell c){
        return new Cell(c.getX(), c.getY() -1);
    }
    private static  Cell downRight(Cell c){
        return new Cell(c.getX() +1, c.getY() -1);
    }

    private static  Cell left(Cell c){
        return new Cell(c.getX() -1, c.getY());
    }

    private static  Cell right(Cell c){
        return new Cell(c.getX() +1, c.getY());
    }

    private static  Cell aboveLeft(Cell c){
        return new Cell(c.getX() -1, c.getY()+1);
    }

    private static  Cell above(Cell c){
        return new Cell(c.getX(), c.getY()+1);
    }

    private static Cell aboveRight(Cell c){
        return new Cell(c.getX()+1, c.getY()+1);
    }
}
