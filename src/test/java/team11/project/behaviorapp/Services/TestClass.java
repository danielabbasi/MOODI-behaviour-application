package team11.project.behaviorapp.Services;

/**
 * Created by c1673218 on 20/03/2018.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class TestClass {
    @Test
    public void testConcatenate() {
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate("one", "two");

        assertEquals("onetwo", result);

    }

}