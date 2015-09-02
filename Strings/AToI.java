/*
 * Implement atoi to convert a string to an integer.
 * 
 Note: There might be multiple corner cases here. Clarify all your doubts from the interviewer before coding.
 
 Questions:
 
 Q1. Does string contain whitespace characters before the number?
 A. Yes
 
 Q2. Can the string have garbage characters after the number?
 A. Yes. Ignore it.
 
 Q3. If no numeric character is found before encountering garbage characters, what should I do?
 A. Return 0.
 
 Q4. What if the integer overflows?
 A. Return INT_MAX if the number is positive, INT_MIN otherwise.
 Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI.
 If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class AToI{
    public static int atoi(String a) {
        if(a == null || a.length() == 0)
            return 0;
        a = a.trim();
        double result = 0;
        int flag = 0;
        int i = 0;
        if(a.charAt(0) == '-'){
            flag = 1;
            i++;
        }
        else if(a.charAt(0) == '+')
        {
        i++;
        }
        
        while(i < a.length() && a.charAt(i) >= '0' && a.charAt(i) <= '9'){
                result = result*10 + (a.charAt(i) - '0'); 
                System.out.println(result);
                
            i++;
        }
        if(flag == 1)
            result = -result;
        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)result;
        
    }
    public static void main(String[] args){
        String a = " 7 U 0 T7165  0128862 089 39 5";
        System.out.println(atoi(a));
    }
}