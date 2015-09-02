/*
 * http://www.programcreek.com/2014/03/leetcode-container-with-most-water-java/
 */
import java.util.*;
public class Container{
    public static int maxArea(ArrayList<Integer> a) {
        if(a.size() <2 || a == null)
            return 0;
        int max = 0;
        int left = 0;
        int right = a.size()-1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(a.get(left), a.get(right)));
            if (a.get(left) < a.get(right))
                left++;
            else
                right--;
        }
        
        return max;
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        System.out.println(maxArea(a));
    }
}