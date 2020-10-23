package GameOfLife.Cell;

import java.util.Objects;

public class Cell {

    private final int x;
    private final int y;
    private boolean alive;

    public Cell(int x2, int y2) {
        x = x2;
        y = y2;
    }




    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAlive() {
        return alive;
    }

    public void alive() {
        this.alive = true;
    }

    public void kill() {
        alive = false;
    }

    @Override
    public String toString() {

        String rep = ".,";
            if(isAlive()){
            rep = "*,";
            }
        return rep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y &&
                alive == cell.alive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, alive);
    }
}
