package GameOfLife;

import GameOfLife.Cell.Cell;

import java.util.*;
import java.util.stream.Collectors;

public class GameOfLife {

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

        allGenerationsAsStringList.forEach(c->System.out.println("Generation: " + (allGenerationsAsStringList.indexOf(c) + 1) + "\n" + c + "\n"));

        /*
        previousGenerationCells.forEach(c -> System.out.println("Generation: " + (previousGenerationCells.indexOf(c) + 1) + "\n" +
                convertListToString(c) +
                "\n"));
*/

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

    public int[][] convertListToGrid(List<Cell> cellList){
        int maxX = cellList.stream().mapToInt(Cell::getX).max().orElse(0);
        int maxY = cellList.stream().mapToInt(Cell::getY).max().orElse(0);
        int[][] grid = new int[maxX+1][maxY+1];
        cellList.forEach(c -> {
            if(c.isAlive())
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
                if (numberOfNeighbors > 3 || numberOfNeighbors < 2) {
                    newCell.kill();
                }
                if (numberOfNeighbors == 2 || numberOfNeighbors == 3) {
                    newCell.alive();
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


    public boolean patternOfGenerationIsUnique() {

        //previousGenerationCells.forEach(c -> listsAsString.add(convertListToString(c)));

        return allGenerationsAsStringList.stream().distinct().count() == allGenerationsAsStringList.size();

    }

    public int getAliveAmountOfNeighbours(int xIn, int yIn) {

        // TODO: 2020-10-26 Lägga denna i Cell-klasen?

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





       /* int numberOfNeighbours = (int)cellPosisionOfNeighbors.stream()
                                                        .map( s -> grid[xIn + s.getX()][yIn + s.getY()])
                                                        .map(Optional::ofNullable)
                                                        .filter(s -> s.get().equals(1))
                                                        .count();*/