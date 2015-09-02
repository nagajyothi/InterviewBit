/*
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5 
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.

http://www.programcreek.com/2014/03/leetcode-maximum-gap-java/
 */
import java.util.*;
public class MaxGap {
    public static int maximumGap(final List<Integer> a) {
        if(a.size() < 2 || a == null)
            return 0;
        int max = a.get(0);
        int min = a.get(0);
        for(int i = 1; i < a.size(); i++){
            max = Math.max(max, a.get(i));
            min = Math.min(min, a.get(i));
        }
        System.out.printf("max : %d, min = %d \n", max, min);
        
        Bucket[] buckets = new Bucket[a.size() + 1];
        for(int i =0; i < buckets.length; i++)
            buckets[i] = new Bucket();
        
        double interval = (double)a.size()/(max - min);
        
        for(int i =0; i <a.size(); i++){
            int index = (int)(interval * (a.get(i) - min));
            if(buckets[index].low == -1){
                buckets[index].low = a.get(i);
                buckets[index].high = a.get(i);
            }
            else{
                buckets[index].low = Math.min(buckets[index].low, a.get(i));
                buckets[index].high = Math.max(buckets[index].high, a.get(i));
            }
        }
        System.out.println("All Lows");
        for(int i = 0; i< buckets.length; i++)
            System.out.print(buckets[i].low + " ");
        System.out.println();
        
        
         System.out.println("All Highs");
        for(int i = 0; i< buckets.length; i++)
            System.out.print(buckets[i].high + " ");
        System.out.println();
        
        int result =0;
        int prev = buckets[0].high;
        System.out.println("All results");
        for(int i = 1; i< buckets.length; i++){
            if(buckets[i].low != -1){
                result = Math.max(result, buckets[i].low - prev);
                prev = buckets[i].high;
            }
            
            System.out.print(result + " ");
        }
        return result;
    }
    public static void main(String[] args) {
        
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(10);
        a.add(5);
        a.add(9);
        a.add(2);
        a.add(3);
        System.out.println(maximumGap(a));
    }
}