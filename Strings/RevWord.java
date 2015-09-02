/*
 * Given an input string, reverse the string word by word.
 * 
 Example:
 
 Given s = "the sky is blue",
 
 return "blue is sky the".
 
 A sequence of non-space characters constitutes a word.
 Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
 If there are multiple spaces between words, reduce them to a single space in the reversed string.
 */
public class RevWord{
    public static String reverseWords(String a) {               
        if(a == null || a.length() == 0)
            return "";
        StringBuilder result = new StringBuilder();
        String[] arr = a.split(" " );
        for(int i = arr.length - 1; i >= 0; i--){
            if(!arr[i].equals("")){
                result.append(arr[i]).append(" ");
            }
        }
        return result.length() == 0 ? "" : result.substring(0, result.length()-1);
        
//        Stack<String> stack = Stack<String();
//        String result = "";
//        String temp = "";
//        int n = a.length();
//        for(int i = n-1;  i >= 0; i--){
//            if(a.charAt(i) == ' '){                
//                stack.push(temp);
//                temp = "";
//            }
//            else{
//                temp = a.charAt(i) + temp;
//            }                                       
//        }
//        while(!stack.isEmpty()){
//            result += stack.pop() + " ";
//        }
//        return result;
    }
    public static void main(String[] args){
        String s = "blue is sky the";
        System.out.println(reverseWords(s));
    }
}