/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.
 * 
 For example, given n = 3, a solution set is:
 
 "((()))", "(()())", "(())()", "()(())", "()()()"
 Make sure the returned list of strings are sorted.
 */
import java.util.*;
public class Parenthesis{
    public static ArrayList<String> generateParenthesis(int a) {                
        ArrayList<String> result = new ArrayList<String>();
        for(int i =1; i <= a; i++)
            Parenth("", 0, 0, i, result, a);
        
        return result;
    }
    private static void Parenth(String output, int open, int close, int pairs, ArrayList<String> result, int a){
        System.out.println("output: " +  output);
        if(open == pairs && close == pairs && output.length() == 2*a){
            System.out.println("\t Adding to result");
            result.add(output);
        }
        else{
            if(open < pairs){
                System.out.println("\t Adding ( ");
                Parenth(output + "(", open + 1, close, pairs, result, a);
            }
            if(close < open){
                System.out.println("\t Adding ) ");
                Parenth(output + ")", open, close + 1, pairs, result, a);
            }
        }
    }
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        ArrayList<String> result = generateParenthesis(a);
        System.out.println("*********Result*******");
        for(String s: result)
            System.out.println(s);
    }
}