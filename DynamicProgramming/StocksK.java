/*
 * http://www.programcreek.com/2014/03/leetcode-best-time-to-buy-and-sell-stock-iv-java/
 */
import java.util.*;
public class StocksK{
    public static int maxProfit(int k, final List<Integer> a) {
        if(a == null || a.size() == 0 || k < 0)
            return 0;
        int[] local = new int[k+1];
        int[] global = new int[k+1];
        
        for(int i = 0; i < a.size() - 1; i++){
            int diff = a.get(i+1) - a.get(i);
            for(int j = k; j >= 1; j--){
                local[j] = Math.max(global[j-1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        for(int i =0; i < local.length; i++)
            System.out.print(local[i]+" ");
        
        System.out.println();
        for(int i =0; i < global.length; i++)
            System.out.print(global[i]+" ");
        
        System.out.println();
        return global[k];
        
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
        int k = Integer.parseInt(args[0]);
        System.out.println(maxProfit(k, a));
    }
}