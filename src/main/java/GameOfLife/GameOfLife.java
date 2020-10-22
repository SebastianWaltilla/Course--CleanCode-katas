package GameOfLife;

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

    public int getAliveAmountOfNeighbours(int x, int y) {

        int[][] grid = new int[][]{
                {1, 0, 0},
                {1, 1, 0},
                {1, 0, 1}
        };

        Map<Integer, Integer> xAndYPosisionsOfNeighbors2 = Stream.of(new Integer[][] {
                {-1, -1},{0, -1},{1, -1},
                {-1, 0},         {1, 0},
                {-1, 1}, {0, 1}, {1, 1},
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));


        int numberOfNeighbors = xAndYPosisionsOfNeighbors2
                                                                        .entrySet()
                                                                        .stream()
                                                                        .mapToInt( s  -> grid[s.getKey()][s.getValue()])// här borde det vara .orElse(0)
                                                                        .filter(b -> equals(1))
                                                                        .c



                //filter( e -> grid[e.getKey()][e.getValue()])




        int[][] currentGen = listOfGenerations.get(listOfGenerations.size()-1);
        int numberOfNeighbours = 0;

        if(currentGen[x+1][y] == 1)
            numberOfNeighbours++;
        if(currentGen[x+1][y+1] == 1)
            numberOfNeighbours++;
        if(currentGen[x][y+1] == 1)
            numberOfNeighbours++;


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


