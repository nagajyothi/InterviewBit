/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 Design an algorithm to find the maximum profit. You may complete at most two transactions.
 
 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 
 Example :
 
 Input : [1 2 1 2]
 Output : 2
 
 Explanation : 
 Day 1 : Buy 
 Day 2 : Sell
 Day 3 : Buy
 Day 4 : Sell
 
 http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-iii-java/
 */
import java.util.*;
public class Stocks3{
    public static int maxProfit(final List<Integer> a) {
        if(a == null || a.size() == 0)
            return 0;
        
        int profit = 0;
        
        int[] left = new int[a.size()];
        int[] right = new int[a.size()];
        
        left[0] = 0;
        int min = a.get(0);
        for(int i = 1; i < a.size(); i++){
            min = Math.min(min, a.get(i));
            left[i] = Math.max(left[i-1], a.get(i) - min);
        }
        
        right[a.size()-1] = 0;
        int max = a.get(a.size()-1);
        for(int i = a.size() - 2; i >= 0; i--){
            max = Math.max(max, a.get(i));
            right[i] = Math.max(right[i+1], max- a.get(i));
        }
        
        for(int i =0; i < a.size(); i++)
            profit = Math.max(profit, left[i] + right[i]);
        return profit;
    }
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(4);
        a.add(5);
        a.add(7);
        a.add(6);
        a.add(3);
        a.add(2);
        a.add(9);
        
        System.out.println(maxProfit(a));
    }
}