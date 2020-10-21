package GameOfLife.Cell;

public class AliveCell implements CellLifeStatus{

    private final int x;
    private final int y;

    @Override
    public boolean isAlive() {
        return true;
    }

    public AliveCell(int x, int y) {
        this.x = x;
        this.y = y;
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
