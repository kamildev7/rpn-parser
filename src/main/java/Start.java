import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;

/**
 * @author kamildev7 on 2018-08-24.
 */
public class Start {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Start.class);
        /* pattern: input output expression
        console console 3 11 + 5 - */
        try {
            String[] expression = getExpressionFromInput(args);
            String result = new RPNCalculator().calculateRPNValue(expression);
            saveResultToOutput(result, args[1]);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Wrong arguments");
        }
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
