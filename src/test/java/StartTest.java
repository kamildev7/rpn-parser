import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author kamildev7 on 2018-08-24.
 */
public class StartTest {

    private Start start;

    @Before
    public void setUp() throws Exception {
        start = new Start();
    }

    @Test
    public void mainTest() throws Exception {
        System.out.println("main");
        String consoleInput = "console console 3 11 + 5 -";
        assertEquals(9, consoleInput.split(" "));
    }
}