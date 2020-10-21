package GameOfLife.Cell;

public class DeadCell extends Cell implements CellLifeStatus{



    @Override
    public boolean isAlive() {
        return false;
    }


    public DeadCell(int x, int y) {
        this.x = x;
        this.y = y;
    }







}
