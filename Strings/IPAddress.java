/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.
 
 Example:
 
 Given “25525511135”,
 
 return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)
 http://blog.csdn.net/u011095253/article/details/9158449
 */
import java.util.*;
public class IPAddress{
//    public static ArrayList<String> restoreIpAddresses(String a) {
//        ArrayList<String> result = new ArrayList<String>();;
//        solve(0, result, a, 4, "");
//        return result;
//    } 
//    
//    //start: current start position to get the next part of the ip address
//    //result: the final output result
//    //n: number of parts remaining to be restored
//    //ip: the ip address found
//    public static void solve(int start, ArrayList<String> result, String s, int n, String ip){
//        //if we have exceeded the string s, return
//        if(start > s.length())
//            return;
//        
//        //if having found all four parts, and reach the end of the string, put it in result
//        if(n == 0 && start == s.length()){
//            result.add(ip.substring(0, ip.length()-1));
//        }
//        
//        //if having found all four parts, but the string s has not been fully matched, return
//        if(n == 0 && start < s.length())
//            return;
//        
//        for(int i = 1; i < 4; i++){
//            String temp = s.substring(start, i);
//            if(temp.charAt(0) == '0' && i > 1) // each part should not start with 0
//                continue;
//            String value = "255";
//            if(i == 3 && temp.compareTo("255") > 0)// each part should not be greater than 255
//                continue;
//            solve(start + i, result, s, n-1, ip + s.substring(start,i) + "."); // find next part
//        }
//        
//    }
    

    public static ArrayList<String> restoreIpAddresses(String s) {  
        ArrayList<String> res = new ArrayList<String>();  
        if (s.length()<4||s.length()>12) return res;  
        dfs(s,"",res,0);  
        return res;  
    }  
      
    public static void dfs(String s, String tmp, ArrayList<String> res, int count){  
        if (count == 3 && isValid(s)) {  
            res.add(tmp + s);  
            return;  
        }  
        for(int i=1; i<4 && i<s.length(); i++){  
            String substr = s.substring(0,i);  
            if (isValid(substr)){  
                dfs(s.substring(i), tmp + substr + '.', res, count+1);  
            }  
        }  
    }  
      
    public static boolean isValid(String s){  
        if (s.charAt(0)=='0') return s.equals("0");  
        int num = Integer.parseInt(s);  
        return num<=255 && num>0;  
    }  
    public static void main(String[] args){
        String a = "25525511135";
        for(String s : restoreIpAddresses(a)){
            System.out.println(s);
        }
    }
}