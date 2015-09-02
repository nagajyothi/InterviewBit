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
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        int k = 0;
        for(int i = 0;  i < 3; i++){
            A.add(new ArrayList<Integer>());
            for(int j = 0; j < 3; j++){                
                A.get(i).set(j, k);
                k++;
            }
        }
        int B = Integer.parseInt(args[0]);
        System.out.println(searchMatrix(A,B);
    }
}