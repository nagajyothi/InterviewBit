/*
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

http://www.programcreek.com/2012/12/leetcode-solution-word-break/
 */
import java.util.*;
public class WordBreak1{
    public static boolean wordbreak(String s, ArrayList<String> dictionary){
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true;
        
        for(int i = 0; i < s.length(); i++){
            if(!t[i])
                continue;
            for(String word : dictionary){
                int length = word.length();
                int end = i + length;
                if(end > s.length())
                    continue;
                if(t[end])
                    continue;
                if(s.substring(i, end).equals(word))
                    t[end] = true;
            }
        }
        return t[s.length()];
    }
    
    public static void main(String[] args){
        ArrayList<String> b = new ArrayList<String>();
        b.add("cat");
        b.add("cats");
        b.add("and");
        b.add("sand");
        b.add("dog");
        String a = "catsanddog";
        System.out.println("List is : " + b);
        System.out.println("String is  : " + a);
        
        if(!wordbreak(a, b))
            System.out.print("Not " );
        System.out.println("Breakable");
        
    }
}