package GameOfLife;

public class Cell {
    private Boolean Alive = false;
    private final int x;
    private final int y;


    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Cell(int x, int y, boolean Alive2) {
        this.x = x;
        this.y = y;
        this.Alive = Alive2;
    }

    public Boolean getAlive() {
        return Alive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
