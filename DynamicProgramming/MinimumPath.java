/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 
 Note: You can only move either down or right at any point in time.
 Example :
 
 Input : 
 
 [  1 3 2
 4 3 1
 5 6 1
 ]
 
 Output : 8
 1 -> 3 -> 2 -> 1 -> 1
 */
import java.util.*;
public class MinimumPath{
    public static int minPathSum(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        int[][] dp = new int[m][n];
        dp[0][0] = a.get(0).get(0);
        
        //initialize top most row
        for(int i = 1; i < n; i++)
            dp[0][i] = dp[0][i-1] + a.get(0).get(i);
        
        //initialize left most column
        for(int j = 1; j < m; j++)
            dp[j][0] = dp[j-1][0] + a.get(j).get(0);
        
        //filling table
        
        for(int i = 1; i <m; i++){
            for(int j = 1; j < n; j++){
                if(dp[i-1][j] > dp[i][j-1])
                    dp[i][j] = dp[i][j-1] + a.get(i).get(j);
                else
                    dp[i][j] = dp[i-1][j] + a.get(i).get(j);
            }
        }
        
        return dp[m-1][n-1];
        
    }
    
    
    public int minPathSumWithDFS(int[][] grid) {
        return dfs(0,0,grid);
    }
    
    public int dfs(int i, int j, int[][] grid){
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        
        if(i<grid.length-1 && j<grid[0].length-1){
            int r1 = grid[i][j] + dfs(i+1, j, grid);
            int r2 = grid[i][j] + dfs(i, j+1, grid);
            return Math.min(r1,r2);
        }
        
        if(i<grid.length-1){
            return grid[i][j] + dfs(i+1, j, grid);
        }
        
        if(j<grid[0].length-1){
            return grid[i][j] + dfs(i, j+1, grid);
        }
        
        return 0;
    }
    
    
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(3);
        temp.add(2);
//         System.out.println(temp);
        a.add(new ArrayList<Integer>(temp));
        temp.clear();
        
        temp.add(4);
        temp.add(3);
        temp.add(1);
        a.add(new ArrayList<Integer>(temp));
        temp.clear();
        
        temp.add(5);
        temp.add(6);
        temp.add(1);
        a.add(new ArrayList<Integer>(temp));
        temp.clear();
        
        for(ArrayList<Integer> list : a)
            System.out.println(list);
        
        System.out.println(minPathSum(a));
    }
}



/*
 * int row = 0;
 int column = 0;
 int sum = start;
 int right = 0;
 int down  =0;
 while(row <= m-1 && column <= n-1){
 if(column < n-1)
 right = a.get(row).get(column + 1);
 else right = Integer.MAX_VALUE;
 if(row < m - 1)
 down = a.get(row+1).get(column);
 else down = Integer.MAX_VALUE;
 int min = Math.min(right, down);
 if(min == Integer.MAX_VALUE)
 break;
 System.out.println("Taking " + min);
 if(right < down){
 column++;
 if(column > n-1)
 column = n-1;
 }
 
 else
 row++;
 
 System.out.println("Row: " +  row + " Column = " + column);
 sum += min;
 }
 return sum;
 */