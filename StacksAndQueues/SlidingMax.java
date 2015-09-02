/*
 * A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position.
 * 
 Example :
 
 The array is [1 3 -1 -3 5 3 6 7], and w is 3.
 
 Window position Max
 
 [1 3 -1] -3 5 3 6 7 3
 1 [3 -1 -3] 5 3 6 7 3
 1 3 [-1 -3 5] 3 6 7 5
 1 3 -1 [-3 5 3] 6 7 5
 1 3 -1 -3 [5 3 6] 7 6
 1 3 -1 -3 5 [3 6 7] 7
 Input: A long array A[], and a window width w
 Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
 Requirement: Find a good optimal way to get B[i]
 
 Note: If w > length of the array, return 1 element with the max of the array.
 */
import java.util.*;
public class SlidingMax{
    
    public static ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(a == null || a.size() == 0)
            return result;
        if(b > a.size()){
            result.add(max(a, 0, a.size()-1));
            return result;
        }
        for(int i = 0; i <= a.size() - b; i++){
            result.add(max(a, i, i+b-1));
        }
        return result;
    }
    
    public static int max(List<Integer> a, int start, int end){
        int maximum = a.get(start);
        for(int i = start + 1; i <= end; i++){
            if(a.get(i) > maximum)
                maximum = a.get(i);
        }
        return maximum;
    }
    
    public static ArrayList<Integer> slidingMaximumEfficient(final List<Integer> a, int b) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(a == null || a.size() == 0)
            return result;
        
        int i =0;
        while(i < b){
            while(!deque.isEmpty() && a.get(deque.getLast()) <= a.get(i))
                deque.removeLast();
            deque.addLast(i++);
        }
        
        int[] max = new int[a.size() - b +1];
        max[i-b] = a.get(deque.getFirst());
        System.out.println("Deque : " +deque);
        
        while(i < a.size()){
            while(!deque.isEmpty() && a.get(deque.getLast()) <= a.get(i))
                deque.removeLast();
            deque.addLast(i);
            if(!deque.isEmpty() && i-b >= deque.getFirst())
                deque.removeFirst();
            
            ++i;
            max[i-b] = a.get(deque.getFirst());
        }
        
        System.out.println("Deque : " +deque);
        for(int j =0; j < max.length; j++)
            result.add(max[j]);


        return result;
    }
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(3);
        a.add(-1);
        a.add(-3);
        a.add(5);
        a.add(3);
        a.add(6);
        a.add(7);
        System.out.println("Given : " +a);
        ArrayList<Integer> result = slidingMaximumEfficient(a, 3);
        System.out.println(result);
    }
}