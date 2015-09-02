/*
 * Given an unsorted array, find the largest pair sum in it. For example, the largest pair sum in {12, 34, 10, 6, 40} is 74.

Difficulty Level: Rookie
Expected Time Complexity: O(n) [Only one traversal of array is allowed]
 */
import java.util.*;
public class LargestPairSum{
    public static int bruteForce(int[] A){
        int max = 0;
        for(int i = 0; i < A.length-1; i++){
            for(int j = i+1; j < A.length; j++){
                if(max < (A[i]+A[j]))
                    max = A[i] + A[j];
            }
        }
        return max;
    }
    public static int sortSolution(int[] A){
        Arrays.sort(A);
        return A[A.length-1] + A[A.length-2];
    }
    public static int bestNSolution(int[] A){        
        int first = Math.max(A[0], A[1]);
        int second = Math.min(A[0], A[1]);
        
        for(int i = 2; i < A.length; i++){
            if(A[i] > first){
                second = first;
                first = A[i];                
            }
            else if(A[i] > second && A[i] != first)                
                second = A[i];
        }
        return first + second;
    }
    
    
    public static void main(String[] args){
        int[] A = {12, 34, 10, 6, 40};
        System.out.println("bruteForce(A) " + bruteForce(A));
        System.out.println("sortSolution(A) " + sortSolution(A));
        System.out.println("bestNSolution(A) " + bestNSolution(A));
    }
}