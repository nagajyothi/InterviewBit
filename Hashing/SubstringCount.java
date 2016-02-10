import java.util.*;
public class SubstringCount {
    public static void count(String s, int length){
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i <= s.length() - length; i++){
            String temp = s.substring(i, i + length);
            System.out.println("Substring: " + temp);
            if(map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            }
            else {
                map.put(temp, 1);
            }
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {            
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        String s = "ABCGRETCABCG";
        int length = 3;
        count(s, 3);
    }
}