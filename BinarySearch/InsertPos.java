/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * 
 You may assume no duplicates in the array.
 
 Here are few examples.
 
 [1,3,5,6], 5 ? 2
 [1,3,5,6], 2 ? 1
 [1,3,5,6], 7 ? 4
 [1,3,5,6], 0 ? 0
 */
import java.util.*;
public class InsertPos{
    public static int searchInsert(ArrayList<Integer> A, int B) {
        if(A == null) return 0;
        if(B <= A.get(0)) return 0;
        
        for(int i = 0; i < A.size()-1; i++){
            if(A.get(i) < B && B <= A.get(i + 1))
                return i + 1;
        }
        return A.size();              
    }
    // Efficient Approach
     public static int searchInsertBetter(ArrayList<Integer> A, int B) {
         if(A == null || A.size() == 0) return 0;
         return searchInsert(A, B, 0, A.size() - 1);
     }
     
     public static int searchInsert(ArrayList<Integer> A, int B, int start, int end){
         int mid = (start + end )/ 2;
         if(B == A.get(mid)) {
             return mid;
         }
         else if(B < A.get(mid)) {
             return start < mid ? searchInsert(A,B,start,mid-1):start;
         }
         else {
             return end > mid ? searchInsert(A,B,mid+1,end):(end+1);
         }
     }
    
    public static void main(String[] args){
        int B = Integer.parseInt(args[0]);
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(3);
        A.add(5);
        A.add(6);

        System.out.println(searchInsertBetter(A, B));
        
    }
}