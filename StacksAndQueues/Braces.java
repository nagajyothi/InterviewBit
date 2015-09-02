/*
 * write program to validate if the input string has redundant braces ?
 Return 0/1 
 0 -> NO 1 -> YES 
 
 Input will be always a valid expression
 
 and operators allowed are only + , * , - , /
 
 Example:
 
 ((a+b)) has redundant braces so answer will be 1
 (a + (a + b)) doesn't have have any redundant braces so answer will be 0
 */
import java.util.*;
public class Braces{
//    public static int braces(String a) {
//        Stack<String> operands = new Stack<String>();
//        Stack<String> br = new Stack<String>();
//        Stack<String> operators = new  Stack<String>();
//        
//        int flag = 0;
//        for(int i = 0; i < a.length(); i++){
//            char c = a.charAt(i);
//            
//            System.out.println("For c = " +  c);
//            //System.out.println("\t");
//            if(c == '(')
//                br.push("(");
//            else if(c == ')' && !operators.isEmpty()) {   
//                br.pop();                
//                String x = operands.pop();
//                String y = operands.pop();
//                String op = operators.pop();
//                System.out.println(x+op+y);
//                if(!br.isEmpty() && operators.isEmpty()){
//                    flag = 1;
//                    break;
//                }
//                else {
//                    operands.push(x + op + y);
//                }
////                //else if(op == "-")
////                    operands.push(y + op + x);
////                else if(op == "*")
////                    operands.push(y + op + x);
////                else if(op == "/")
////                    operands.push(y + op + x);                                
//            }
//            else if(c == '+' || c == '-' || c == '*' || c == '/')
//                operators.push(Character.toString(c));
//            else 
//                operands.push(Character.toString(c));
//            
//            
//            System.out.println(" \t operands");
//            for(String s : operands)
//                System.out.print(s + " " );
//            System.out.println();
//            System.out.println("\t operators");
//            for(String s : operators)
//                System.out.print(s + " " );
//            System.out.println();
//        }
//        if(!br.isEmpty())
//            flag = 1;
//        return flag;
//    }
    public static int braces(String str) {
        Stack<Character> stack = new Stack<Character>(); 
        int index = 0; 
        while(index < str.length()){ 
            char c = str.charAt(index); 
            if(c == '(' || c == '+' || c == '-' || c == '*' || c == '/'){ 
                stack.push(c); 
            } else if(c == ')'){ 
                if(stack.peek() == '('){ 
                    return 1; 
                } else{ 
                    while(!stack.isEmpty() && stack.peek() != '('){ 
                        stack.pop(); 
                    } 
                    stack.pop(); 
                } 
            } 
            index++; 
        } 
        return 0; 
    }
    public static void main(String[] args){
        String a = "(a)";
        System.out.println(braces(a));
    }
}
/*
 * Trials
 * boolean[] flag = new boolean[a.length()];
 int k = 0;
 for(int i =0; i < a.length()-1; i++){
 if(a.charAt(i) == '(' || a.charAt(i+1) == '('){
 k++;
 flag[k] = true;
 }
 if(a.charAt(i) == ')' || a.charAt(i+1) == ')'){
 if(flag[k] == true){
 return 1;                    
 }
 }
 if(a.charAt(i) == ')' || a.charAt(i+1) != ')'){
 flag[k] = false;
 k--;
 }
 }
 if(flag[k] == false)
 return 0;
 //        else
 //            return 1;
 
 
 
 
 Stack<Integer> stack = new Stack<Integer>();
 
 stack.push(0);
 
 for(int i = 0; i < a.length(); i++){
 
 char c = a.charAt(i);
 System.out.println("For c : " + c);
 if(c == '('){
 System.out.println("\t Pushing 0");
 stack.push(0);
 }
 else if(c == ')'){
 System.out.println("\t stack.peek() is poppinh:  " + stack.peek());
 if(stack.pop() == 0)
 return 1;
 }
 else{
 System.out.println("\t Pushing  " + (stack.peek() + 1));
 stack.push(stack.pop() + 1);
 }
 
 
 }
 return 0 ;
 */