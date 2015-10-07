/*
 * 
 */
import java.util.*;
public class Factors {
    public static ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        result.add(a);
        for(int i = 2; i <= a/2; i++) {
            if(a % i == 0) {
                result.add(1, i);
                //result.add(a/i);
            }
        }
        return result;
    }
    public static ArrayList<Integer> allFactorsEfficient(int a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 1; i <= Math.sqrt(a); i++) {
            if(a % i == 0) {
                result.add(i);
                if(i != Math.sqrt(a))
                    result.add(a/i);
            }
        }
        Collections.sort(result);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(allFactorsEfficient(Integer.parseInt(args[0])));
    }
}
