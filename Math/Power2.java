/*
 * Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.
 * 
 Example
 
 Input : 4
 Output : True  
 as 2^2 = 4. 
 */
import java.util.*;
public class Power2{
    public static boolean isPower(int A) {
        int i;
        double p;
        if(A == 1)
            return true;
        for(i = 1; i <= Math.sqrt(A); i++){
            p = Math.log(A)/ Math.log(i);
            if(p - (int)p < 0.000000001)
                return true;
        }
        return false;
    }
    
    public static boolean isPowerEfficient(int A) {
        double x = 2;
        double i;
        if(A == 1)
            return true;
        
        for(i = 2; i < 33 && x <= (double)(Math.pow(2, 16)); i++){
            if(Math.pow(x, i) == (double)A)
                return true;
            if(Math.pow(x, i) >= Math.pow(2, 32)){
                i = 1;
                x++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int A = Integer.parseInt(args[0]);
        if(!isPowerEfficient(A))
            System.out.print("False ");
        else
            System.out.println("True");
        
    }
}