public class PowerUsingBinarySearch{
    
    public static int pow(int x, int n, int d) {
        long a = x;
        long result = 1;
        while(n > 0) {
            System.out.println("For n = " +  n);
            if(n % 2 == 1){
                result  = result * a;
                result = result % d;                
            }
            
            a = a * a;
            a = a % d;
            n = n >> 1;
            System.out.println("\t result = " + result + " \n \t a = " +  a);
        }
        result = (result + d) % d;
        return (int)result;
    }
    public static void main(String[] args){
        int x = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int d = Integer.parseInt(args[2]);
        int result = pow(x, n, d);
        System.out.println(result);
    }
}
    