package GameOfLife;

import GameOfLife.Cell.Cell;

import java.util.*;
import java.util.stream.Collectors;

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
        convertGridToList(grid);

        do {
            previousGenerationCells.add(nextGeneration(currentGenerationCells));
            toString();
        }while (!lastGenerationSameAsErlierGeneration());
    }

    public void convertGridToList(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

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
            int numberOfNeighbors = getAliveAmountOfNeighbours(c.getX(), c.getY());
            Cell newCell = new Cell(c.getX(), c.getY());

            if (!c.isAlive()) {
                // "har den tre grannar"
                if (numberOfNeighbors == 3) {
                    newCell.alive();
                }
            } else {
                //tre metoder :D
                if (numberOfNeighbors > 3) {
                    newCell.kill();
                }
                if (numberOfNeighbors == 2 || numberOfNeighbors == 3) {
                    newCell.alive();
                }
                if (numberOfNeighbors < 2) {
                    newCell.kill();
                }
            }
            nextGenCellsCreatedHere.add(newCell);
        }
        currentGenerationCells = nextGenCellsCreatedHere;


        return nextGenCellsCreatedHere;

    }



    public List<Cell> currentGenerationsCells() {
        return currentGenerationCells;
    }


    public List<int[][]> getListOfGenerations() {
        return listOfGenerations;
    }


    public boolean lastGenerationSameAsErlierGeneration() {

        if(previousGenerationCells.size() < 3) {
            return false;
        }

        for (int i = 2; i < previousGenerationCells.size(); i++) {


            int count = 0;
                var lastGen = previousGenerationCells.get(previousGenerationCells.size() - 1);
                var secondLastGen = previousGenerationCells.get(previousGenerationCells.size() - i);

                count = (int)lastGen.stream()
                        .filter(two -> secondLastGen.stream().noneMatch(one -> one.equals(two))
                        ).count();

                if (count == 0);
                        return true;
            }

        return false;
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

    @Override
    public String toString() {


        String f = currentGenerationCells.stream()
                        // if c = 0       om ja =              :(else)om nej
                .map(c-> c.getY() == 0 ? "\n" + c.toString()  : c.toString())
                .collect(Collectors.joining(""));;

        System.out.print(f);
        System.out.println("");
        return f;

    }
}





       /* int numberOfNeighbours = (int)cellPosisionOfNeighbors.stream()
                                                        .map( s -> grid[xIn + s.getX()][yIn + s.getY()])
                                                        .map(Optional::ofNullable)
                                                        .filter(s -> s.get().equals(1))
                                                        .count();*/