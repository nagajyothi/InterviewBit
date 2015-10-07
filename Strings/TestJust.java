/*
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 
 Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
 Extra spaces between words should be distributed as evenly as possible.
 If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 For the last line of text, it should be left justified and no extra space is inserted between words.
 
 Your program should return a list of strings, where each string represents a single line.
 
 Example:
 
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 
 L: 16.
 
 Return the formatted lines as:
 
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Note: Each word is guaranteed not to exceed L in length. 
 */
import java.util.*;
public class TestJust {
    public static ArrayList<String> fullJustify(ArrayList<String> a, int b) {
        
        ArrayList<String> result = new ArrayList<String>();
        if(a == null || a.size() == 0)
            return result;
        int i = 0;
        int currentLength = 0;
        String temp = "";
        for(i = 0; i < a.size(); i++){
            currentLength += a.get(i).length() + 1;
            if(currentLength > b + 1) {
                result.add(temp);
                temp = "";
                currentLength = 0;
                i--;
                System.out.println("Intermediate result: " + result);
            }
            else
                temp += a.get(i) + " ";
        }
        if(!temp.equals(""))
            result.add(temp);
        for(i = 0; i < result.size() - 1; i++){
            temp = result.get(i);
            String[] tempArray = temp.split(" ");
            int totalLength  = 0;
            for(int j =0; j < tempArray.length; j++)
                totalLength += tempArray[j].length();
            
            int[] spaceCount = getSpaceCount(b-totalLength, tempArray.length);
            for(int l =0; l < spaceCount.length; l++)
                System.out.print(spaceCount[l] + " " );
            System.out.println();
            temp = "";
            
            for(int j = 0; j < tempArray.length; j++){
                temp += tempArray[j];
                for(int k = 0; k < spaceCount[j]; k++)
                    temp += " ";
            }
            result.set(i, temp);
            
        }
        
        temp = result.get(result.size() - 1);
        if(temp.length() < b){
            while(temp.length() < b)
                temp += " ";
        }
        else if(temp.length() > b)
            temp = temp.substring(0, b);
        result.set(result.size() - 1, temp);
        return result;          
    }
    
    public static int[] getSpaceCount(int freeSpace, int numOfStrings) {
        int size = numOfStrings - 1;
        int[] ret = new int[size + 1];
        if(size == 0){
            ret[0] = freeSpace;
        }
        else {
            for(int i =0; i < ret.length; i++) {
                if(size != 0){
                    ret[i] = freeSpace % size == 0 ? freeSpace/size : freeSpace/(size + 1);
                }
                freeSpace = freeSpace - ret[i];
                size--;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        a.add("This");
        a.add("is");
        a.add("an");
        a.add("example");        
        a.add("of");
        a.add("text");
        a.add("justification.");
        
        int b = 16;
        ArrayList<String> result = fullJustify(a, b);
<<<<<<< HEAD
         for(int i =0; i < result.size(); i++) {
             System.out.println(result.get(i));}
=======
        System.out.println(result);
>>>>>>> origin/master
        
    }
}