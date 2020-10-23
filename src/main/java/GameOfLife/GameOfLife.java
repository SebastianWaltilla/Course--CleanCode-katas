package GameOfLife;

import GameOfLife.Cell.Cell;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLife {

    private List<int[][]> listOfGenerations;
    private List<Cell> currentGenerationCells;
    private List<List<Cell>> previousGenerationCells;


    //private Grid grid;

    public GameOfLife() {
        currentGenerationCells = new ArrayList<>();
        previousGenerationCells = new ArrayList<>();
    }

    public List<Cell> getCurrentGenerationCells() {
        return currentGenerationCells;
    }

    public void startGame(int[][] grid) {

        convertGridToArray(grid);
    }

    private void convertGridToArray(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {

                Cell c = new Cell(i, j);
                if (grid[i][j] == 1) {
                    c.alive();
                }
                currentGenerationCells.add(c);
            }
        }

    }

    public List<List<Cell>> getPreviousGenerationCells() {
        return previousGenerationCells;
    }

    public void startGame(int xMaxValue, int yMaxValue) {
        //create cells
        currentGenerationCells = new ArrayList<>();
        for (int k = 0; k < xMaxValue; k++) {
            for (int i = 0; i < yMaxValue; i++) {
                currentGenerationCells.add(new Cell(k, i));
            }
        }

        previousGenerationCells.add(nextGeneration(currentGenerationCells));
    }

    public List<Cell> nextGeneration(List<Cell> cellslist) {

        List<Cell> nextGenCellsCreatedHere = new ArrayList<>();

        for (Cell c : cellslist) {
            int amount2 = getAliveAmountOfNeighbours(c.getX(), c.getY());

            if (!c.isAlive()) {
                // "har den tre grannar"
                if (amount2 == 3) {
                    c.alive();
                }
            } else {
                //tre metoder :D
                if (amount2 > 3) {
                    c.kill();
                }
                if (amount2 == 2 || amount2 == 3) {
                    c.alive();
                }
                if (amount2 < 2) {
                    c.kill();
                }
            }
            nextGenCellsCreatedHere.add(c);
        }
        return nextGenCellsCreatedHere;

    }

    @Override
    public String toString() {

        // tomorrow

        return ":";
    }

    public List<Cell> allCells() {
        return currentGenerationCells;
    }


    public List<int[][]> getListOfGenerations() {
        return listOfGenerations;
    }


    public boolean lastGenerationSameAsNext() {

        var lastGen = previousGenerationCells.get(previousGenerationCells.size() - 1);
        var secondLastGen = previousGenerationCells.get(previousGenerationCells.size() - 2);

        int count = (int)lastGen.stream()
                .filter(two -> secondLastGen.stream().noneMatch(one -> one.equals(two))
                ).count();

        return (count == 0);

    }

    public int getAliveAmountOfNeighbours(int xIn, int yIn) {

        List<Cell> cellPosisionOfNeighbors = new ArrayList<>();
        cellPosisionOfNeighbors.add(new Cell(xIn - 1, yIn - 1));
        cellPosisionOfNeighbors.add(new Cell(xIn, yIn - 1));
        cellPosisionOfNeighbors.add(new Cell(xIn + 1, yIn - 1));
        cellPosisionOfNeighbors.add(new Cell(xIn - 1, yIn));
        cellPosisionOfNeighbors.add(new Cell(xIn + 1, yIn));
        cellPosisionOfNeighbors.add(new Cell(xIn - 1, yIn + 1));
        cellPosisionOfNeighbors.add(new Cell(xIn, yIn + 1));
        cellPosisionOfNeighbors.add(new Cell(xIn + 1, yIn + 1));

        int n = (int) currentGenerationCells.stream()
                .filter(two -> cellPosisionOfNeighbors
                        .stream()
                        .anyMatch(one -> one.getX() == two.getX() && one.getY() == two.getY()))
                .filter(Cell::isAlive)
                .count();

        //return numberOfNeighbours;
        return n;
    }

    private Map<Integer, Integer> xAndYPosisionsOfNeighborsAsHashmap() {

        Map<Integer, Integer> xAndYPosisionsOfNeighbors2 = Stream.of(new Integer[][]{
                {-1, -1}, {0, -1}, {1, -1},
                {-1, 0}, {1, 0},
                {-1, 1}, {0, 1}, {1, 1},
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        return xAndYPosisionsOfNeighbors2;
    }


}





       /* int numberOfNeighbours = (int)cellPosisionOfNeighbors.stream()
                                                        .map( s -> grid[xIn + s.getX()][yIn + s.getY()])
                                                        .map(Optional::ofNullable)
                                                        .filter(s -> s.get().equals(1))
                                                        .count();*/