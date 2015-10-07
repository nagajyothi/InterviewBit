import java.util.*;
public class MaxProd{
    public static int maxProduct(final List<Integer> a) {
     int minEndingHere = 1;
            int maxEndingHere = 1;
            int maxProductSoFar = 1;
            
            for(int i = 0; i < a.size(); i++){
                //System.out.println("for a.get(i): " + a.get(i));
                if(a.get(i) > 0){
                    maxEndingHere = maxEndingHere * a.get(i);
                    minEndingHere = Math.min(minEndingHere*a.get(i), 1);
                }
                else if(a.get(i) == 0){
                    minEndingHere = 1;
                    maxEndingHere = 1;
                }
                else {
                    int temp = maxEndingHere;
                    maxEndingHere = Math.max(minEndingHere*a.get(i),1);
                    minEndingHere = temp * a.get(i);
                }
                maxProductSoFar = Math.max(maxProductSoFar, maxEndingHere);
               // System.out.println("\t MaxEndingHere = " + maxEndingHere + "\n \t minEndingHere = " + minEndingHere);
            }
            return maxProductSoFar > 1 ? maxProductSoFar : 0;
 }
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(3);
        a.add(-2);
        a.add(4);
        System.out.println(maxProduct(a));
    }
}