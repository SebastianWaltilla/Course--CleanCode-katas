import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import nl.jqno.equalsverifier.*;

public class CalculatorTest {



    @Test
    void createCalculatorAndUseAddMethod(){

        Calculator calculator = new Calculator();
        int sum = calculator.add("3,4");
        int correctAnswer = 7;
        assertEquals(sum, correctAnswer);
    }

    @Test
    void createCalculatorAndUseAddMethodWhenInputIsZero(){

        Calculator calculator = new Calculator();
        int sum = calculator.add("");
        int correctAnswer = 0;
        assertEquals(sum, correctAnswer);
    }

    @Test
    void createCalculatorAndUseAddMethodWithLineBreaks(){

        Calculator calculator = new Calculator();
        int sum = calculator.add("3,4\n7");
        int correctAnswer = 14;
        assertEquals(sum, correctAnswer);
    }
/*
    @Test
    void createCalculatorAndUseAddMethodWithNewDelimiter(){

        Calculator calculator = new Calculator();
        int sum = calculator.add("//;\n1;2");
        int correctAnswer = 14;
        assertEquals(sum, correctAnswer);
    }

 */
}
