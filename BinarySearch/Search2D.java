/*
 * Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:
> 1. Integers in each row are sorted from left to right.
>
> 2. The first integer of each row is greater than or equal to the last integer of the previous row.

Example:

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return 1 ( 1 corresponds to true )

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
import java.util.*;
public class Search2D{
    public static int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        if(A == null || A.size() == 0 || A.get(0).size() == 0)
            return 0;
        int m = A.size();
        int n = A.get(0).size();
        
        int start = 0;
        int end = m * n -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int midX = mid / n;
            int midY = mid % n;
            
            if(A.get(midX).get(midY) == B){
                return 1;
            }
            else if(A.get(midX).get(midY) < B) {
                start = mid + 1;
            }
            else if(A.get(midX).get(midY) > B) {
                end = mid - 1;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        int k = 0;
        for(int i = 0;  i < 3; i++){
            A.add(new ArrayList<Integer>());
            for(int j = 0; j < 3; j++){                
                A.get(i).add(k);
                k++;
            }
        }
        
        
        int B = Integer.parseInt(args[0]);
        System.out.println(searchMatrix(A,B));
    }
}