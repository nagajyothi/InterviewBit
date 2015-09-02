/*
 * Implement pow(x, n) % d.
 * 
 In other words, given x, n and d,
 
 find (xn % d)
 
 Note that remainders on division cannot be negative. 
 In other words, make sure the answer you return is non negative.
 */
import java.math.BigInteger;
import java.util.*;
public class Pow{
    public static int pow(int x, int n, int d) {
        int result = 1;
        int square = x;
        if(x == 0)
            return 0;
        if(n == 0)
            return 1;
        while(n != 0){
            if(n % 2 != 0){
                result = result *  square;
            }
            square = (square * square) % d;
            n = n/2;
            if(result > d)
                result = result % d;
        }
        System.out.println(result);
        System.out.println((result + d) % d);
        return result;
    }
    
    //Efficient approach
    public static int powBetter(int x, int n, int d) {
        if(x == 0)
            return 0;
        if(n == 0)
            return 1;
        if(n == 1){
            if(x < 0)
                return (x+d) % d;
            else
                return x % d;
        }
        int pn = n > 0 ? n : (-1) * n;
        int pn2 = pn;
        
        int px = x > 0 ? x : -x;
        int result = px;
        
        int k = 1;
        while(pn/2 > 0){
            result = result * result;
            pn = pn /2;
            k = k * 2;
        }
        result = result * powBetter(px, pn2 - k, d);
        
        if(x < 0 && n % 2 == 1) {            
            result = -result;
        }        
        if(n < 0)
            result = 1/result;
        
        //System.out.println(result);
        result = result % d;
        
        return result < 0 ? (result + d) % d : result;
    }
    public static int powSolution(int x, int n, int d) {
        System.out.println("Entering function");
     return BigInteger.valueOf(x).modPow(BigInteger.valueOf(n),BigInteger.valueOf(d)).intValue();
 }
    public static void main(String[] args){
        int x = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int d = Integer.parseInt(args[2]);
        int result = powSolution(x, n, d);
        
        System.out.println(result);
        
    }
}