/**
 * @author kamildev7 on 2018-08-24.
 */
public class Start {
    public static void main(String[] args) {
        String result = new RPNCalculator().calculateRPNValue(args);
        System.out.println("result: " + result);
    }
}
