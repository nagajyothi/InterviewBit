/*
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 Examples:
 
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 Note that absolute path always begin with ‘/’ ( root directory )
 Path will not have whitespace characters.
 
 http://www.programcreek.com/2014/04/leetcode-simplify-path-java/
 */
import java.util.*;
public class SimplifyPath{
//    public static String simplifyPath(String a) {
//     if(a.length() == 0 || a == null) return null;
//     Stack<String> stack = new Stack<String>();
//     String result = "";
//     for(int i = 0; i < a.length(); i++){
//         char c = a.charAt(i);
//         //if(c != '/' || c != '.')
//         stack.push(Character.toString(c));
//     }
//     if(stack.peek() == "/"){
//         String s = stack.pop();
//     }
//     while(stack.peek() != "/"){
//             result = stack.pop() + result;
//     }
//     result = "/" + result;
//     return result;
// }
    
//    public static String simplifyPath(String a) {
//        Stack<String> stack = new Stack<String>();
        
        //remove all ending "/"
//       while(a.length() > 0 && a.charAt(a.length() - 1) == '/')
//            a = a.substring(0, a.length()-1);
        
        /*suppose path = "/a/./b/../../c/"        
         * push /a
                /.
                /b
                /..
                /..
                /c
         * 
         * 
        */ 
//       int start = 0;
//        for(int i = 1; i < a.length(); i++){
//            if(a.charAt(i) == '/'){
//                System.out.println("when c = / \n" + a.substring(start, i));
//                stack.push(a.substring(start, i));
//                start = i;
//            }
//            else if(i == a.length()-1){
//                System.out.println("When i = a.length()-1 \n"+a.substring(start));
//                stack.push(a.substring(start));
//            }
//        }
        
      
        //take the result in linkedlist    
//        LinkedList<String> result = new LinkedList<String>();
//        int back = 0;
//        while(!stack.isEmpty()){
//            String top = stack.pop();
//            System.out.println("top = " + top);
//            if(top.equals("/.") || top.equals("/")){
                //nothing
//            }
//            else if(top.equals("/.."))
//                back++;
//            else {
//                if(back > 0)
//                    back--;
//                else
//                    result.push(top);
                    
//            }
            
//        }
//        System.out.println("result :" );
//        for(String s : result)
//            System.out.print(s + " ");
//        System.out.println();
//        if(result.isEmpty())
//            return "/";
//        StringBuilder sb = new StringBuilder();
//        while(!result.isEmpty()){
//            String s = result.pop();
//            sb.append(s);
            //System.out.println(sb.toString());
//        }
//        return sb.toString();
            
        
        
//    }

 
  public String simplifyPath(String path) {
        
    if (path == null || path.charAt(0) != '/') 
        return null;  
   
    String[] parts = path.split("/");  
   
    Stack stk = new Stack();  
   
    for (String part : parts) {  
        if (part.equals("..") && !stk.isEmpty()) 
             stk.pop();  
        else if (!part.equals(".") && !part.equals("..") && !part.isEmpty())  
             stk.push(part);  
     
   }  
   
   // print new path  
   if (stk.isEmpty()) return "/";  
   StringBuilder sbuild = new StringBuilder();  
    while (!stk.isEmpty()) {  
      sbuild.insert(0, "/" + stk.pop());  
   }
   return sbuild.toString();  
   }
 
 
    public static void main(String[] args){
        String a =  "/a/./b/../../c/";
        String i = simplifyPath(a);
    }
}
