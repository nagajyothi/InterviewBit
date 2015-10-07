/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * 
 Note: The numbers can be arbitrarily large and are non-negative.
 Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer. 
 For example, 
 given strings "12", "10", your answer should be “120”.
 
 NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA / PYTHON ). 
 We will retroactively disqualify such submissions and the submissions will incur penalties.
 */

import java.util.*;
public class Multiply {
    public static String multiply(String a, String b) {
        String res = "0";
        int i = b.length()-1;
        int carry = 0;
        //int bi = b.charAt(i) - 48;
        int m = 1;
        ArrayList<Long> intres = new ArrayList<Long>();
        while(i >= 0){
            int bi = b.charAt(i) - 48;
            int result = 0;
            int k =1;
            for(int j = a.length()-1; j >= 0; j--){
                
                int ai = a.charAt(j) - 48;
                System.out.printf("For ai : %d, bi : %d \n", ai, bi);
                int temp = ai * bi + carry;
                System.out.println("\t Temp: " + temp);
                carry = temp / 10;
                result = temp % 10 * k + result;
                k = k *10;                
            }
            result = carry * k + result; 
            System.out.println(result);
            intres.add((long)(result * m));
            m = m * 10;
            
            i--;
        }
        long sum = 0;
        for(long l: intres)
            sum += l;
        
        System.out.println(intres);
        System.out.println(sum);
        res = Long.toString(sum);
        return res;
        
    }
    public static String multiplyEfficient(String a, String b) {
        String n1 = new StringBuilder(a).reverse().toString();
        String n2 = new StringBuilder(b).reverse().toString();
        
        int[] d = new int[a.length() + b.length()];
        
        for(int i =0; i < n1.length(); i++){
            for(int j =0; j < n2.length(); j++){
                d[i+j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < d.length; i++){
            System.out.print(d[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < d.length; i++){
            int mod = d[i] % 10;
            int carry = d[i] / 10;
            if(i + 1 < d.length) 
                d[i + 1] += carry;
            sb.insert(0, mod);
            System.out.println("String:  " + sb.toString() + "  carry : " + carry);
            
            for(int j = 0; j < d.length; j++){
                System.out.print(d[j] + " ");
            }
            System.out.println();
            System.out.println();
           
        }
        
        while(sb.charAt(0) == '0' && sb.length() > 1)
            sb.deleteCharAt(0);
        
        return sb.toString();
    }
    public static void main(String[] args) {
        String a = "99999";
        String b = "99999";
        System.out.println(multiplyEfficient(a, b));
        
    }
    
}