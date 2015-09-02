/*
 * function to find the longest common prefix string amongst an array of strings.
 * 
 Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
 
 Example:
 
 Longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 
 Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.
 
 Example:
 
 Given the array as:
 
 [
 
 "abcdefgh",
 
 "aefghijk",
 
 "abcefgh"
 ]
 The answer would be “a”.
 */
import java.util.*;
public class LCP{
    public static String longestCommonPrefix(ArrayList<String> A) {
        StringBuilder result = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        
        for(int i = 0; i < A.size()-1; i++){
            if(minLen > A.get(i).length())
                minLen = A.get(i).length();
        }
        
        if(minLen == 0)
            return "";
        for(int j = 0; j < minLen; j++){
            char prev = '0';
            for(int i = 0; i < A.size(); i++){
                if(i == 0){
                    prev = A.get(i).charAt(j);
                    continue;
                }
                if(A.get(i).charAt(j) != prev)
                    return A.get(i).substring(0, j);
            }
        }
        return A.get(0).substring(0, minLen);
    }
    public static void main(String[] args){
        ArrayList<String> A = new ArrayList<String>();
        A.add("abcdefgh");
        A.add("aefghijk");
        A.add("abcefgh");
        System.out.println(longestCommonPrefix(A));
    }
}