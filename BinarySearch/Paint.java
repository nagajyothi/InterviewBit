/*
 * You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the constraints that any painter will only paint continuous sections of board.
 * 
 2 painters cannot share a board to paint. That is to say, a board
 cannot be painted partially by one painter, and partially by another.
 A painter will only paint continuous boards. Which means a
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
 
 http://articles.leetcode.com/2011/04/the-painters-partition-problem.html
 */
import java.util.*;
public class Paint{
    public static int getMax(ArrayList<Integer> C, int n){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(C.get(i) > max)
                max = C.get(i);
        }
        return max;
    }
    
    public static int getSum(ArrayList<Integer> C, int n){
        int total = 0;
        for(int i = 0; i < n; i++){
            total += C.get(i);
        }
        return total;
    }
    
    public static int getRequiredPainters(ArrayList<Integer> C, int n, int maxLengthPerPainter){
        int total = 0;
        int numPainters = 1;
        for(int i =0;i < n; i++){
            total += C.get(i);
            if(total > maxLengthPerPainter){
                total = C.get(i);
                numPainters++;
            }
            
        }
        return numPainters;
    }
    public static int partition(ArrayList<Integer> C, int n, int k){
        int lo = getMax(C, n);
        int hi = getSum(C, n);
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            int requiredPainters = getRequiredPainters(C, n, mid);
            if(requiredPainters <= k)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }
    public static int paint(int A, int B, ArrayList<Integer> C) {
        return (int)(partition(C, C.size(), A) * B);
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