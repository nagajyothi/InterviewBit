public class ReverseInteger{
    public static int reverse(int A){
        int result = 0;
        int N = A;
        
        while(N != 0){
            if(result != 0 && Integer.MAX_VALUE/result < 10 && Integer.MAX_VALUE/result > -10)
                return 0;
            result = result * 10 + N % 10;
            N = N / 10;
        }
        
        return result;        
    }
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        System.out.println("Reverse of " + N + " is " + reverse(N));
    }
}