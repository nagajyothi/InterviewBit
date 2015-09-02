/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
 * 
 You may assume that the array is non-empty and the majority element always exist in the array.
 
 Example :
 
 Input : [2, 1, 2]
 Return  : 2 which occurs 2 times which is greater than 3/2. 
 */
import java.util.*;
public class Majority{
    public int majorityElement(final List<Integer> a) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int majorElement = Integer.MIN_VALUE;
        for(int i : a){
            if(map.containsKey(i))
                map.put(i, map.get(i) + 1);
            map.put(i, 1);
        }
        
        Iterator it = map.entrySet.iterator();
        int maxValue = Integer.MIN_VALUE;
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            if(pair.getValue() > maxValue){
                maxValue = pair.getValue();
                majorElement = pair.getKey();
            }
        }
        return majorElement;
        
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(1);
        a.add(2);
        System.out.println(majorityElement(a));
    }
    
}