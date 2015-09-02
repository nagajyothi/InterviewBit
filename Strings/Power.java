/*
 * Find if Given number is power of 2 or not. 
 More specifically, find if given number can be expressed as 2^k where k >= 1.
 
 Input:
 
 number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
 Output:
 
 return 1 if the number if a power of 2 else return 0
 
 Example:
 
 Input : 128
 Output : 1
 */
public class Power{
    public static int power(String a) {
        int N = Integer.parseInt(a);
        if(N % 2 != 0)
            return 0;
        while(N >= 1){
            N = N/2;
            if(N % 2 != 0 && N != 1)
            return 0;
        }
        return 1;
    }
    public static int powerSolution(String A){
        java.math.BigInteger a = new java.math.BigInteger(A);
        if(a.compareTo(java.math.BigInteger.ONE)==0 || a.compareTo(java.math.BigInteger.ZERO)==0)return 0;
        for(int i=0;i<a.bitLength()-1;i++){
            if(a.testBit(i))return 0;
        }
        return a.testBit(a.bitLength()-1)?1:0;
    }
    public static void main(String[] args){
        String a = args[0];
        System.out.println(powerSolution(a));
    }
}