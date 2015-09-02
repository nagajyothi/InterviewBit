/*
 * Given two binary strings, return their sum (also a binary string).
 * 
 Example:
 
 a = "100"
 
 b = "11"
 Return a + b = “111”.
 */
public class AddBinary{
    static String result = "";
    private static char add(char ca, char cb, char carry){
        if(carry == '0'){ 
                if(ca == '0' && cb == '0'){
                    carry = '0';
                    result = "0" + result;
                }
                else if(ca == '1' && cb == '0'){
                    carry = '0';
                    result = "1" + result;
                }
                else if(ca == '0' && cb == '1') {
                    carry = '0';
                    result = "1" + result;
                }
                else if(ca == '1' && cb == '1') {
                    result = "0" + result;
                    carry = '1';
                }
            }
            else{
                if(ca == '0' && cb == '0'){
                    carry = '0';
                    result = "1" + result;
                }
                else if(ca == '1' && cb == '0'){
                    carry = '1';
                    result = "0" + result;
                }
                else if(ca == '0' && cb == '1') {
                    carry = '1';
                    result = "0" + result;
                }
                else if(ca == '1' && cb == '1') {
                    result = "1" + result;
                    carry = '1';
                }
            }
            return carry;
    }
    public static String addBinary(String a, String b) {
        if((a == "" || a.length() == 0) && (b == "" || b.length() == 0)){
         return "0";
     }
     if(a == "" || a.length() == 0)
     return b;
     if(b == "" || b.length() == 0)
     return a;
        char carry = '0';
        int i = a.length()-1;
        int j = b.length()-1;
        while(i >= 0 && j >= 0){
            char ca = a.charAt(i);
            i--;
            char cb = b.charAt(j);
            j--;
            carry = add(ca, cb, carry);
        }
        while(i >= 0){
            carry = add(a.charAt(i), '0', carry);
            i--;
        }
        while(j >= 0){
            carry = add('0', b.charAt(j), carry);
            j--;
        }
        if(carry == '1'){
        return carry + result;
        }
        return result;
        
    }
    public static void main(String[] args){
        String a = "1110000000010110111010100100111";
        String b = "101001";
        System.out.println(addBinary(a,  b));
    }
}