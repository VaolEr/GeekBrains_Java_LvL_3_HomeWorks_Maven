import Lesson6.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Task2Tests {

    boolean result;
    private final int[] array;
    private final int element1;
    private final int element2;

    public Task2Tests(boolean result, int[] array, int element1, int element2) {
        this.result = result;
        this.array = array;
        this.element1 = element1;
        this.element2 = element2;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {true, new int[]{1, 1, 1, 4, 4, 1, 4, 4}, 1, 4},
                {false, new int[]{1, 1, 1, 4, 4, 1, 4, 4}, 1, 5},
                {false, new int[]{1, 1, 1, 1, 1, 1}, 1, 4},
                {false, new int[]{4, 4, 4, 4}, 4, 1},
                {false, new int[]{1, 4, 4, 1, 1, 4, 3}, 4, 1}
        });
    }

    @Test
    public void returnSubArrayAfterSubElement_TEST(){
        if(result){
            Assert.assertTrue(Main.checkArrayOnElementsPresent(array,element1,element2));
        }else {
            Assert.assertFalse(Main.checkArrayOnElementsPresent(array, element1, element2));
        }
    }
}
