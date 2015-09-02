/*
 * You are given an n x n 2D matrix representing an image.
 * 
 Rotate the image by 90 degrees (clockwise).
 
 You need to do this in place.
 
 Note that if you end up using an additional array, you will only receive partial score.
 
 Example:
 
 If the array is
 
 [
 [1, 2],
 [3, 4]
 ]
 Then the rotated array becomes:
 
 [
 [3, 1],
 [4, 2]
 ]
 
 http://www.programcreek.com/2013/01/leetcode-rotate-image-java/
 */
import java.util.*;
public class Rotate2D{
    public static void rotate(ArrayList<ArrayList<Integer>> A) {
        if(A == null)
            return;
                        
        int n = A.size();
        if(n == 0)
            return;
        int layers = n;
        
        int row1, col1, row2, col2;
        int num;
        int temp;
        int first, last;
        for(int layer = 0; layer < layers/2; layer++){
            first = layer;
            last = n - layer - 1;
            
            for(int i = first; i < last; i++){
                int offset = i-layer;
                int top = A.get(first).get(i);
                               
                A.get(first).set(i, A.get(last-offset).get(first)); // topleft = bottomleft
                A.get(last-offset).set(first, A.get(last).get(last-offset));//bottomleft = bottomright
                A.get(last).set(last-offset, A.get(i).get(last));//bottomright = topright;
                A.get(i).set(last, top);
                
            }
        }
        
        System.out.println();
        for(ArrayList<Integer> t : A)
            System.out.println(t);
        
        
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        temp.add(4);
        A.add(new ArrayList<Integer>(temp));
        temp.clear();
        
        temp.add(5);
        temp.add(6);
        temp.add(7);
        temp.add(8);
        A.add(new ArrayList<Integer>(temp));
        temp.clear();
        
        temp.add(9);
        temp.add(10);
        temp.add(11);
        temp.add(12);
        A.add(new ArrayList<Integer>(temp));
        temp.clear();
        
        temp.add(13);
        temp.add(14);
        temp.add(15);
        temp.add(16);
        A.add(new ArrayList<Integer>(temp));
        temp.clear();
        for(ArrayList<Integer> t : A)
            System.out.println(t);
        
        rotate(A);
    }
}