import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author kamildev7 on 2018-08-24.
 */
public class RPNCalculatorTest {

    RPNCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new RPNCalculator();
    }

    @Test(expected = NumberFormatException.class)
    public void testNullParameter() {
        calculator.calculateRPNValue(null);
    }

    @Test(expected = NumberFormatException.class)
    public void testEmptyParameter() {
        calculator.calculateRPNValue(new String[0]);
    }

    @Test(expected = NumberFormatException.class)
    public void calculateRPNValueShouldThrowException() {
        calculator.calculateRPNValue("12 # 4 +".split(" "));
    }

    @Test
    public void calculateRPNValueTest() throws Exception {
        int test1 = Integer.parseInt(calculator.calculateRPNValue("3 11 5 + -".split(" ")));
        int test2 = Integer.parseInt(calculator.calculateRPNValue("3 11 + 5 -".split(" ")));

        assertEquals(-13, test1);
        assertEquals(9, test2);
    }
}