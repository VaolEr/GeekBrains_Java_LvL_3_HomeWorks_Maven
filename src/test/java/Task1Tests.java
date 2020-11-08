
import Lesson6.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Task1Tests {
    private final Integer[] subArray;
    private final int[] initArray;
    private final int subSymbol;

    public Task1Tests(Integer[] subArray, int[] initArray, int subSymbol) {
        this.subArray = subArray;
        this.initArray = initArray;
        this.subSymbol = subSymbol;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1,7},            new int[]{1,2,4,4,2,3,4,1,7}, 4},
                {new Integer[]{2,3,0,1,7},      new int[]{1,2,4,4,2,3,0,1,7}, 4},
                {new Integer[]{1,2,3,0,1,7},    new int[]{1,2,4,1,2,3,0,1,7}, 4},
                {new Integer[]{null},           new int[]{1,2,5,1,2,3,0,1,7}, 4},
                {new Integer[]{null},           new int[]{1,2,4,1,2,3,0,1,7}, 5}
        });
    }

    @Test
    public void returnSubArrayAfterSubElement_TEST(){
        try {
            Assert.assertArrayEquals(subArray, Main.returnSubArrayAfterSubElement(initArray, subSymbol));
        }catch (RuntimeException e){
            e.printStackTrace();
            System.out.println();
        }
    }
}