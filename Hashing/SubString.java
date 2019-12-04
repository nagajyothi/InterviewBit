/*
 * You are given a string, S, and a list of words, L, that are all of the same length.
 * 
 Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 
 Example :
 
 S: "barfoothefoobarman"
 L: ["foo", "bar"]
 You should return the indices: [0,9].
 (order does not matter).
 */
import java.util.*;
public class SubString{
    
public static ArrayList<Integer> findSubstring(String a, final List<String> b) {
        ArrayList<Integer> result = new ArrayList<Integer>();        
        if(b.size() == 0 || a == null || b == null || a.length() == 0) 
            return result;
        
        char[] array = a.toCharArray();
        int length = array.length;
        
        int num = b.size() * b.get(0).length();
        int strLength = b.get(0).length();
        
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < b.size(); i++){
            if(map.containsKey(b.get(i)))
                map.put(b.get(i), map.get(b.get(i)) +  1);
            else
                map.put(b.get(i), 1);
        }
        
        
        
        for(int i = 0; i <= length - num; i++){ // length of string - sum of all lengths in list
            System.out.println("For i : " + i);
            HashMap<String, Integer> tempMap = (HashMap<String, Integer>)map.clone();
            for(int j = 0; j < b.size(); j++){
                System.out.println("i + j * strLength, i + (j + 1) * strLength : " + (i + j * strLength) + " " + (i + (j + 1) * strLength));
                String str = a.substring(i + j * strLength, i + (j + 1) * strLength);
                System.out.println("Checking str: " +  str);
                if(!tempMap.containsKey(str)){
                    System.out.println("tempMap does not contain " + str + " so break for loop j");
                    break;
                }
                else if(tempMap.get(str) > 1){
                    System.out.println(str + " is present in tempMap so reduce its value by 1");
                    tempMap.put(str, tempMap.get(str) -  1);
                }
                else if(tempMap.get(str) == 1){
                    System.out.println(str + " has value 1 so remove from tempMap");
                    tempMap.remove(str);
                }
            }
            if(tempMap.isEmpty())
                result.add(i);
            System.out.println();
        }
        return result;            
    }
    
   
    public static void main(String[] args){
        String a = "barfoothefoobarman";
        List<String> b = new ArrayList<String>();
        b.add("foo");
        b.add("bar");
        
        ArrayList<Integer> result = findSubstring(a, b);
        for(int i : result)
            System.out.print(i + " ");
    }
}
/*
 * public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        ArrayList<Integer> result = new ArrayList<Integer>();        
        if(b.size() == 0) 
            return result;
        
        char[] array = a.toCharArray();
        int length = array.length;
        
        int num = b.size() * b.get(0).length();
        int strLength = b.get(0).length();
        
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < b.size(); i++){
            if(map.containsKey(b.get(i)))
                map.put(b.get(i), map.get(b.get(i)) +  1);
            else
                map.put(b.get(i), 1);
        }
        
        
        HashMap<String, Integer> tempMap = (HashMap<String, Integer>)map.clone();
        for(int i = 0; i <= length - num; i++){ // length of string - sum of all lengths in list
            String s1 = a.substring(i, i + strLength);
            if(tempMap.containsKey(s1)){
                if(check(a.substring(i), strLength, num, tempMap))
                    result.add(i);
                tempMap = (HashMap<String, Integer>)map.clone();
            }            
        }
        return result;            
    }
   public boolean check(String s, int l, int n, HashMap<String, Integer> map){
     String checkWord=s;
     System.out.println(checkWord);
    String temp;
    for(int i =0; i < n; i= i + l){
        temp = s.substring(i, i + l);
        if(map.containsKey(temp)){
            // if(map.get(temp) < 1)
            //     return false;
            // else
            map.put(temp, map.get(temp) - 1);
        }                
    }
    Iterator<Integer> keyVals=map.values().iterator();
    boolean endResult=true;
    while(keyVals.hasNext()){        
        if(keyVals.next()==0){

        }else{
            endResult=false;
            return endResult;            
        }
    }
    return endResult;
}
 */
