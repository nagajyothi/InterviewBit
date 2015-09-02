/*
 * Given a 2 * N Grid of numbers, choose numbers such that the sum of the numbers
 is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.
 
 Example:
 
 Grid:
 1 2 3 4
 2 3 4 5
 so we will choose
 3 and 5 so sum will be 3 + 5 = 8
 
 
 Note that you can choose more than 2 numbers
 */
import java.util.*;
public class Adjacent{
    public static int adjacent(ArrayList<ArrayList<Integer>> a) {
        if(a == null || a.size() == 0)
            return 0;
        
        int m = a.size();
        int n = a.get(0).size();
        if(n == 0)
            return 0;
        
        int[] dp = new int[n];
        ArrayList<Integer> first = a.get(0);
        ArrayList<Integer> second = a.get(1);
        
        dp[0] = Math.max(first.get(0), second.get(0));
        
        if(n < 2)
            return dp[0];
        
        dp[1] = Math.max(first.get(1), second.get(1));
        dp[1] = Math.max(dp[0], dp[1]);
        
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(first.get(i), second.get(i));
            dp[i] += dp[i-2];
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        
        for(int j = 0; j < n; j++)
            System.out.print(dp[j] + "  ");
        return dp[n-1];
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(14);
        temp.add(87);
        temp.add(36);
        temp.add(23);
        a.add(new ArrayList<Integer>(temp));
        temp.clear();
        temp.add(37);
        temp.add(59);
        temp.add(21);
        temp.add(68);
        a.add(new ArrayList<Integer>(temp));
        temp.clear();
        
        for(ArrayList<Integer> list : a)
            System.out.println(list);
        
        System.out.println(adjacent(a));
        
    }
}

/*
 * public static int adjacent(ArrayList<ArrayList<Integer>> a) {
 if(a == null || a.size() == 0)
 return 0;
 
 int m = a.size();
 int n = a.get(0).size();
 int[][] dp = new int[m][n];
 
 int j, k;
 if(m > 1 && n == 1){
 dp[0][0] = a.get(0).get(0);
 dp[1][0] = a.get(1).get(0);
 j = 2;
 k = 3;
 while(j < m){
 dp[j][0] = dp[j-2][0] + a.get(j).get(0);
 j = j +2;
 }
 while(k < m){
 dp[k][0] = dp[k-2][0] + a.get(k).get(0);
 k = k + 2;
 }
 
 }
 else if(m == 1 && n > 1){
 dp[0][0] = a.get(0).get(0);
 dp[0][1] = a.get(0).get(1);
 j = 2;
 k = 3;
 while(j < n){
 dp[0][j] = dp[0][j-2] + a.get(0).get(j);
 j = j +2;
 }
 while(k < n){
 dp[0][k] = dp[0][k-2] + a.get(0).get(k);
 k = k + 2;
 }
 }
 
 else{
 
 for(int i = 0; i < a.size(); i++){
 dp[i][0] = a.get(i).get(0);
 dp[i][1] = a.get(i).get(1);
 j = 2;
 k = 3;
 while(j < n){
 dp[i][j] = dp[i][j-2] + a.get(i).get(j);
 j = j +2;
 }
 while(k < n){
 dp[i][k] = dp[i][k-2] + a.get(i).get(k);
 k = k + 2;
 }
 }
 }
 
 //        for(int i = 0; i < a.size(); i++){
 //            dp[0][i] = a.get(0).get(i);
 //            dp[1][i] = a.get(1).get(i);
 //            j = 2;
 //            k = 3;
 //            while(j < n){
 //                dp[j][i] = dp[j-2][i] + a.get(j).get(i);
 //                j = j +2;
 //            }
 //            while(k < n){
 //                dp[k][i] = dp[k-2][i] + a.get(k).get(i);
 //                k = k + 2;
 //            }
 //        }
 
 for(int i = 0; i < m; i++){
 for(j = 0; j < n; j++)
 System.out.print(dp[i][j] + "  ");
 System.out.println();
 }
 int max = Integer.MIN_VALUE;
 for(int i = 0; i < m; i++){
 for(j = 0; j < n; j++)
 max = Math.max(dp[i][j],max);
 //System.out.println();
 }
 
 return max;
 }
 */