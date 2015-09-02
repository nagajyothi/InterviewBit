/*
 * Given a read only set of n + 1 integers between 1 and n, find one number that repeats in linear time using less then O(n) space and traversing the stream sequentially O(1) times.
 * 
 Sample Input:
 
 [3 4 1 4 1]
 Sample Output:
 
 1
 */
import java.util.*;
public class RepeatedElementInArray{
//    public static int repeatedNumber(final List<Integer> A) {
//        for(int i = 0; i < A.size(); i++){
//            if(A.get(Math.abs(A.get(i))) > 0)
//                A.set(Math.abs(A.get(i)), -1*A.get(Math.abs(A.get(i))));
//            else
//                return Math.abs(A.get(i));                      
//        }
//        return 0;
//    }
    public static int repeatedNumber(final List<Integer> A) {
        int[] count = new int[A.size()];
        for(int i = 0; i < A.size(); i++){
            if(count[A.get(i)] == 1)
                return A.get(i);
            else
                count[A.get(i)] = 1;                      
        }
        return 0;
    }
    public static void main(String[] args){
        List<Integer> A = new ArrayList<Integer>();
        A.add(3);
        A.add(4);
        A.add(1);
        A.add(2);
        A.add(4);
        System.out.println(repeatedNumber(A));
    }
}