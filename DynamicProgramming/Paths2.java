/*
 * Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).
 * 
 Now consider if some obstacles are added to the grids. How many unique paths would there be?
 An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 
 Example :
 There is one obstacle in the middle of a 3x3 grid as illustrated below.
 
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.
 
 Note: m and n will be at most 100. 
 */
import java.util.*;
public class Paths2 {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
        if(a.size() == 0 || a== null)
            return 0;
        
        int m = a.size();
        int n = a.get(0).size();
        if(a.get(0).get(0) == 1 || a.get(m-1)(n-1))
            return 0;
        
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        for(int i = 1; i < m; i++){
            if(a.get(i).get(0) == 1)
                dp[i][0] = 0;
            else
                dp[i][0] = dp[i-1][0];
        }
        
        for(int i = 1; i < n; i++){
            if(a.get(0).get(i) == 1)
                dp[0][i] = 0;
            else
                dp[0][i] = dp[0][i-1];
        }
         for(int i = 1; i < m; i++){
             for(int j = 1; j < n; j++){
                 if(a.get(i).get(j) == 1)
                     dp[i][j] = 0;
                 else
                     dp[i][j] = dp[i-1][j] + dp[i][j-1];
                 
             }
         }
        return dp[m-1][n-1];
        
            
    }
    
    public static void main(String[] args){
        
    }
}
