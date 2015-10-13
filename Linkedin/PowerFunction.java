public class PowerFunction {
    public static int pow(int a, int b) {
        // lets consider a and b are positive
        if(b == 0) {
            return 1;
        }
        int result = a;
        int increment = a;
        for(int i = 1; i < b; i++){
            for(int j = 1; j < a; j++) {
                result += increment;
            }
            increment = result;
        }
        return result;
    }
    public static int power(int a, int b){
        int result = 1;
        while(b > 0) {
            if(b % 2 == 0) {
                b = b/2;
                a = a*a;
            }
            else {
                b--;
                result = result * a;
            }
        }
        return result;
           
    }
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        
        System.out.println(pow(a, b));
        System.out.println(power(a, b));
    }
}