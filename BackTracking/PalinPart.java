/*
 * Given a string s, partition s such that every string of the partition is a palindrome.
 * 
 Return all possible palindrome partitioning of s.
 
 For example, given s = "aab",
 Return
 
 [
 ["a","a","b"]
 ["aa","b"],
 ]
 Ordering the results in the answer : Entry i will come before Entry j if :
 len(Entryi[0]) < len(Entryj[0]) OR
 (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
 *
 *
 *
 (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
 In the given example,
 ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
 */
import java.util.*;
public class PalinPart {
    public static  ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(a == null || a.length() == 0)
            return result;
        
        ArrayList<String> partition = new ArrayList<String>();
        addPalindrome(a, 0, partition, result);
                
        return result;
    }
    
    public static void addPalindrome(String s, int start, ArrayList<String> partition, ArrayList<ArrayList<String>> result) {
        if(start == s.length()){
            ArrayList<String> temp = new ArrayList<String>(partition);
            result.add(temp);
            return;
        }
        
        for(int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if(isPalindrome(str)) {
                partition.add(str);
                addPalindrome(s, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }            
    }
    
    
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) 
                return false;
            left++;
            right--;
        }
        return true;
                
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> result = partition("aabcb");
        System.out.println(result);
    }
}