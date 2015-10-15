/*
 * Write a program that gives count of common characters presented in an array of strings.. (or array of character arrays) For eg.. for the following input strings.. 
aghkafgklt 
dfghako 
qwemnaarkf
The output should be 3. because the characters a, f and k are present in all 3 strings. Note: The input strings contains only lowercase alphabets

 */
import java.util.*;
public class CountCommonCharacters {
    public static ArrayList<Character> count(ArrayList<String> a) {
        ArrayList<Character> result = new ArrayList<Character>();
        Set<Character> set = new HashSet<Character>();
        boolean present = true;
        
        int minLengthString = Integer.MAX_VALUE;
        String minString = "";
        for(int i =0; i < a.size(); i++){
            if(minLengthString > a.get(i).length()) {
                minLengthString = a.get(i).length();
                minString = a.get(i);
            }
        }
        System.out.println(minString + " " + minLengthString);
        for(int i = 0; i < minLengthString; i++){
            char c = minString.charAt(i);
            System.out.println("For character : " + c);
            present = true;
            for(int j = 0; j < a.size(); j++) {
                 System.out.println("\t Index of character " + a.get(j).indexOf(c));
                if(a.get(j).indexOf(c) == -1) {
                    present = false;
                    break;
                }
            }
            if(present){
                if(!result.contains(c)) {
                   //set.add(c);
                    result.add(c);
                }
            }
        }
//        for(Character c: set) {
//            result.add(c);
//        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        a.add("aghkafgklt");
        a.add("dfghako");
        a.add("qwemnaarkf");
        System.out.println(count(a));
    }
}
/*
 * C:\Users\ngunti\algs4\InterviewBit\Linkedin>java CountCommonCharacters
dfghako 7
For character : d
         Index of character -1
For character : f
         Index of character 5
         Index of character 1
         Index of character 9
For character : g
         Index of character 1
         Index of character 2
         Index of character -1
For character : h
         Index of character 2
         Index of character 3
         Index of character -1
For character : a
         Index of character 0
         Index of character 4
         Index of character 5
For character : k
         Index of character 3
         Index of character 5
         Index of character 8
For character : o
         Index of character -1
[f, a, k]
 */