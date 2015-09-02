/*
 * Given an array of integers, return the highest product possible by multiplying 3 numbers from the array

Input:

array of integers e.g {1, 2, 3}
NOTE: Solution will fit in a 32-bit signed integer
Example:

[0, -1, 3, 100, 70, 50]

=> 70*50*100 = 350000

 */
import java.util.*;

public class MaxProduct3{
    public static int maxp3(ArrayList<Integer> a) {
        Collections.sort(a);
        int n = a.size();
        System.out.println(a);
        return Math.max((a.get(n-1) * a.get(n-2) * a.get(n-3)),
                        (a.get(n-1) * a.get(0) * a.get(1)));
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(0);
        a.add(-1);
        a.add(3);
        a.add(100);
        a.add(-70);
        a.add(-50);
        
        System.out.println(maxp3(a));
    }
}