/*
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * 
 Return all such possible sentences.
 
 For example, given
 
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].
 A solution is
 [ "cats and dog", "cat sand dog" ] 
 
 Make sure the strings are sorted in your result.
 
 http://www.programcreek.com/2014/03/leetcode-word-break-ii-java/
 */
import java.util.*;
public class WordBreak2{
    public static ArrayList<String> wordBreak(String a, ArrayList<String> dictionary) {
        ArrayList<String>[] dp = new ArrayList[a.length() + 1];
        dp[0] = new ArrayList<String>();
        
        
        for(int i = 0; i <= a.length(); i++){
            System.out.println("At i = " + i);
            if(dp[i] == null)
                continue;
            for(String word : dictionary){
                System.out.println("\t Word: " + word);
                int length = word.length();
                int end = i + length;
                
                if(end > a.length())
                    continue;
                System.out.println("\t substring: " + a.substring(i, end));
                if(a.substring(i, end).equals(word)){
                    System.out.println("\t \t adding to DP");
                    if(dp[end] == null)
                        dp[end] = new ArrayList<String>();
                    dp[end].add(word);
                }
            }
            System.out.println("\t DP has : ");
            for(int j = 0; j < dp.length; j++){
                System.out.println("\t \t" + dp[j]);
            }
        }
        
        ArrayList<String> result2 = new ArrayList<String>();
        HashSet<String> result = new HashSet<String>();
        if(dp[a.length()] == null)
            return result2;
        
        ArrayList<String> temp = new ArrayList<String>();
        dfs(dp, a.length(), result, temp);
        
        for(String s : result)
            result2.add(s);
        Collections.sort(result2);
        return result2;                       
    }
    
    public static void dfs(ArrayList<String>[] dp, int end, HashSet<String> result, ArrayList<String> temp){
        System.out.println("Temp : " + temp);
        if(end <= 0){
            String path = temp.get(temp.size() - 1);
            for(int i = temp.size() - 2; i >=0; i--)
                path +=  " " + temp.get(i);            
            System.out.println("\t add to DP : " + path);
            result.add(path);
            return;
        }
        
        for(String str : dp[end]){
            temp.add(str);
            dfs(dp, end - str.length(), result, temp);
            temp.remove(temp.size() - 1);
        }
    }
    
    public static void main(String[] args){
        ArrayList<String> b = new ArrayList<String>();
        b.add("cat");
        b.add("cats");
//        b.add("abbb");
        b.add("and");
//        b.add("aabbaab");
        b.add("sand");
        b.add("dog");
//        b.add("babbbabb");
//        b.add("baaaab");
        //b.add("bb");
        String a = "catsanddog";
        System.out.println("List is : " + b);
        System.out.println("String is  : " + a);
        ArrayList<String> result = wordBreak(a, b);
        for(String s: result)
            System.out.println(s);
    }
}