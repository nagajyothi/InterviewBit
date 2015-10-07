/*
 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 * 
 If there is no solution possible, return -1.
 
 Example :
 
 A : [3 5 4 2]
 
 Output : 2 
 for the pair (3, 4)
 */
import java.util.*;
public class MaxDist{
    public static int maximumGap(final List<Integer> a) {
        int maxDiff = -1;
        int i;
        int j;
        int[] leftMin = new int[a.size()];
        int[] rightMax = new int[a.size()];
        
        leftMin[0] = a.get(0);
        for(i = 1; i < a.size(); i++)
            leftMin[i] = Math.min(leftMin[i-1], a.get(i));
        System.out.print("Left Min : ");
        for(i = 0; i < a.size(); i++)
            System.out.print(leftMin[i] + " ");
        
        rightMax[a.size()-1] = a.get(a.size()-1);
        for(j = a.size()-2; j >= 0; j--)
            rightMax[j] = Math.max(rightMax[j+1], a.get(j));
        
        System.out.println();
        System.out.print("Right Max : ");
        for(i = 0; i < a.size(); i++)
            System.out.print(rightMax[i] + " ");
        
        
        i = 0;
        j = 0;
        System.out.println();
        while(j < a.size() && i < a.size()){
            System.out.printf("For i : %d and j : %d ", i, j);
            if(leftMin[i] < rightMax[j]){
                maxDiff = Math.max(j - i, maxDiff);
                j++;
            }
            else
                i++;
            
            System.out.printf("maxDiff : %d \n", maxDiff);
        }
        
        
        return maxDiff;
        
    }
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        a.add(3);
        a.add(5);
        a.add(4);
        a.add(2);
        
//        a.add(1);
//        a.add(10);
        System.out.println(maximumGap(a));
    }
}