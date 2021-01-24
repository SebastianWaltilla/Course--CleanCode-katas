package test1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mainPizza {



    public static void main(String[] args) {


        System.out.println("da");
        double sampleInputRadius = 0;
        double sampleInputCrust = 0;


        try{
            System.out.println("hej");
            File myObj = new File("sample.in");
            Scanner myReader = new Scanner(myObj);
            System.out.println("hej");
            String line = myReader.nextLine();
            System.out.println(line);
            String[] twoArguments = line.split(" ");
            sampleInputRadius = Double.parseDouble(twoArguments[0]);
            sampleInputCrust = Double.parseDouble(twoArguments[1]);



        } catch (FileNotFoundException e){
            System.out.println(" då");
            System.out.println("guess i did this wrong.");
        }

        cheeseCalculator(sampleInputRadius, sampleInputCrust);
    }

    private static void cheeseCalculator(double pizzaRadius, double crustSize){

        if (pizzaRadius == crustSize){
            double onlyCrust = 0;
            System.out.println(onlyCrust); // George gets angry.
        }else{
            double PizzaArea =  pizzaRadius * pizzaRadius * Math.PI;
            double CrustArea = PizzaArea - (crustSize * crustSize * Math.PI);
            double CheeseArea = PizzaArea - CrustArea;
            double PercentageCheese =  (CheeseArea / PizzaArea);
            System.out.println(PercentageCheese);
        }
    }
}
