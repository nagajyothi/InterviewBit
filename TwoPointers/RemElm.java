/*
 * Remove Element
 * 
 Given an array and a value, remove all the instances of that value in the array. 
 Also return the number of elements left in the array after the operation.
 It does not matter what is left beyond the expected length.
 
 Example:
 If array A is [4, 1, 1, 2, 1, 3]
 and value elem is 1, 
 then new length is 3, and A is now [4, 2, 3]
 Try to do it in less than linear additional space complexity.
 https://gist.github.com/jibojun/8467725
 */
import java.util.*;
public class RemElm{
    public static int removeElement(ArrayList<Integer> a, int b) {
        for(int i = 0; i < a.size(); i++)
            System.out.print(a.get(i) + " ");
        System.out.println();
        int n = a.size();
        if(a == null || n == 0)
            return 0;
        int start = 0;
        for(int i = 0; i < a.size(); i++){
            if(a.get(i) != b){
                a.set(start, a.get(i));
                start++;
            }
        }
        
        for(int i = 0; i < a.size(); i++)
            System.out.print(a.get(i) + " ");
        return start;
    }
    
    //from solution
    public static int removeElementSolution(ArrayList<Integer> a, int b) {
        while(a.contains(b)){
            a.remove(new Integer(b));
        }
        for(int i = 0; i < a.size(); i++)
            System.out.print(a.get(i) + " ");
        return a.size();
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new  ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(0);
        a.add(0);
        a.add(2);
        a.add(1);
        a.add(2);
        a.add(0);
        a.add(1);
        System.out.println(removeElementSolution(a,1));
    }
}
