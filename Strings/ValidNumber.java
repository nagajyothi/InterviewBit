/*
 * Validate if a given string is numeric.
 * 
 Examples:
 
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 
 Some questions to ask the interviewer:
 
 Is 1u ( which may be a representation for unsigned integers valid?
 For this problem, no.
 Is 0.1e10 valid?
 Yes
 -01.1e-10?
 Yes
 Hexadecimal numbers like 0xFF?
 Not for the purpose of this problem
 3. (. not followed by a digit)?
 No
 Can exponent have decimal numbers? 3e0.1?
 Not for this problem.
 Is 1f ( floating point number with f as prefix ) valid?
 Not for this problem.
 How about 1000LL or 1000L ( C++ representation for long and long long numbers )?
 Not for this problem.
 How about integers preceded by 00 or 0? like 008?
 Yes for this problem
 */
public class ValidNumber{
//    public static int isNumber(final String a) {
//        if(a == null || a.length() == 0 || a.charAt(a.length()-1) == '.')               
//            return 0;
//        int dotFlag = 0;
//        int numFlag = 0;
//        int eFlag = 0;
//        for(int i = 0; i < a.length(); i++){
//            char temp = a.charAt(i);
//            if((temp >= '0' && temp <= '9') || temp == 'e')
//                numFlag = 1;
//            if(temp == ' ' && i > 0) return 0;
//            if(temp == 'e' && eFlag == 0)
//                eFlag = 1;
//            else if(temp == 'e' && eFlag == 1)
//                return 0;
//            if(temp == '.') {
//                if(dotFlag == 0 && eFlag == 0)                   
//                    dotFlag = 1;
//                else if((eFlag == 1 && dotFlag == 0) || dotFlag == 1)
//                    return 0;
//            }
////            if((i < a.length()-2 && temp == '.') && (a.charAt(i+1) <= '0' && a.charAt(i+1) >= '9'||a.charAt(i+1) == 'e')) {
////                if(dotFlag == 1) return 0;
////                if(dotFlag == 0 && eFlag == 0)                   
////                    dotFlag = 1;
////                else if(eFlag == 1 && dotFlag == 0)
////                    return 0;
////            }
//            
//        }
//        //if(numFlag == 1)
//        return 1;
//        //else 
//        //return 0;
//    }
    
    
    //Solution Approach
    public static int isNumberSolution(final String a) {
        if(a == null || a.length() == 0 || a.charAt(a.length()-1) == '.' )
            return 0;
        int i = 0;
        int dot = 0;
        int e = 0;
        int num = 0;
        char temp = a.charAt(i);
        //System.out.println(a.length());
        if(temp == '+' || temp == '-' || temp == ' ')
            i++;
        while(i < a.length()){
            temp = a.charAt(i);
            //System.out.print(temp + " ");
            if((temp >= '0' && temp <= '9') ){
                num++;                
            }
            else if(temp == '+' || temp == '-'|| temp == ' '){
                
            }
            else if(temp == '.' && i < a.length()-1 && (a.charAt(i+1) >= '0' && a.charAt(i+1) <= '9')){
                if(e > 0)
                    return 0;
                else
                    dot++;
            }
            else if(temp == 'e'){
                e++;
            }            
            else
                return 0;
            i++;
        }
        //System.out.println();
        //System.out.println(num + " " +  e + " " + dot);
        if(num < 1) return 0;
        if(dot > 1 || e > 1) return 0;
        
        return 1;
        
    }
    /*Using Regex = 
                (0 or more Spaces) 
    followed by (- or + sign )  
    followed by (0 to 9 numbers) 0 or more 
    followed by (.)  
    followed by (0 - 9 numbers) one or more  
    followed by (e)  
    followed by (- or + sign)  
    followed by (0 to 9 numbers) one or more
    followed by (0 or more spaces)
    */
    public int isNumber(final String A) {
        return (A.matches("\\s*[\\-\\+]?([0-9]*\\.?)?[0-9]+(e[\\-\\+]?[0-9]+)?\\s*")) ? 1 : 0;
    }
    public static void main(String[] args) {
        String a = "1.e1";
        //System.out.println();
        System.out.println(isNumberSolution(a));            
    }
}