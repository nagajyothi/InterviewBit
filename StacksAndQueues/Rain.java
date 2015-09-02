/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * 
 Example :
 
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 
 
 
 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 In this case, 6 units of rain water (blue section) are being trapped.
 */
import java.util.*;
public class Rain{
    public static int trap(final List<Integer> a) {
        int result = 0;
        if(a == null || a.size() <= 2)
            return result;
        
        int[] left = new int[a.size()];
        int[] right = new int[a.size()];
        
        //scanning from left to find the max at each position
        int max = a.get(0);
        left[0] = max;
        for(int i = 1; i < a.size(); i++){
            if(a.get(i) < max)
                left[i] = max;
            else{
                max = a.get(i);
                left[i] = max;
            }
            
        }
        
        //scan from right to left to find max
        max = a.get(a.size() -1 );
        right[a.size() - 1] = max;
        for(int i = a.size() - 2; i >= 0; i--){
            if(a.get(i) < max)
                right[i] = max;
            else{
                max = a.get(i);
                right[i] = a.get(i);
            }
        }
        System.out.println("Left max array: ");
        for(int i = 0; i < a.size(); i++)
            System.out.print(left[i] + "  ");
        
        System.out.println();
        System.out.println("Rightt max array: ");
        for(int i = 0; i < a.size(); i++)
            System.out.print(right[i] + "  ");
        System.out.println();
        for(int i = 0; i < a.size(); i++){
            result += Math.min(left[i], right[i]) - a.get(i);
            System.out.print(result + "  " );
        }
        
        System.out.println();
        return result;
    }
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        a.add(0);
        a.add(1);
        a.add(0);
        a.add(2);
        a.add(1);
        a.add(0);
        a.add(1);
        a.add(3);
        a.add(2);
        a.add(1);
        a.add(2);
        a.add(1);
        System.out.println(a);
        System.out.println("Trapped water : " + trap(a));
        
    }
}