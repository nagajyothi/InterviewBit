public class GCD{
    public static int gcd(int p, int q){
        if(q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
    
    public static void main(String[] args){
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        System.out.println(gcd(p, q));
    }
}