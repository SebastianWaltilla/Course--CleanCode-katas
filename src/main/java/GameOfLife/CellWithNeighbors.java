package GameOfLife;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CellWithNeighbors {

    private final int cell;
    private final List<Integer> cellNeighbors;

    public CellWithNeighbors(int centerCell, Integer[] cells) {

        this.cell = centerCell;
        this.cellNeighbors = Collections.unmodifiableList(Arrays.asList(cells));
    }






}
