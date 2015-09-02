/*
 * Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))
 */
import java.util.*;
public class Sqrt{
    public static int sqrt(int A) {
        long i = 0;
        long j = A / 2 + 1;
        while(i <= j){
            long mid = (i + j) / 2;
            if(mid *  mid == A)
                return (int)mid;
            if(mid *  mid < A)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return (int)j;
    } 
    public static void main(String[] args){
        int A = Integer.parseInt(args[0]);
        System.out.println(sqrt(A));
    }
}