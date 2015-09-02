/*
 * Given an array of integers, every element appears twice except for one. Find that single one.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
import java.util.*;
public class Single{
    public static int singleNumber(final List<Integer> a) {
        int result = a.get(0);
        for(int i = 1; i < a.size(); i++){
            result ^= a.get(i);
        }
        return result;
    }
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(3);
        a.add(2);
        a.add(2);
        a.add(1);
        
        System.out.println(singleNumber(a));
    }
}