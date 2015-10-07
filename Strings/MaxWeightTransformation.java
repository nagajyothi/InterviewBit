/*
 * Maximum weight transformation of a given string
 * http://www.geeksforgeeks.org/maximum-weight-transformation-of-a-given-string/
 */
import java.util.*;
public class MaxWeightTransformation {
    public static int getMaxWeight(String s) {
        int n = s.length();
        int[] lookup = new int[n];
        for(int i = 0; i < n; i++)
            lookup[i] = -1;
        
        return getMaxRec(s, 0, n, lookup);
    }
    public static int getMaxRec(String s, int i, int n, int[] lookup) {
        if(i >= n) 
            return 0;
        if(lookup[i] != -1)
            return lookup[i];
        int ans = 1 + getMaxRec(s, i+1, n, lookup);
        if(i + 1 < n) {
            if(s.charAt(i) != s.charAt(i+1)){
                ans = Math.max(ans, 4 + getMaxRec(s, i+2, n, lookup));
            }
            else {
                ans = Math.max(ans, 3 + getMaxRec(s, i+2, n, lookup));
            }
        }
        lookup[i] = ans;
        for(int j = 0; j < n; j++)
            System.out.print(lookup[j] + " ");
        System.out.println();
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(getMaxWeight(args[0]));
    }
}