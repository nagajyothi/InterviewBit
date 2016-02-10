/*
 * You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the constraints that any painter will only paint contiguous sections of board.
 * 
 2 painters cannot share a board to paint. That is to say, a board
 cannot be painted partially by one painter, and partially by another.
 A painter will only paint contiguous boards. Which means a
 configuration where painter 1 paints board 1 and 3 but not 2 is
 invalid.
 Return the ans % 10000003
 
 Input :
 K : Number of painters
 T : Time taken by painter to paint 1 unit of board
 L : A List which will represent length of each board
 
 Output:
 return minimum time to paint all boards % 10000003
 Example
 
 Input : 
 K : 2
 T : 5
 L : [1, 10]
 Output : 50
 */
import java.util.*;
public class PaintKBoards {
    private static final int MOD = 10000003;
    public static int paint(int A, int B, ArrayList<Integer> C) {
        long result = Long.MAX_VALUE;
        long low = 0;
        long high = Long.MAX_VALUE;
        long mid = 0;
        
        while(low <= high) {
            mid = low + (high - low)/2;
            boolean status = isPossible(A, B, C, mid);
            if(status) {
                result = mid;
                high = mid - 1;                
            }
            else {
                low = mid + 1;
            }
        }
        return (int)(result % MOD);
    }
    
    public static boolean isPossible(int A, int B, ArrayList<Integer> C, long time) {
        int n = C.size();
        int index = 0;
        long total;
        for(int i = 0; i < A && index < n; i++) {
            total = 0;
            while(total < time && index  < n) {
                total += (1L * C.get(index) * B);
                if(total > time)
                    break;
                index++;
            }
        }
        return (index != n);
    }
    public static void main(String[] args){
        int K = Integer.parseInt(args[0]); // Number of painters
        int T = Integer.parseInt(args[1]); // Time taken by painter to paint 1 unit of board
        ArrayList<Integer> C = new ArrayList<Integer>();
        C.add(1000000);
        C.add(1000000);
        System.out.println(paint(K, T, C));
    }
}