public class Factorial{
    public static long factorial(int N){
        if(N == 0)
            return 1;
        return N * factorial(N-1);
    }

    public static int findTrailingZeros(int  n)
    {
        // Initialize result
        int count = 0;
        
        // Keep dividing n by powers of 5 and update count
        while(n > 0){
            count += n/5;
            n = n/5;
        }
        
        return count;
    }
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        System.out.println("Factorial of " + N + " is " + factorial(N));
        System.out.println(findTrailingZeros(N));
        
    }
    
}