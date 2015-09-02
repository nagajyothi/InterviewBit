/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 Return the minimum cuts needed for a palindrome partitioning of s.
 
 Example : 
 Given 
 s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 
 http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 */

import java.util.*;
public class Palin2{
    //O(n^3) approach
    public static int minCut(String a) {
        if(a.length() == 1)
            return 0;
        if(isPalindrome(a))
            return 0;
        int n = a.length();
        //cuts[i][j] = minimum cuts needed for palindrom partitioning of substring[i..j]
        int[][] cuts = new int[n][n];
        
        //palindrome[i][j] = true if substring[i..j] is palindrome, else false
        boolean[][] palindrome = new boolean[n][n];
        
        int i, j, k, l;
        
        //Every substring of length 1 is palindrome
        for(i = 0; i < n; i++){
            palindrome[i][i] = true;
            cuts[i][i] = 0;
        }
        
        /* l is substring length. Build the solution in bottom up manner by
         considering all substrings of length starting from 2 to n.
         The loop structure is same as Matrx Chain Multiplication problem (
         See http://www.geeksforgeeks.org/archives/15553 )*/
        for(l = 2; l <= n; l++){
            // For substring of length L, set different possible starting indexes
            for(i = 0; i < n - l + 1; i++){
                
                j = i + l - 1; //Set ending index
                
                // If L is 2, then we just need to compare two characters. Else
                // need to check two corner characters and value of P[i+1][j-1]
                if(l == 2)
                    palindrome[i][j] = (a.charAt(i) == a.charAt(j));
                else
                    palindrome[i][j] = (a.charAt(i) == a.charAt(j)) && palindrome[i+1][j-1];
                
                //if a[i..j] is palindrom then cuts[i][j] = 0;
                if(palindrome[i][j])
                    cuts[i][j] = 0;
                else{
                    cuts[i][j] = Integer.MAX_VALUE;
                    for(k = i; k <= j-1; k++)
                        cuts[i][j] = Math.min(cuts[i][j], cuts[i][k] + cuts[k+1][j] + 1);
                }
                
            }
        }
        return cuts[0][n-1];
        
    }
    
    //O(n^2) Approach
    public static int minCutEfficient(String a) {
        if(a.length() == 1)
            return 0;
//        if(isPalindrome(a))
//            return 0;
        int n = a.length();
        //cuts[i][j] = minimum cuts needed for palindrom partitioning of substring[i..j]
        int[] cuts = new int[n];
        
        //palindrome[i][j] = true if substring[i..j] is palindrome, else false
        boolean[][] palindrome = new boolean[n][n];
        
        int i, j, k, l;
        
        //Every substring of length 1 is palindrome
        for(i = 0; i < n; i++){
            palindrome[i][i] = true;            
        }
        
        /* l is substring length. Build the solution in bottom up manner by
         considering all substrings of length starting from 2 to n.
         The loop structure is same as Matrx Chain Multiplication problem (
         See http://www.geeksforgeeks.org/archives/15553 )*/
        for(l = 2; l <= n; l++){
            // For substring of length L, set different possible starting indexes
            for(i = 0; i < n - l + 1; i++){
                
                j = i + l - 1; //Set ending index
                
                // If L is 2, then we just need to compare two characters. Else
                // need to check two corner characters and value of P[i+1][j-1]
                if(l == 2)
                    palindrome[i][j] = (a.charAt(i) == a.charAt(j));
                else
                    palindrome[i][j] = (a.charAt(i) == a.charAt(j)) && palindrome[i+1][j-1];                                                
            }
        }
        
        for(i =0; i < n; i++){
            if(palindrome[0][i])
                cuts[i] = 0;
            else{
                cuts[i] = Integer.MAX_VALUE;
                for(j =0; j < i; j++){
                    if(palindrome[j+1][i] && (1 + cuts[j] < cuts[i]))
                        cuts[i] = cuts[j] + 1;
                }
            }
        }
        
        for(i = 0;  i < n; i++)
            System.out.print(cuts[i] + " ");
        System.out.println();
        
        return cuts[n-1];
        
    }
    
    
    
    public static boolean isPalindrome(String a){
        int n = a.length();
        for(int i = 0; i < n; i++) {
            if(a.charAt(i) != a.charAt(n - i - 1))
                return false;            
            
        }
        return true;
    }
    public static void main(String[] args){
        String a = args[0];
        System.out.println(minCutEfficient(a));
    }
}
