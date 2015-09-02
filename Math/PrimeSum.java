/*
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
 * 
 NOTE A solution will always exist. read Goldbach’s conjecture
 
 Example:
 
 
 Input : 4
 Output: 2 + 2 = 4
 
 If there are more than one solutions possible, return the lexicographically smaller solution.
 
 If [a, b] is one solution with a <= b,
 and [c,d] is another solution with c <= d, then
 
 [a, b] < [c, d] 
 
 If a < c OR a==c AND b < d. 
 */
import java.util.*;
public class PrimeSum{
    public static ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(A < 2)
            return result;
        
        int first = 2;
        int second = A - first; 
        while(first <= second){
            second = A - first;
            System.out.printf("isPrime(%d) : %s \n ", second, isPrime(second)); 
            System.out.printf("isPrime(%d) : %s \n ", first, isPrime(first)); 
            if(isPrime(second) == true && isPrime(first)){
                result.add(first);
                result.add(second);
                return result;
            }
            first++;
        }
        
        return result;
    }
    
    public static boolean isPrime(int n){
        
        if(n == 2) return true;
        if(n % 2 == 0)
            return false;
        for(int i = 2; i < n; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        int A = Integer.parseInt(args[0]);
        
        ArrayList<Integer> result = primesum(A);
        System.out.println(result);
    }
}