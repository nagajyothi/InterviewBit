public class Palindrome{
    public static boolean isPalindrome(int N){
        int number = N;
        int reverse = 0;
        while(number != 0){
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number/10;
        }
        return reverse == N;
        
    }
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        if(isPalindrome(N))
            System.out.println(N + " is Palindrome");
        else
            System.out.println(N + " is not a Palindrome");
    }
}
