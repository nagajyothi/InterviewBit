/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * 
 For example, S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".
 */
import java.util.*;
public class MinimumWindowSubString {
    public static String minWindow(String s, String t) {
        String result = "";
        HashMap<Character, Integer> target = new HashMap<>();
        for(int i = 0;  i < t.length(); i++) {
            if(target.containsKey(t.charAt(i))){
                target.put(t.charAt(i), target.get(t.charAt(i)) + 1);
            }
            else {
                target.put(t.charAt(i), 1);
            }
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int minLen = s.length() + 1;
        
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(target.containsKey(c)) {
                if(map.containsKey(c)) {
                    if(map.get(c) < target.get(c)) {
                        count++;
                    }
                    map.put(c, map.get(c) + 1);                    
                }
                else {
                    map.put(c, 1);
                    count++;
                }
            }
            
            if(count == t.length()) {
                char sc = s.charAt(left);
                while(!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
                    if(map.containsKey(sc) && map.get(sc) > target.get(sc)) {
                        map.put(sc, map.get(sc) - 1);                        
                    }
                    left++;
                    sc = s.charAt(left);
                }
                if(i - left + 1 < minLen) {
                    result = s.substring(left, i+1);
                    minLen = i - left + 1;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}