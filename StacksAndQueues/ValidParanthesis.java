/*
 * 
 */
import java.util.*;
public class ValidParanthesis {
    public static int isValid(String a) {
        if(a == null || a.length() == 0)
            return 0;
        System.out.println(a);
        Stack<Character> stack = new Stack<Character>();
        //stack.push(a.charAt(0));
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == '{' ||
               a.charAt(i) == '(' ||
               a.charAt(i) == '[')
                stack.push(a.charAt(i));
            else {
                if(stack.isEmpty())
                    return 0;
                if((a.charAt(i) == ']' && stack.peek() == '[') ||
                   (a.charAt(i) == '}' && stack.peek() == '{') ||
                   (a.charAt(i) == ')' && stack.peek() == '(' ))
                    stack.pop();
                else 
                    return 0;
                
            }
        }                
        return stack.empty() ? 1 : 0;                
    }
    public static void main(String[] args){
        String a = "(){}[";
        System.out.println(isValid(a));
    }
}
//
// public int isValid(String A) {
//     
//     Stack<Character> stack = new Stack<>();
//     
//     for (int i = 0; i < A.length(); i++) {
//         
//         char c= A.charAt(i);
//         
//         if (c == '(' || c == '{' || c == '[') {
//             stack.push(c);
//         } else {
//             
//             if (stack.isEmpty()) {
//                 return 0;
//             }
//             
//             char top = stack.peek();
//             
//             if ((top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']')) {
//                 stack.pop();
//             } else
//                 return 0;
//         }
//     }
//     
//     if (!stack.isEmpty())
//         return 0;
//     
//     return 1;
// }
