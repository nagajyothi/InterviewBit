/*
 * Another question which belongs to the category of questions which are intentionally stated vaguely. 
 Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.
 
 Implement strStr().
 
 strstr - locate a substring ( needle ) in a string ( haystack ).
 Try not to use standard library string functions for this question.
 
 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 
 NOTE:
 
 Good clarification questions:
 
 What should be the return value if the needle is empty ?
 What if both haystack and needle are empty ?
 For the purpose of this problem, assume that the return value should be -1 in both cases.
 */
public class StrStr{
    public static int strStr(final String haystack, final String needle) {
        if(haystack.isEmpty() || needle.isEmpty())
            return -1;
        if(haystack == null || needle == null)
            return -1;
        int N = haystack.length();
        int M = needle.length();
        for(int i = 0; i <= N-M; i++){
            int j;
            for(j = 0; j < M; j++){
                if(haystack.charAt(i+j) != needle.charAt(j))
                    break;                
            }
            if(j == M) return i;
        }
        return -1;
    }
    
    //better approachExplicit backup
    public static int strStrBetter(final String haystack, final String needle) {
        if(haystack.isEmpty() || needle.isEmpty())
            return -1;
        if(haystack == null || needle == null)
            return -1;
        int i, j;
        int M = needle.length();
        int N = haystack.length();
        
        for(i = 0, j = 0; i < N && j < M; i++){
            if(haystack.charAt(i) == needle.charAt(j)) 
                j++;
            else{
                i = i - j;
                j = 0;
            }
        }
        if(j == M)
            return i - M;
        else
            return -1;
    }
    public static void main(String[] args){
        String haystack = args[0];
        String needle = args[1];
        System.out.println(strStrBetter(haystack, needle));
          
    }
}