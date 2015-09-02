/*
 * Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, such that:
 * 
 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 If there are multiple such sequence of shortest length, return all of them. Refer to the example for more details.
 
 Example :
 
 Given:
 
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 Return
 
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Note:
 
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
import java.util.*;
public class WordLadder2{
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dictV) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> current = new ArrayList<String>();
        Queue<WordNode> queue  = new LinkedList<WordNode>();
        queue.offer(new WordNode(start, 1, null));                
        
        Set<String> dict = new HashSet<String>(dictV);
        dict.add(end);
        int minStep  = 0;
        
        Set<String> visited = new HashSet<String>();
        Set<String> unvisited  = new HashSet<String>();
        unvisited.addAll(dict);
        
        int preNumSteps = 0;
        
        while(!queue.isEmpty()){   
            System.out.println("Queue : " + queue);
            WordNode top = queue.poll();
            System.out.println("For Word : " + top.word);
            String word = top.word;
            int currNumSteps = top.numSteps;
            
            if(word.equals(end)){
                if(minStep == 0)
                    minStep = top.numSteps;
                if(top.numSteps == minStep && minStep != 0){
                    ArrayList<String> t = new ArrayList<String>();
                    t.add(top.word);
                    while(top.pre != null){
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                }
            }
            
            if(preNumSteps < currNumSteps)
                unvisited.removeAll(visited);
            
            preNumSteps = currNumSteps;
            
            char[] arr = word.toCharArray();
            for(int i = 0; i < arr.length; i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char temp = arr[i];
                    if(arr[i] != c)
                        arr[i] = c;
                    String newWord = new String(arr);
                    if(unvisited.contains(newWord)){                       
                        queue.offer(new WordNode(newWord, top.numSteps + 1, top));
                        visited.add(newWord);
                    }
                    arr[i] = temp;
                }
            }
            
        }
        
        
        return result;
    }
    public static void main(String[] args){
        String start = "hit";
        String end = "cog";
        ArrayList<String> dictV = new ArrayList<String>();
        dictV.add("hot");
        dictV.add("dot");
        dictV.add("dog");
        dictV.add("lot");
        dictV.add("log");
        ArrayList<ArrayList<String>> result =findLadders(start, end, dictV);  
        for(ArrayList<String> current : result)
            System.out.println(current);
    }
}