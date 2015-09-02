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
    public static int majorityElement(final List<Integer> a) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int majorElement = Integer.MIN_VALUE;
        for(int i : a){
            if(map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
            map.put(i, 1);
        }
        
        Iterator it = map.entrySet().iterator();
        int maxValue = Integer.MIN_VALUE;
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            if((int)pair.getValue() > maxValue){
                maxValue = (int)pair.getValue();
                majorElement = (int)pair.getKey();
            }
        }
        return majorElement;
        
    }
    
    //Efficient no extra space
    public static int majorityElementEfficient(final List<Integer> a) {
        if(a == null)
            return -1;
        
        int maj = a.get(0);
        int count = 1;
        int n = a.size();
        
        for(int i = 1; i < n; i++){
            if(a.get(i) == maj)
                count++;
            else if(count == 1)
                maj = a.get(i);
            else 
                count--;
        }
         System.out.println("Majority element : " + maj);
        count = 0;
        for(int i = 0; i < n; i++){
            if(a.get(i) == maj)
                count++;
        }
         System.out.println("Count = " + count);
        if(count >= a.size()/2)
            return maj;
        return -1;
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(3);
        a.add(3);
        
        System.out.println(majorityElementEfficient(a));
    }
    
}