/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",

return 5 as length("World") = 5.

Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
https://github.com/LuqiPan/LeetCode/blob/master/LengthOfLastWord.java
 */

public class LenghLast{
    public static int lengthOfLastWord(final String A) {
        int lastCount = 0;
        int count = 0;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == ' '){
                if(lastCount == 0){
                    continue;
                }
                count = lastCount;
                lastCount = 0;
            }
            else{
                lastCount++;
            }
        }
        return lastCount > 0 ? lastCount : count;
    }
    public static void main(String[] args){
        String s = "Wordl   ";
        System.out.println(lengthOfLastWord(s));
    }
}