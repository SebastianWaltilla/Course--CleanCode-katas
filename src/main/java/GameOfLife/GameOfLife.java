package GameOfLife;

import GameOfLife.Cell.Cell;

import java.util.*;
import java.util.stream.Collectors;

public class GameOfLife {

    int globalCounter = 0;
    private List<Cell> currentGenerationCells;
    //private List<List<Cell>> previousGenerationCells;
    private List<String> allGenerationsAsStringList;


    //private Grid grid;

    public GameOfLife() {
        currentGenerationCells = new ArrayList<>();
        //previousGenerationCells = new ArrayList<>();
        allGenerationsAsStringList = new ArrayList<>();
    }

    public List<Cell> getCurrentGenerationCells() {
        return currentGenerationCells;
    }

    public List<String> getAllGenerationsAsStringList() {
        return allGenerationsAsStringList;
    }

    public void startGame(int[][] grid) {
        convertGridToList(grid);

        do {
            allGenerationsAsStringList.add(convertListOfCellsToString(nextGeneration(currentGenerationCells)));
            // previousGenerationCells.add(nextGeneration(currentGenerationCells));

        } while (patternOfGenerationIsUnique());

        printAllGenerations();
    }

    private void printAllGenerations() {

        allGenerationsAsStringList.forEach(c -> System.out.println("Generation: " + (allGenerationsAsStringList.indexOf(c) + 1) + "\n" + c + "\n"));

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
        allGenerationsAsStringList.add(convertListOfCellsToString(currentGenerationCells));
    }

    public int[][] convertListToGrid(List<Cell> cellList) {
        int maxX = cellList.stream().mapToInt(Cell::getX).max().orElse(0);
        int maxY = cellList.stream().mapToInt(Cell::getY).max().orElse(0);
        int[][] grid = new int[maxX + 1][maxY + 1];
        cellList.forEach(c -> {
            if (c.isAlive())
                grid[c.getX()][c.getY()] = 1;
            else
                grid[c.getX()][c.getY()] = 0;
        });
        return grid;
    }

  /*  public List<List<Cell>> getPreviousGenerationCells() {
        return previousGenerationCells;
    }*/

    public void startGame(int xMaxValue, int yMaxValue) {
        //create cells
        currentGenerationCells = new ArrayList<>();
        for (int k = 0; k < xMaxValue; k++) {
            for (int i = 0; i < yMaxValue; i++) {
                currentGenerationCells.add(new Cell(k, i));
            }
        }
        allGenerationsAsStringList.add(convertListOfCellsToString(nextGeneration(currentGenerationCells)));
//        previousGenerationCells.add(nextGeneration(currentGenerationCells));
    }



    public List<Cell> nextGeneration(List<Cell> cellslist) {

        List<Cell> nextGenCellsCreatedHere2 = new ArrayList<>();

        cellslist.forEach(c->nextGenCellsCreatedHere2.add(generateNextCell(c, getAliveAmountOfNeighbours(c))));

        currentGenerationCells = nextGenCellsCreatedHere2;

        return currentGenerationCells;

    }

    private Cell generateNextCell(Cell c, int aliveNeighbours) {
        Cell newCell = new Cell(c.getX(), c.getY());

        if (aliveNeighbours == 3) {
            newCell.alive();
        } else if (c.isAlive() && aliveNeighbours == 2) {
            newCell.alive();
        }
        return newCell;
    }

    public List<Cell> currentGenerationsCells() {
        return currentGenerationCells;
    }


    public boolean patternOfGenerationIsUnique() {

        //previousGenerationCells.forEach(c -> listsAsString.add(convertListToString(c)));

        return allGenerationsAsStringList.stream().distinct().count() == allGenerationsAsStringList.size();

    }

    public int getAliveAmountOfNeighbours(Cell c) {

        // TODO: 2020-10-26 Lägga denna i Cell-klasen?


        return (int) currentGenerationCells.stream()
                .filter(two -> NeighbourPositions.neighbours(c)
                        .stream()
                        .anyMatch(one -> one.getX() == two.getX() && one.getY() == two.getY()))
                .filter(Cell::isAlive)
                .count();


    }

    @Override
    public String toString() {

        System.out.println("\nGeneration " + allGenerationsAsStringList.size() + ":");
        //System.out.println("\nGeneration " + previousGenerationCells.size() + ":");

        String f = currentGenerationCells.stream()
                // if c = 0       om ja =              :(else)om nej
                .map(c -> c.getY() == 0 ? "\n" + c.toString() : c.toString())
                .collect(Collectors.joining(""));
        ;

        System.out.print(f);
        System.out.println("");
        return f;

    }

    public String convertListOfCellsToString(List<Cell> list) {

        return list.stream()
                // if c = 0       om ja =              :(else)om nej
                .map(c -> c.getY() == 0 ? "\n" + c.toString() : c.toString())
                .collect(Collectors.joining(""));
    }

}
