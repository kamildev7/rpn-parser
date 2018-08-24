import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

/**
 * @author kamildev7 on 2018-08-24.
 */
public enum Operation {

    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    public static Map<String, DoubleBinaryOperator> getOperations() {
        Map<String, DoubleBinaryOperator> operations = new HashMap<>();
        operations.put("+", Operation.PLUS.getOp());
        operations.put("-", Operation.MINUS.getOp());
        return operations;
    }

    public String getSymbol() {
        return symbol;
    }

    public DoubleBinaryOperator getOp() {
        return op;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
