/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
import java.util.*;
public class EvaluateExpression{
    public static int evalRPN(ArrayList<String> a) {
     Stack<Integer> operands = new Stack<Integer>();
     //Stack<String> operators = new Stack<String>();
     String operators = "+*-/";
     for(int i = 0; i < a.size(); i++){
         String c = a.get(i);
         
         if(!operators.contains(c))
             operands.push(Integer.parseInt(c));
         else {
             int x = operands.pop();
             int y = operands.pop();
             String op = c;
             if(op == "+")
                 operands.push(x + y);
             else if(op == "-")
                 operands.push(y - x);
             else if(op == "*")
                 operands.push(y * x);
             else if(op == "/")
                 operands.push(y / x);
         }
     }
      return operands.pop();
 }
    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<String>();
        a.add("2");
        a.add("2");
//        a.add("5");
        a.add("/");
//        a.add("+");
        System.out.println(evalRPN(a));
    }
}
//c.compareTo("0") >= 0 || c.compareTo("9") <= 0