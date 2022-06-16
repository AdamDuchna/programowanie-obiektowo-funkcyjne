import java.util.regex.Pattern;

public class Rpn {
    private static final Pattern pattern = Pattern.compile("-?\\d+");
    private static Stack stack = new Stack();
    private static final Calculator calculator = new Calculator();

    private static boolean isNumeric(String input){
        return pattern.matcher(input).matches();
    }
    public static String calcExpression(String input){
        stack = new Stack();
        String[] symbols = input.split(" ");
        for (String symbol : symbols) {
            if (isNumeric(symbol)){ stack.push(symbol); }
            else {
                String result = foundMathSymbol(symbol);
                if(isNumeric(result)){stack.push(result);}
                else{ return result;}
            }
        }
        if( stack.size()==2){return stack.pop();}
        else{return "Invalid RPN form";}
    }
    private static String foundMathSymbol(String symbol){
        String num1 = stack.pop();
        String num2 = stack.pop();
        if (num1.equals("isEmpty") || num2.equals("isEmpty")){ return "Invalid RPN form";}
        else{
            int int1 = Integer.parseInt(num1);
            int int2 = Integer.parseInt(num2);
            return calculator.Calculate(symbol,int2,int1);
        }
    }
}
