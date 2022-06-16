import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static final Operator ADDITION = new Addition();
    private static final Operator SUBTRACTION = new Subtraction();
    private static final Operator MULTIPLICATION = new Multiplication();
    private static final Map<String,Operator> OPERATORS = new HashMap<>();
    static {
        OPERATORS.put("+",ADDITION);
        OPERATORS.put("-",SUBTRACTION);
        OPERATORS.put("*",MULTIPLICATION);
    }

    public String Calculate(String operator, Integer operand1, Integer operand2) {
        Operator op = OPERATORS.get(operator);
        if( op == null){ return "Invalid operator";}
        else{ return String.valueOf(op.calculate(operand1,operand2));}
    }
}