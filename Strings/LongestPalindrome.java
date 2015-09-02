/*
 * Given a string S, find the longest palindromic substring in S.
 * 
 Substring of string S:
 
 S[i...j] where 0 <= i <= j < len(S)
 
 Palindrome string:
 
 A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.
 
 Incase of conflict, return the substring which occurs first ( with the least starting index ).
 http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-i.html
 */
public class LongestPalindrome{
    //Did not work
    public static String longestPalindrome(String a) {
        int n = a.length();
        if(n == 0) return "";
        String longest = a.substring(0, 1);
        for(int i = 0; i < n-1; i++){
            
            String p1 = expandAroundCenter(a, i, i);
            System.out.println("p1: " + p1);
            if(p1.length() > longest.length())
                longest = p1;
            
            String p2 = expandAroundCenter(a, i, i+1);
            System.out.println("p2: " + p2);
            if(p2.length() > longest.length())
                longest = p2;
        }
        return longest;
    }
    public static String expandAroundCenter(String s, int c1, int c2){
        int l = c1;
        int r = c2;
        System.out.printf("l: %d, r = %d \n ", l, r);
        int n = s.length();
        if(l >= 0 && r <= n-1 && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        if(r > 1)
            return s.substring(l+1, r-l-1);
        else
            return s.substring(l+1, r-l);
    }
    //Did not work
    public static String longestPalindromeDP(String s) {
        int n = s.length();
        int longestBegin = 0;
        int maxLen = 1;
        boolean[][] table = new boolean[1000][1000];
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }
        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = true;
                longestBegin = i;
                maxLen = 2;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n-len+1; i++) {
                int j = i+len-1;
                if (s.charAt(i) == s.charAt(j) && table[i+1][j-1]) {
                    table[i][j] = true;
                    longestBegin = i;
                    maxLen = len;
                }
            }
        }
        System.out.println(longestBegin);
        System.out.println(maxLen);
        return s.substring(longestBegin, maxLen);
    }
    
//    public static String expandAroundCenter(String s, int c1, int c2) {
//        int l = c1, r = c2;
//        int n = s.length();
//        while (l >= 0 && r <= n-1 && s.charAt(l) == s.charAt(r)) {
//            l--;
//            r++;
//        }
//        return s.substring(l+1, r-l-1);
//    }
    
    public static String longestPalindromeSimple(String s) {
        int n = s.length();
        if (n == 0) return "";
        String longest = s.substring(0, 1);  // a single char itself is a palindrome
        for (int i = 0; i < n-1; i++) {
            String p1 = expandAroundCenter(s, i, i);
            if (p1.length() > longest.length())
                longest = p1;
            
            String p2 = expandAroundCenter(s, i, i+1);
            if (p2.length() > longest.length())
                longest = p2;
        }
        return longest;
    }
    
    //From Solution
    public static String longestPalindromeSolution(String a) {
        int n = a.length();
        if(n <= 1)
            return a;
        int start = 0;
        int maxLen = 0;
        int j;
        int k;
        for(int i = 1; i < n; i++){
            j = i-1;
            k = i+1;
            while(k < n && a.charAt(k) == a.charAt(i))
                k++;
            while(j >= 0 && a.charAt(j) == a.charAt(i))
                j--;
            while(j >= 0 && k < n && a.charAt(j) == a.charAt(k)){
                j--;
                k++;
            }
            if(k - j - 1 > maxLen){
                maxLen = k - j - 1;
                start = j + 1;                
            }                
        }
        if(maxLen == 1)
            return a.substring(0, 1);
        return a.substring(start, start + maxLen);
    }
    public static void main(String[] args){
        String s = args[0];
        System.out.println(longestPalindromeSolution(s));
    }
}