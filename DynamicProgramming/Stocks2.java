/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 
 Example :
 
 Input : [1 2 3]
 Return : 2
 */
import java.util.*;
public class Stocks2{
    public static int maxProfit(final List<Integer> a) {
        int profit = 0;
        for(int i = 1; i < a.size(); i++){
            int diff = a.get(i) - a.get(i-1);
            if(diff > 0)
                profit += diff;
            
        }
        return profit;
    }
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.println(maxProfit(a));
    }
}