import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JavaSyntaxTest {


    @Test
    void testMaxSizeStringForGameOfLife(){

        String boardPosision = "b";
        String boardMaxPosisions= "";

        for (int i = 0; i < 360; i++) {
            boardPosision = boardPosision + "a";
        }

        for (int i = 0; i < 1000; i++) {
            boardMaxPosisions = boardMaxPosisions.concat(boardPosision + ",");
        }
        // as mortal developer, ill now know max sixe is not my problem :)
        boardMaxPosisions.substring(boardMaxPosisions.length());
        String[] boardPosisions = new String[30000];

    }

}
