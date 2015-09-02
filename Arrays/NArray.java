/*
 * You are given a read only array of n integers from 1 to n.
 * 
 Each integer appears exactly once except A which appears twice and B which is missing.
 
 Return A and B.
 
 Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 
 Note that in your output A should precede B.
 
 Example:
 
 Input:[3 1 2 5 3]
 
 Output:[3, 4]
 
 A = 3, B = 4.
 
 
 Sum(Actual) = Sum(1...N) + A - B
 
 Sum(Actual) - Sum(1...N) = A - B. 
 
 Sum(Actual Squares) = Sum(1^2 ... N^2) + A^2 - B^2
 
 Sum(Actual Squares) - Sum(1^2 ... N^2) = (A - B)(A + B) 
 
 = (Sum(Actual) - Sum(1...N)) ( A + B). 
 
 // sum = A - B
 // squareSum = A^2 - B^2 = (A - B)(A + B)
 // squareSum / sum = A + B
 */
import java.util.*;
public class NArray{
    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] count = new int[A.size() + 1];
        for(int i = 0; i < A.size(); i++){
            count[A.get(i)]++;
        }
        for(int i = 1; i < count.length; i++){
            if(count[i] > 1)
                result.add(i);
        }
        for(int i = 1; i < count.length; i++){
            if(count[i] == 0)
                result.add(i);
        }
        return result;
    }
    //Efficient approach
    public static ArrayList<Integer> repeatedNumberEfficient(final List<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        long sum = 0;
        long squareSum = 0;
        long temp;
        for(int i = 0; i < A.size(); i++){
            temp = A.get(i);
            sum = sum + temp;
            sum = sum - (i + 1);// this will give us A - B at end.
            squareSum = squareSum + temp * temp;
            squareSum = squareSum - (i+1)*(i+1); // this will give us A^2 - B^2
        }
        
        squareSum = squareSum / sum; //(A-B)(A+B)/(A-B) = (A+B)
        int X = (int)(squareSum + sum) / 2;
        int Y = (int)squareSum - X;
        result.add(X);
        result.add(Y);
        return result;
    }
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(3);
        A.add(1);
        A.add(2);
        A.add(5);
        A.add(3);
        ArrayList<Integer> result = repeatedNumberEfficient(A);
        for(int i = 0; i < result.size(); i++)
            System.out.print(result.get(i) + " ");
    }
}