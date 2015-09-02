/*
 * Find the longest increasing subsequence of a given sequence / array.
 * 
 In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible. 
 This subsequence is not necessarily contiguous, or unique.
 In this case, we only care about the length of the longest increasing subsequence.
 
 Example :
 
 Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
 Output : 6
 The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
 
 http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 */
import java.util.*;
public class LongestIncreasingSequence{
    public static int lis(final List<Integer> a) {
        if(a == null || a.size() == 0)
            return 0;
        if(a.size() == 1)
            return 1;
        int max = Integer.MIN_VALUE;
       max = lis(a, a.size(), max);
        return max;
    }
    
    public static int lis(List<Integer> a, int n, int max){
        if(n == 1)
            return 1;
        int res = 0;
        int maxEndingHere = 1;
        
        /* Recursively get all LIS ending with arr[0], arr[1] ... ar[n-2]. If 
       arr[i-1] is smaller than arr[n-1], and max ending with arr[n-1] needs
       to be updated, then update it */
        for(int i =1; i < n; i++){
            res = lis(a, i, max);
            if(a.get(i-1) < a.get(n-1) && res + 1 > maxEndingHere)
                maxEndingHere = res + 1;            
        }
        max = Math.max(max, maxEndingHere);
        return maxEndingHere;
    }
    
    
    //Dynamic Programming
    public static int lisDynamic(final List<Integer> a) {
        if(a == null || a.size() == 0)
            return 0;
        if(a.size() == 1)
            return 1;
        int[] lis = new int[a.size()];
        int n = a.size();
        int max = Integer.MIN_VALUE;
        for(int i =0; i<n; i++)
            lis[i] = 1;
        
        for(int i = 1; i < n; i++){
            for(int j =0; j < i; j++){
                if(a.get(i) >a.get(j) && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
           for(int k = 0; k <n; k++)
            System.out.print(lis[k] + " ");
                   System.out.println();
        }
        
        for(int i =0; i < n; i++)
            max = Math.max(max, lis[i]);
        
        
        System.out.println();
        return max;
    }
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        a.add(0);
        a.add(8);
        a.add(4);
        a.add(12);
        a.add(2);
        a.add(10);
        a.add(6);
        a.add(14);
        a.add(1);
        a.add(9);
        a.add(5);
        a.add(13);
        a.add(3);
        a.add(11);
        a.add(7);
        a.add(15);
        
        System.out.println(lis(a));
        System.out.println(lisDynamic(a));
    }
}