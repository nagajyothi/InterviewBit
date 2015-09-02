/*
 * Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example:

Input :
    A : [1 3 5] 
    k : 4
Output : YES

as 5 - 1 = 4
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Try doing this in less than linear space complexity.
 */
import java.util.*;
public class DiffK{
    public static int diffPossible(ArrayList<Integer> a, int b) {
        int i = 0;
        int j = 1;
        while(j < a.size() && i < a.size()){
            
            System.out.println(a.get(j) + " " + a.get(i));
            
                int diff = a.get(j) - a.get(i);
                System.out.println("diff " + diff);
                if(diff == b && i != j)
                    return 1;
                else if(diff < b)
                    j++;
                else 
                    i++;
            
        }
        return 0;
        
 }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(4);
        System.out.println(diffPossible(a, 0));
    }
}