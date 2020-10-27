package GameOfLife;

import GameOfLife.Cell.Cell;

import java.util.*;
import java.util.stream.Collectors;

public class GameOfLife {

    private List<Cell> currentGenerationCells;
    private List<String> allGenerationsAsStringList;

    public GameOfLife() {
        currentGenerationCells = new ArrayList<>();
        allGenerationsAsStringList = new ArrayList<>();
    }

    public void startGame(int[][] grid) {
        convertGridToList(grid);

        do {
            allGenerationsAsStringList.add(convertListOfCellsToString(nextGeneration(currentGenerationCells)));

        } while (patternOfGenerationIsUnique());

        printAllGenerations();
    }

    public List<Cell> getCurrentGenerationCells() {
        return currentGenerationCells;
    }

    public List<String> getAllGenerationsAsStringList() {
        return allGenerationsAsStringList;
    }

    private void printAllGenerations() {

        allGenerationsAsStringList.forEach(c ->
                System.out.println("Generation: " + (allGenerationsAsStringList.indexOf(c) + 1)
                        + "\n" + c + "\n"));
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

    private List<Cell> nextGeneration(List<Cell> cellslist) {

        List<Cell> nextGenCellsCreatedHere2 = new ArrayList<>();

        cellslist.forEach(c -> nextGenCellsCreatedHere2.add(generateNextCell(c, getAliveAmountOfNeighbours(c))));

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

    public boolean patternOfGenerationIsUnique() {

        return allGenerationsAsStringList.stream().distinct().count() == allGenerationsAsStringList.size();
    }

    public int getAliveAmountOfNeighbours(Cell c) {

        return (int) currentGenerationCells.stream()
                .filter(two -> NeighbourPositions.neighbours(c)
                        .stream()
                        .anyMatch(one -> one.getX() == two.getX() && one.getY() == two.getY()))
                .filter(Cell::isAlive)
                .count();
    }

    @Override
    public String toString() {

        String f = currentGenerationCells.stream()
                .map(c -> c.getY() == 0 ? "\n" + c.toString() : c.toString())
                .collect(Collectors.joining(""));
        return f;

    }

    public String convertListOfCellsToString(List<Cell> list) {

        return list.stream()
                .map(c -> c.getY() == 0 ? "\n" + c.toString() : c.toString())
                .collect(Collectors.joining(""));
    }

}
