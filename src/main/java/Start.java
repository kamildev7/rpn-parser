import java.util.InputMismatchException;

/**
 * @author kamildev7 on 2018-08-24.
 */
public class Start {
    public static void main(String[] args) {
        /* pattern: input output expression
        console console 3 11 + 5 - */
        String[] expression = getExpressionFromInput(args);
        String result = new RPNCalculator().calculateRPNValue(expression);
        saveResultToOutput(result, args[1]);
    }

    private static String[] getExpressionFromInput(String[] consoleInput) {
        if (consoleInput == null || consoleInput.length == 0) {
            throw new InputMismatchException("Wrong arguments");
        }
        int arrayLength = consoleInput.length;
        String[] rpnExpression = new String[arrayLength-2];
        String inputType = consoleInput[0];

        switch (inputType) {
            case "console":
                System.arraycopy(consoleInput, 2, rpnExpression, 0, arrayLength-2);
                break;
        }
        return rpnExpression;
    }

    private static void saveResultToOutput(String result, String outputType) {
        switch (outputType) {
            case "console":
                System.out.println("result: " + result);
                break;
        }
    }
}
