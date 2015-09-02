/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 
 Example :
 
 Input : [1 2]
 Return :  1
 
 http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-java/
 */
import java.util.*;
public class Stocks1{
    public static int maxProfit(final List<Integer> a) {
        if(a == null || a.size() == 0)
            return 0;
        int profit = 0;
        
        int minElement = Integer.MAX_VALUE;
        for(int i = 0; i < a.size(); i++){
            System.out.println("For i : " + i);
            profit = Math.max(profit, a.get(i) - minElement);
            System.out.println("\t Profit = " + profit);
            minElement = Math.min(minElement, a.get(i));
            System.out.println("\t minElement : " + minElement);           
        }
        return profit;
        
    }
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        System.out.println(maxProfit(a));
    }
}