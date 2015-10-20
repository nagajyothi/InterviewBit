/*
 * Find out the maximum sub-array of non negative numbers from an array.
 The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 
 Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
 
 Example:
 
 A : [1, 2, 5, -7, 2, 3]
 The two sub-arrays are [1, 2, 5] [2, 3].
 The answer is [1, 2, 5] as its sum is larger than [2, 3]
 NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 NOTE 2: If there is still a tie, then return the segment with minimum starting index
 */
import java.util.*;
public class MaxSet {       
    public static ArrayList<Integer> maxsetEfficient(ArrayList<Integer> A) {
        ArrayList<Integer> maxRange = new ArrayList<Integer>();
        ArrayList<Integer> currentRange = new ArrayList<Integer>();
        long maxSum = Integer.MIN_VALUE;
        long currentSum = 0;
        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) >= 0) {
                currentSum += A.get(i);
                currentRange.add(A.get(i));
                if((maxSum == currentSum && maxRange.size() < currentRange.size()) || 
                   maxSum < currentSum)  {
                    maxSum = currentSum;
                    maxRange = new ArrayList<>(currentRange);
                }                            
            }            
            else {
                currentSum = 0;
                currentRange.clear();
            }
        }
        System.out.println("MaxRange : " + maxRange);
        System.out.println("MaxSum : " + maxSum);
        return maxRange;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(5);
        A.add(-7);
        A.add(2);
        A.add(10);
//        A.add(1967513926);
//        A.add(1540383426);
//        A.add(-1303455736);
//        A.add(-521595368);
        
        System.out.println(maxsetEfficient(A));
    }
}
/*
 *  public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
 ArrayList<Integer> prev =new ArrayList<Integer>();
 ArrayList<Integer> current =new ArrayList<Integer>();
 long prevTotal = -1;
 long total = 0;
 for(int i = 0; i < A.size(); i++){
 System.out.println("For A.get(i) = " +  A.get(i));
 if(A.get(i) >= 0) {
 total += A.get(i);
 current.add(A.get(i));
 System.out.println("\t Current : " + current);
 }
 else {
 if(total > 0) {
 prevTotal = total;
 total = 0;
 prev = new ArrayList<Integer>(current);
 System.out.println("\t prev : " + prev);
 current.clear();
 }
 }
 
 if(total == prevTotal && prev.size() < current.size()) {
 prev = current;
 
 }
 else if(total > prevTotal) {
 prev = current;
 
 }
 
 }
 System.out.println("PrevTotal : " + prevTotal);
 System.out.println("Prev: " + prev);
 System.out.println("Current : " + current);
 return prev;
 }
 */