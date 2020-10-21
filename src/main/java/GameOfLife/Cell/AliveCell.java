package GameOfLife.Cell;

public class AliveCell extends Cell implements CellLifeStatus{




    public AliveCell(int x, int y) {
      super(x,y);
    }



    @Override
    public boolean isAlive() {
        return true;
    }

}
