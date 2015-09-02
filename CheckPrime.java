public class CheckPrime {
    public static int isPrime(int A) {
        if (A == 1) {
            return 0;
        }
        System.out.println(Math.sqrt(A));
        for(int i = 2; i <= Math.sqrt(A); i++){
            if(A % i == 0){
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        System.out.println(isPrime(Integer.parseInt(args[0])));
    }
}