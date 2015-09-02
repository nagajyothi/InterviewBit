/*
 * Pretty print a json object using proper indentation.
 * 
 Every inner brace should increase one indentation to the following lines.
 Every close brace should decrease one indentation to the same line and the following lines.
 The indents can be increased with an additional ‘\t’
 Example 1:
 
 Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
 Output : 
 { 
 A:"B",
 C: 
 { 
 D:"E",
 F: 
 { 
 G:"H",
 I:"J"
 } 
 }     
 }
 Example 2:
 
 Input : ["foo", {"bar":["baz",null,1.0,2]}]
 Output : 
 [
 "foo", 
 {
 "bar":
 [
 "baz", 
 null, 
 1.0, 
 2
 ]
 }
 ]
 [] and {} are only acceptable braces in this case.
 
 Assume for this problem that space characters can be done away with.
 
 Your solution should return a list of strings, where each entry corresponds to a single line. The strings should not have “\n” character in them.
 */
import java.util.*;
public class PerttyJson{
    public static ArrayList<String> prettyJSON(String a) {
        System.out.println("Entering function");
        ArrayList<String> result = new ArrayList<String>();
        int indentation = 0;
        String temp = "";
        for(int i = 0; i < a.length(); i++){
            char c = a.charAt(i);  
            System.out.println("c : " + c);
            if(c == ' ')
                continue;
            else if(c == '[' || c == '{'){
                temp += c;             
                for(int j = indentation; j > 0; j--)
                    temp = "\t" + temp;
                System.out.println("temp : " + temp);               
                result.add(temp);
                temp = "";
                indentation++;
                System.out.println("indentation : " + indentation);
            }
            
            else if(c == ']' || c == '}'){
                if(i < a.length()-1 && a.charAt(i+1) == ','){
                    temp += c;
                    temp += a.charAt(++i);
                    indentation--;
                    System.out.println("indentation : " + indentation);
                    for(int j = indentation; j > 0; j--)
                        temp = "\t" + temp;
                    System.out.println("temp : " + temp);
                    result.add(temp);
                    temp = ""; 
                }
                else{
                    temp += c;
                    indentation--;
                    System.out.println("indentation : " + indentation);
                    for(int j = indentation; j > 0; j--)
                        temp = "\t" + temp;
                    System.out.println("temp : " + temp);
                    result.add(temp);
                    temp = ""; 
                }
            }
            else if(c == ':' && (a.charAt(i+1) == '{' || a.charAt(i+1) == '[')){                
                temp = temp + c;
                for(int j = indentation; j > 0; j--)
                    temp = "\t" + temp;
                System.out.println("temp : " + temp);
                result.add(temp);
                temp = "";
            }
            else if(c == ':' && (a.charAt(i+1) != '{' || a.charAt(i+1) != '['))
                temp = temp + c;
            
            else if(c == ',' || c == ':' || a.charAt(i+1) == '}' || a.charAt(i+1) == ']'|| a.charAt(i+1) == '{' || a.charAt(i+1) == '['){
                temp = temp + c;
                System.out.println("indentation : " + indentation);
                for(int j = indentation; j > 0; j--)
                    temp = "\t" + temp;
                System.out.println("temp : " + temp);
                result.add(temp);
                temp = "";
            }
            
            else{
                temp = temp + c;
            }                       
        }
        for(int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
        return result;
    }
//    public static void add(String s, int indentation, ArrayList<String> result){
//        
//        System.out.println("Entering add");
//        for(int i = 0; i < result.size(); i++)
//            System.out.println(result.get(i));
//        for(int i = indentation; i > 0; i++)
//            s = "\t" + s;
//        result.add(s);
//    }
    public static void main(String[] args){
        String s = "{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}";
        //{\"bar\":[\"baz\",null,1.0,2]}]";
        ArrayList<String> result = prettyJSON(s);
        for(int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }
}