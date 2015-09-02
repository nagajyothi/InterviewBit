/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 Example:
 
 "A man, a plan, a canal: Panama" is a palindrome.
 
 "race a car" is not a palindrome.
 
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 http://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/ 
 */
public class Palindrome{
    public static int isPalindrome(String A) {
        if(A == null || A.length() == 1)
            return 0;
        
        A = A.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int n = A.length();
        System.out.println(A);
        for(int i = 0; i < n/2; i++){
            if(A.charAt(i) != A.charAt(n-1-i))
                return 0;
        }
        return 1;
    }
    public boolean isAlpha(char a){
        if((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z'))
            return true;
        return false;
    }
    public boolean isNum(char a){
        if(a >= '0' && a <= '9')
            return true;
        return false;               
    }
    
    public boolean isSame(char a, char b){
        if(isNum(a) && isNum(b)){
            return a == b;
        }
        else if(Character.toLowerCase(a) == Character.toLowerCase(b)){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
