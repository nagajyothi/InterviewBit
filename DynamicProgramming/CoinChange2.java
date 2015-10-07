/*
 * You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of each coin in the set.
 * 
 Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).
 
 Example :
 
 Input : 
 S = [1, 2, 3] 
 N = 4
 
 Return : 4
 
 Explanation : The 4 possible ways are
 {1, 1, 1, 1}
 {1, 1, 2}
 {2, 2}
 {1, 3} 
 Note that the answer can overflow. So, give us the answer % 1000007
 http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 */
import java.util.*;
public class CoinChange2 {
    public int coinchange2(ArrayList<Integer> a, int b) {         
        int n = a.size();         
        return coinchange2HelperDP(a, n, b);                    
    }
    
    public int coinchange2Helper(ArrayList<Integer> a,int n, int b) {
        if(b == 0)
            return 1;
        if(b < 0)
            return 0;
        if(n <=0 && b >= 1)
            return 0;
        return coinchange2Helper(a, n-1, b) + coinchange2Helper(a, n, b - a.get(n-1));
    }
    
    //Using Dynamic programmin
    public int coinchange2HelperDP(ArrayList<Integer> a,int n, int b) {
        int i , j , x, y;
        int[][] dp = new int[b+1][n];
        
        for(i = 0 ; i < n; i++)
            dp[0][i] = 1;
        for(i = 1; i < b+1; i++) {
            for(j = 0; j < n; j++) {     
                
               //count solutions including a.get(j);
                int num = a.get(j);
                if(i - num >= 0)
                    x = dp[i - num][j];
                else
                    x = 0;
                
                //count solutions excluding a.get(j);                
                y = (j >= 1)? dp[i][j-1]: 0;
                
                dp[i][j] = x + y;
            }
        }
        return dp[b][n-1];
        
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(5);
        a.add(3);
        a.add(6);
        CoinChange2 cc = new CoinChange2();
        System.out.println(cc.coinchange2(a, 10));
    }
}