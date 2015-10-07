import java.util.*;
public class EvaluateReversePolishNotation {
    public static double evaluate(ArrayList<String> expression) {
        Stack<Double> operands = new Stack<Double>();
        String operators = "+*-/";
        for(int i = 0; i < expression.size(); i++){
            String c = expression.get(i);
            if(!operators.contains(c))
                operands.push(Double.parseDouble(c));
            else {
                String operator = c;
                double x = operands.pop();
                double y = operands.pop();
                if(operator == "+")
                    operands.push(y+x);
                else if(operator == "-")
                    operands.push(y-x);
                else if(operator == "*")
                    operands.push(y*x);
                else if(operator == "/"){
                    if(x != 0)
                        operands.push(y/x);
                    else operands.push(0.0);
                }
            }
            System.out.println("Stack: " + operands);
        }
        return operands.peek();
    }
    public static void main(String[] args){
        ArrayList<String> expression = new ArrayList<String>();
        expression.add("5");
        expression.add("1");
        expression.add("2");
        expression.add("+");
        expression.add("4");
        expression.add("*");
        expression.add("+");
        expression.add("3");
        expression.add("-");
        System.out.println(evaluate(expression));
    }
}