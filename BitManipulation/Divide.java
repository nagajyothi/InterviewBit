/*
 * Divide two integers without using multiplication, division and mod operator.
 * 
 Return the floor of the result of the division.
 
 Example:
 
 5 / 2 = 2
 Also, consider if there can be overflow cases. For overflow case, return INT_MAX.
 */
public class Divide{
    public static int divide(int p, int q) {
        long dividend = Math.abs((long)p);
        long divisor = Math.abs((long)q);
        int result = 0;
        int mask = 1;
        if(divisor == 0)
            return Integer.MAX_VALUE;
//        if(divisor == 1)
//            return (int)dividend;
        while(divisor < dividend){
            divisor = divisor << 1;
            mask = mask << 1;
        }
        do{
            if(dividend >= divisor){
                dividend = dividend - divisor;
                result = result + mask;
            }
            divisor = divisor >> 1;
            mask = mask >> 1;               
        }while(mask != 0);
        
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
            
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return result;
        else
            return -result;
       
    }
    //From Solution
    /*
     * We can keep subtract divisor from dividend until dividend is smaller than 0, than count the subtract numbers. 
     * But it will costs a very long time if the divisor is very small comparing to dividend.
     * Shift can be used to solve this problem. We shift the divisor left until
     * it just smaller than dividend but if we keep shifting one more bit, it’s larger than dividend.
     * Than we can add the shifted value to the result and subtract the shifted value from dividend.
     * Keep doing this until dividend is smaller than divisor.
     * In fact, every integer can be represented by a set of base 2 so that shifting can be used.
     * 
     * One thing needs to be mentioned is that we need to convert the integer to long type.
     * Otherwise the Math.abs() value of Integer.MIN_VALUE will be quite strange.
     */
    public int divideSolution(int dividend, int divisor) {
        long p = Math.abs((long)dividend);
        long q = Math.abs((long)divisor);
        
        int ret = 0;
        while (p >= q) {
            int counter = 0;
            while (p >= (q << counter)) {
                counter++;
            }
            ret = ret + 1 << (counter - 1);
            p = p - q << (counter - 1);
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return ret;
        else
            return -ret;
    }
    public static void main(String[] args){
        int dividend = -2147483648;
        int divisor = -10000000;
        System.out.println(divide(dividend,divisor));
    }
}