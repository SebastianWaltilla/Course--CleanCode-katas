package GameOfLife;

import GameOfLife.Cell.Cell;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfLife {

    private List<int[][]> listOfGenerations;
    private List<Cell> allCells;


    //private Grid grid;

    public GameOfLife(){

    }

    public List<Cell> getAllCells() {
        return allCells;
    }

    public void startGame(int xMaxValue, int yMaxValue){
        //create cells
        allCells = new ArrayList<>();
        for (int k = 0; k < xMaxValue; k++) {
            for (int i = 0; i < yMaxValue; i++) {
                allCells.add(new Cell(k, i));
            }
        }
        //setSomeCellsAlive();
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


       /* int numberOfNeighbours = (int)cellPosisionOfNeighbors.stream()
                                                        .map( s -> grid[xIn + s.getX()][yIn + s.getY()])
                                                        .map(Optional::ofNullable)
                                                        .filter(s -> s.get().equals(1))
                                                        .count();*/

        //if is my neighbour count if alive
 /*       // We create a stream of elements from the first list.
        List<SchoolObj> listOneList = listOne.stream()
                // We select any elements such that in the stream of elements from the second list
                .filter(two -> listTwo.stream()
                        // there is an element that has the same name and school as this element,
                        .anyMatch(one -> one.getName().equals(two.getName())
                                && two.getSchool().equals(one.getSchool())))
                // and collect all matching elements from the first list into a new list.
                .collect(Collectors.toList());
        // We return the collected list.
        return listOneList;*/

 int n = (int) allCells.stream()
         .filter(two -> cellPosisionOfNeighbors.stream()
         .anyMatch(one -> one.getX() == two.getX()
        && one.getY() == two.getY()))
         //.filter(c ->c.isAlive())
         .count();

        //return numberOfNeighbours;
        return n;
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


