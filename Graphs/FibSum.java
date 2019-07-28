/*
 * How many minimum numbers from fibonacci series are required such that sum of numbers should be equal to a given Number N ?
 Note : repetition of number is allowed.
 
 Example:
 
 N = 4
 Fibonacci numbers : 1 1 2 3 5 .... so on
 here 2 + 2 = 4 
 so minimum numbers will be 2 
 */
import java.util.*;
public class FibSum {
    int[] fib;
    public static int fibsum(int n) {
        if(n <= 2)
            return 1;
        int a = 1;
        int b = 1;
        int c = 1;
        
        ArrayList<Integer> fibNums = new ArrayList<Integer>();
        fibNums.add(1);
        fibNums.add(1);
        while(true){
            c = a + b;
            if(c <= n)
                fibNums.add(c);
            else
                break;
            
            a = b;
            b = c;
        }
        
        System.out.println("Fibnums : " + fibNums);
        int count = 0;
        int num = n;
        int index = fibNums.size() - 1;
        while(num > 0){
            System.out.printf("For index = %d and num = %d \n ", index, num);
            int fib = fibNums.get(index);
            System.out.println("\t fib = " + fib);
            if(num >= fib){
                
                count += (num/fib);
                System.out.printf("\t count += (num/fib); is %d \n", count);
                num %= fib;
                System.out.println("\t num %= fib is " + num);
                
            }
            index--;
        }
        return count;
    }
    
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        System.out.println(fibsum(a));
        
    }
}
