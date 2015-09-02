/*
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * 
 If the fractional part is repeating, enclose the repeating part in parentheses.
 
 Example :
 
 Given numerator = 1, denominator = 2, return "0.5"
 Given numerator = 2, denominator = 1, return "2"
 Given numerator = 2, denominator = 3, return "0.(6)"
 */
import java.util.*;
public class Fraction{
    public static String fractionToDecimal(int n, int de) {
        if(n == 0)
            return "0";
        if(de == 0)
            return "";
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        String tempResult = "";
        String result = "";
        if ((n < 0) && (de > 0) || (n > 0) && (de < 0)) {
            result += "-";
        }
        long numerator = n;
        long denominator = de;
       numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        System.out.println("numerator : " + numerator);
        System.out.println("denominator : " + denominator);
        long res = numerator/denominator;
        result += String.valueOf(res);
        
        long remainder = (numerator % denominator) * 10;
        System.out.println("remainder after calculating before . part: " + remainder);
        if(remainder == 0)
            return result;
        
        result += '.';
        
        while(remainder != 0){
            System.out.println("remainder : " + remainder);
            if(map.containsKey(remainder)){
                int beg = map.get(remainder);
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }
            map.put(remainder, result.length());
            res = remainder/denominator;
            result += String.valueOf(res);
            remainder = (remainder % denominator) * 10;
        }
        
        
        
        return result;
        
    }
    public static void main(String[] args){
        int numerator = Integer.parseInt(args[0]);
        int denominator = Integer.parseInt(args[1]);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
        System.out.println(fractionToDecimal(numerator, denominator));
    }
}
/*
 * //System.out.println(j);
 for(int i = j; i < tempResult.length(); i++){
 
 if(!map.containsKey(tempResult.charAt(i)))
 map.put(tempResult.charAt(i), 1);
 else{
 int k = map.get(tempResult.charAt(i));
 //System.out.println("j: " +  j);
 
 map.put(tempResult.charAt(i), ++k);
 }
 
 }
 if(map.size() == 1 && map.containsKey('0')){
 if((n < 0 && de > 0 )||(n > 0 && de < 0)){
 result = "-" + result;
 }
 return result;
 }
 else
 result += '.';
 
 Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
 while(iterator.hasNext()){
 Map.Entry<Character, Integer> entry = iterator.next();
 
 if(entry.getValue() > 1){
 result += "(" + entry.getKey() + ")";
 }
 else
 result += entry.getKey();
 
 // System.out.printf("Key : %s and Value: %s %n", entry.getKey(), entry.getValue());
 
 }
 if((n < 0 && de > 0 )||(n > 0 && de < 0)){
 result = "-" + result;
 }
 */