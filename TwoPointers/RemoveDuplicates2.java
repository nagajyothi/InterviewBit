
/*
 * Remove Duplicates from Sorted Array
 * 
 Given a sorted array, remove the duplicates in place such that each element appear atmost twice and return the new length.
 
 Do not allocate extra space for another array, you must do this in place with constant memory.
 
 Note that even though we want you to return the new length, make sure to change the original array as well in place
 
 For example,
 Given input array A = [1,1,1,2],
 
 Your function should return length = 3, and A is now [1,1,2].
 */
import java.util.*;
public class RemoveDuplicates2{
    //Working but Time Complexity exceeded
    public static int removeDuplicates(ArrayList<Integer> a) {
        Collections.sort(a);
        System.out.println("After Sorting: " + a);
        int index = 1;
        int n = a.size();
        for(int i = 2; i < n; i++){
            if(!a.get(i).equals(a.get(index - 1))){
                index++;
                a.set(index, a.get(i));
                //index++;
            }
            
            
        }
        System.out.println("After removing: " + a);
        return index + 1;
        
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
        a.add(5000);
        a.add(5000);
        a.add(5000);
        System.out.println(removeDuplicates(a));
    }
}