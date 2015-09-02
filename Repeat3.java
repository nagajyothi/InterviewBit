/*
 * You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.
 * 
 If so, return the integer. If not, return -1.
 
 If there are multiple solutions, return any one.
 
 Example :
 
 Input : [1 2 3 1 1]
 Output : 1 
 1 occurs 3 times which is more than 5/3 times. 
 */
import java.util.*;
public class Repeat3{
    public static int repeatedNumber(final List<Integer> A) {
        int repeatedNumber = 0;
        int n = A.size();
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            int element = A.get(i);
            if(!count.containsKey(element)){
                count.put(element, 1);
            }
            else
                count.put(A.get(i), count.get(element)+1);
        }
        for(int key : count.keySet()){
            if(count.get(key) > n/3)
                return key;
        }
            
        return -1;
    }
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(1);
        A.add(1);
        System.out.println(repeatedNumber(A));
    }
}