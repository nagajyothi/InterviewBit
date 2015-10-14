/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        //find the string with minimum length
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++) {
            if(minLen > strs[i].length()) {
                minLen = strs[i].length();
            }
        }
        char prev = '0';
        for(int j = 0; j < minLen; j++) {
            for(int i = 0; i < strs.length; i++) {
                if(i == 0) {
                    prev = strs[i].charAt(j);
                    continue;
                }
                if(strs[i].charAt(j) != prev) {
                    return strs[i].substring(0, j);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }
    
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String minStr=strs[0];
        
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<minStr.length())
                minStr=strs[i];
        }
        int end=minStr.length();
        for(int i=0;i<strs.length;i++){
            int j;
            for( j=0;j<end;j++){
                if(minStr.charAt(j)!=strs[i].charAt(j))
                    break;
            }
            if(j<end)
                end=j;
        }
        return minStr.substring(0,end);
    }
    public static void main(String[] args) {
        String[] strs = {"flower","flow", "fle", "fleet"};
        System.out.println(longestCommonPrefix(strs));
    }
}