/*
https://osherove.com/tdd-kata-1

The following is a TDD Kata- an exercise in coding, refactoring and test-first, that you should apply daily for at least 15 minutes .

 */


import java.util.Arrays;

public class Calculator {

    /* First only sum two numbers
    public int add(String s){
        if(s.equals("")){
            return 0;
        } else{
            String[] stringAsArray = s.split(",");
            return Integer.parseInt(stringAsArray[0]) + Integer.parseInt(stringAsArray[1]);
        }
    }

    Sum any amout of numbers
    public int add(String s) {
        if (!s.equals("")){

            int[] array = Arrays.asList(s.split(",")).stream().mapToInt(Integer::parseInt).toArray();
            return Arrays.stream(array).sum();
        } else {
            return 0;
        }
    }

    // Sum any amout of numbers

    public int add(String s){
        if(s.equals("")){
            return 0;
        } else{
            String[] stringAsArray = s.split(",");
            return Integer.parseInt(stringAsArray[0]) + Integer.parseInt(stringAsArray[1]);
        }
    }
     */

    //Sum any amout of numbers and allow the Add method to handle new lines between numbers


    public int add(String s) {
        if (!s.equals("")) {

            int[] array = Arrays.asList(s.split(",|\n")).stream().mapToInt(Integer::parseInt).toArray();
            return Arrays.stream(array).sum();
        } else {
            return 0;
        }
    }
}

/*
    public int add(String s) {
        String toBeArray = s;
        String delimiter = ",|\n";

        if (!toBeArray.equals("")){

            if(s.startsWith("//")){
               delimiter = ",|\n|" + toBeArray.charAt(2);
               toBeArray.substring(3,toBeArray.toCharArray().length);
            }

            int[] array = Arrays.asList(toBeArray.split(delimiter)).stream()
                    .mapToInt(Integer::parseInt)
                    .toArray();
            return Arrays.stream(array).sum();
        } else {
            return 0;
        }
    }

 */




