/*
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.
 * 
 If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.
 
 The replacement must be in-place, do not allocate extra memory.
 
 Examples:
 
 1,2,3 ? 1,3,2
 
 3,2,1 ? 1,2,3
 
 1,1,5 ? 1,5,1
 
 20, 50, 113 ? 20, 113, 50
 
 Step 1: Find the largest index k, such that A[k]<A[k+1]. If not exist, this is the last permutation. (in this    problem just sort the vector and return.)
 Step 2: Find the largest index l, such that A[l]>A[k].
 Step 3: Swap A[k] and A[l].
 Step 4: Reverse A[k+1] to the end.
 */
import java.util.*;
public class NextPermutation{
    public static void nextPermutation(ArrayList<Integer> A) {
        int n = A.size();
        int k = -1;
        int l = 0;
        
        for(int i = 0; i < n-1; i++){
            if(A.get(i) < A.get(i+1))
                k = i;
        }
        
        if(k == -1){
            Collections.sort(A);
            return;
        }
        
        for(int i = k+1; i < n; i++){
            if(A.get(i) > A.get(k)){
                l = i;
            }
        }
        int temp = A.get(l);
        A.set(l, A.get(k));
        A.set(k, temp);
        int j = k + 1;
        int last = n-1;
        while(j <= last){
           temp = A.get(j);
            A.set(j, A.get(last));
            A.set(last, temp);
            j++;
            last--;
        }
        
        for(int i = 0; i < A.size(); i++)
            System.out.print(A.get(i) + " ");
    }
    
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        nextPermutation(A);
    }
}