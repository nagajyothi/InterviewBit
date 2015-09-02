/*
 * Given a non-negative number represented as an array of digits,
 * 
 add 1 to the number ( increment the number represented by the digits ).
 
 The digits are stored such that the most significant digit is at the head of the list.
 
 Example:
 
 If the vector has [1, 2, 3]
 
 the returned vector should be [1, 2, 4]
 
 as 123 + 1 = 124.
 
 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
 For example, for this problem, following are some good questions to ask :
 
 Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input ?
 A : For the purpose of this question, YES
 Q : Can the output have 0’s before the most significant digit ? Or in other words, is 0 1 2 4 a valid output ?
 A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */
import java.util.*;
public class Plus1{
    public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        if(a == null ||a.size() == 0)
            return null;
        int n = a.size();
        int carry = 1;
        Integer zero = new Integer(0);
        int sum = 0;
        for(int i = n-1; i >= 0; i--){
            sum = a.get(i) + carry;
            carry = sum / 10;
            sum = sum % 10;
            a.set(i, sum);          
        }
        if(carry != 0){
            a.add(0, carry);
        }
        //int next = 
        for(int i = 0; i < a.size(); i++)
            System.out.print(a.get(i) + " ");
        System.out.println();
        int k = 0;
        while(a.get(k).equals(zero)&& k < a.size()){            
             a.remove(k);
            //++;
        }
        return a;
        
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(5);
        a.add(6);
        a.add(8);
        a.add(6);
        a.add(1);
        a.add(2);
        a.add(4);
        a.add(5);
        a = plusOne(a);
        for(int i = 0; i < a.size(); i++)
            System.out.print(a.get(i) + " ");
    }
}