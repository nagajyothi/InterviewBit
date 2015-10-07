/*
 * Check if number is sparse or not
 * http://www.geeksforgeeks.org/check-if-a-given-number-is-sparse-or-not/
 */
public class SparseNumber {
    public static boolean checkSparse(int n) {
        if((n & n/2) > 1)
            return false;
        return true;
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if(!checkSparse(n))
            System.out.print("Not ");
        System.out.println("Sparse Number");
    }
}