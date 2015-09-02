/*
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 Example:
 
 Given [1,2,0] return 3,
 
 [3,4,-1,1] return 2,
 
 [-8, -7, -6] returns 1
 
 Your algorithm should run in O(n) time and use constant space.
 
 My trails
   int missingPositive = 1;
        for(int i = 0; i < A.size(); i++){
            if(A.get(i) > 0 && missingPositive >= A.get(i))
                missingPositive++;            
        }
        return missingPositive;
 */
import java.util.*;
public class FirstMissingPositiveInteger{
    
    public static int firstMissingPositive(ArrayList<Integer> A) {
        int i = 0;
        int n = A.size();
        while(i < n){
            if(A.get(i) != i+1 &&
               A.get(i) >= 1 &&
               A.get(i) <= n &&
               A.get(A.get(i)-1) != A.get(i)){
                int temp = A.get(A.get(i)-1);
                A.set(A.get(i)-1, A.get(i));
                A.set(i, temp);
            }
            else{
                i++;
            }                
        }
        i = 0;
        for (i = 0; i < A.size(); i++) {
            if (A.get(i) != i + 1)
                return i + 1;
        }
        return A.size() + 1;
    }
     public static int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] != i + 1 && A[i] >= 1 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            } else
                i++;
        }
        for (i = 0; i < A.length; i++) {
            if (A[i] != i + 1)
                return i + 1;
        }
        return A.length + 1;
    }
    public static void main(String[] args){
        
        int[] B = {3,4,-1,1};
        System.out.println(firstMissingPositive(B));
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(3);
        A.add(4);
        A.add(-1);
        A.add(1);
        System.out.println(firstMissingPositive(A));
    }
}