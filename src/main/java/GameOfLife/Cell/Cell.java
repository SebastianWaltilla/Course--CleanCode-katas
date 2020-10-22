package GameOfLife.Cell;

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

        String rep = ".";
            if(alive = true){
            rep = "*";
        }
        return rep;
    }
}
