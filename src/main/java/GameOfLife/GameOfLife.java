package GameOfLife;

import GameOfLife.Cell.Cell;

import java.util.*;
import java.util.stream.Collectors;

public class GameOfLife {

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

        } while (patternOfGenerationsDoesntRepeats());

        printAllGenerations();
    }

    private void printAllGenerations() {

        previousGenerationCells.forEach(c -> System.out.println("Generation: " + (previousGenerationCells.indexOf(c) + 1) + "\n" +
                convertListToString(c) +
                "\n"));


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
        previousGenerationCells.add(currentGenerationCells);
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


    public boolean patternOfGenerationsDoesntRepeats() {

        List<String> listsAsString = new ArrayList<>();

        previousGenerationCells.forEach(c -> listsAsString.add(convertListToString(c)));

        return listsAsString.stream().distinct().count() == listsAsString.size();

    }

    public int getAliveAmountOfNeighbours(int xIn, int yIn) {

        List<Cell> cellPositionOfNeighbours = new ArrayList<>();
        cellPositionOfNeighbours.add(new Cell(xIn - 1, yIn - 1));
        cellPositionOfNeighbours.add(new Cell(xIn, yIn - 1));
        cellPositionOfNeighbours.add(new Cell(xIn + 1, yIn - 1));
        cellPositionOfNeighbours.add(new Cell(xIn - 1, yIn));
        cellPositionOfNeighbours.add(new Cell(xIn + 1, yIn));
        cellPositionOfNeighbours.add(new Cell(xIn - 1, yIn + 1));
        cellPositionOfNeighbours.add(new Cell(xIn, yIn + 1));
        cellPositionOfNeighbours.add(new Cell(xIn + 1, yIn + 1));

        return (int) currentGenerationCells.stream()
                .filter(two -> cellPositionOfNeighbours
                        .stream()
                        .anyMatch(one -> one.getX() == two.getX() && one.getY() == two.getY()))
                .filter(Cell::isAlive)
                .count();


    }

    @Override
    public String toString() {


        System.out.println("\nGeneration " + previousGenerationCells.size() + ":");

        String f = currentGenerationCells.stream()
                // if c = 0       om ja =              :(else)om nej
                .map(c -> c.getY() == 0 ? "\n" + c.toString() : c.toString())
                .collect(Collectors.joining(""));
        ;

        System.out.print(f);
        System.out.println("");
        return f;

    }

    public String convertListToString(List<Cell> list) {

        String f = list.stream()
                // if c = 0       om ja =              :(else)om nej
                .map(c -> c.getY() == 0 ? "\n" + c.toString() : c.toString())
                .collect(Collectors.joining(""));
        ;


        return f;
    }


}





       /* int numberOfNeighbours = (int)cellPosisionOfNeighbors.stream()
                                                        .map( s -> grid[xIn + s.getX()][yIn + s.getY()])
                                                        .map(Optional::ofNullable)
                                                        .filter(s -> s.get().equals(1))
                                                        .count();*/