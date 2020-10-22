package GameOfLife;

import GameOfLife.Cell.Cell;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLife {

    private List<int[][]> listOfGenerations;

    //private Grid grid;

    public GameOfLife(){

    }

    /*public GameOfLife(Grid newGrid) {
    grid = newGrid;
    }

    public Grid getGrid() {
        return grid;
    }

    public void startNewGame(Grid newGrid) {
        grid = newGrid;
    }
*/

    public void startGame(int[][] grid){
        listOfGenerations = new ArrayList<>();
        listOfGenerations.add(grid);
    }

    public List<int[][]> getListOfGenerations(){
        return listOfGenerations;
    }


    public int[][] nextGeneration() {
        return listOfGenerations.get(listOfGenerations.size()-1);
    }

    public boolean lastGenerationSameAsNext() {
        return Arrays.equals(listOfGenerations.get(listOfGenerations.size() - 1), listOfGenerations.get(listOfGenerations.size() - 2));
    }

    public int getAliveAmountOfNeighbours(int xIn, int yIn) {

        Integer[][] grid = new Integer[][]{
                {1, 0, 0},
                {1, 1, 0},
                {1, 0, 1}
        };

        List<Cell> cellPosisionOfNeighbors = new ArrayList<>();
        cellPosisionOfNeighbors.add(new Cell(-1, -1));
        cellPosisionOfNeighbors.add(new Cell(0, -1));
        cellPosisionOfNeighbors.add(new Cell(1, -1));
        cellPosisionOfNeighbors.add(new Cell(-1, 0));
        cellPosisionOfNeighbors.add(new Cell(1, 0));
        cellPosisionOfNeighbors.add(new Cell(-1, 1));
        cellPosisionOfNeighbors.add(new Cell(0, 1));
        cellPosisionOfNeighbors.add(new Cell(1, 1));


        int numberOfNeighbours = (int)cellPosisionOfNeighbors.stream()
                                                        .map( s -> grid[xIn + s.getX()][yIn + s.getY()])
                                                        .map(Optional::ofNullable)
                                                        .filter(s -> s.get().equals(1))
                                                        .count();
        return numberOfNeighbours;
    }





    private Map<Integer, Integer> xAndYPosisionsOfNeighborsAsHashmap(){

        Map<Integer, Integer> xAndYPosisionsOfNeighbors2 = Stream.of(new Integer[][] {
                {-1, -1},{0, -1},{1, -1},
                {-1, 0},         {1, 0},
                {-1, 1}, {0, 1}, {1, 1},
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        return xAndYPosisionsOfNeighbors2;
    }
}


