/*
 * Given a string, find the rank of the string amongst its permutations sorted lexicographically. 
 Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations. 
 Look at the example for more details.
 
 Example :
 
 Input : 'aba'
 Output : 2
 
 The order permutations with letters 'a', 'a', and 'b' : 
 aab
 aba
 baa
 The answer might not fit in an integer, so return your answer % 1000003
 
 NOTE: 1000003 is a prime number
 NOTE: Assume the number of characters in string < 1000003
 */
import java.util.*;
public class Rank2 {
    public static int findRank(String A) {
        int length = A.length();
        long strFactorial = factorial(length);
        long rank = 1;
        for(int i = 0; i < length; i++){
            strFactorial /= length - i;
            rank += findSmallerInRight(A, i, length - 1) * strFactorial;
        }
        System.out.println("Rank : "+ Integer.MAX_VALUE);
        rank %= 1000003;
        return (int)rank;
    }
    
    public static long factorial(int n){
        return n <= 1? 1: (n * factorial(n - 1));
    }
    public static int findSmallerInRight(String A, int low, int high){
        int countRight = 0;
        for(int i = low + 1; i <= high; i++){
            if(A.charAt(i) < A.charAt(low))
                countRight++;
        }
        return countRight;
    }
    
    public static int findEqual(String A, int low, int high){
        int equal = 0;
        for(int i = low + 1; i <= high; i++){
            if(A.charAt(i) == A.charAt(low))
                equal++;
        }
        return equal; 
    }
    
    public static void main(String[] args){
        String A = "aba";
        System.out.println(findRank(A.toCharArray()));
    }
}