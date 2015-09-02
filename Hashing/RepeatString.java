/*
 * Given a string, 
 find the length of the longest substring without repeating characters.
 
 Example:
 
 The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 
 For "bbbbb" the longest substring is "b", with the length of 1.
 */
import java.util.*;
public class RepeatString{
    public static int lengthOfLongestSubstring(String a) {
        HashSet<Character> set = new HashSet<Character>();
        int maxLength = Integer.MIN_VALUE;
        int length = 0;
        for(int i = 0; i < a.length(); i++){
            if(set.contains(a.charAt(i))){
                length--;
                set.remove(a.charAt(i));
            }
            set.add(a.charAt(i));
            length++;
            if(length  > maxLength){
                maxLength = length;
            }
        }
        return maxLength;
    }
    
    //from solution
    public static int lengthOfLongestSubstringSolution(String a) {
        if(a == null)
            return 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < a.length(); i++){
            System.out.println("For Character :" + a.charAt(i) + " At i  : " + i);
            if(!map.containsKey(a.charAt(i))){
                System.out.println(" \t Put in the map");
                map.put(a.charAt(i), i);
            }
            else{
                System.out.println("\t update result and i");
                res = Math.max(res, map.size());
                i = map.get(a.charAt(i));
                System.out.println("i : "+ i);
                map.clear();
            }
        }
        return Math.max(res, map.size());
    }
    public static void main(String[] args){
        String a = args[0];
        System.out.println(lengthOfLongestSubstringSolution(a));
    }
}