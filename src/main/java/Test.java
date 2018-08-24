import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

/**
 * @author kamildev7 on 2018-08-24.
 */
public class Test {

    private static Map<String, DoubleBinaryOperator> arithmeticalOperations = Operation.getOperations();
    private Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) {
        String result = new Test().calculateRPNValue(args);

        System.out.println("result: " + result);
    }

    private String calculateRPNValue(String[] rpnString) {
        if (rpnString == null || rpnString.length == 0) {
            throw new NumberFormatException("Wrong rpn String");
        }
        String currentElement;
        for (int i = 0; i < rpnString.length; i++) {
            currentElement = rpnString[i];
            if (isDigit(currentElement)) {
                deque.add(Integer.valueOf(currentElement));
            } else if (arithmeticalOperations.containsKey(currentElement)) {
                int result = makeOperation(currentElement, deque.pollLast(), deque.pollLast());
                deque.add(result);
            } else {
                throw new NumberFormatException("Not a number or operator");
            }
        }
        return String.valueOf(deque.poll());
    }

    private boolean isDigit(String literal) {
        return literal.chars().allMatch(Character::isDigit);
    }

    private int makeOperation(String operator, Integer firstElement, Integer secondElement) {
        Double apply = arithmeticalOperations.get(operator).applyAsDouble(secondElement, firstElement);
        return apply.intValue();
    }
}
