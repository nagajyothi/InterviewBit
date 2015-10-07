/*
 * Remove duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

Note that even though we want you to return the new length, make sure to change the original array as well in place

Do not allocate extra space for another array, you must do this in place with constant memory.

Example: 
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2].
 */
import java.util.*;
public class RemoveDuplicates{
    //Working but Time Complexity exceeded
    public static int removeDuplicates(ArrayList<Integer> a) {
        Collections.sort(a);
        for(int i = 0; i < a.size(); i++)
            System.out.print(a.get(i) + " ");
        System.out.println();
        int index = 1;
        for(int i = 1; i < a.size(); i++){            
            if(!a.get(i).equals(a.get(i-1))){
               
                a.set(index, a.get(i));
                 index++;
            }            
        }
//        for(int i = 0; i < a.size()-1; i++){
//            if(a.get(i).equals(a.get(i+1))){
//                a.remove(i);
//                i--;
//            }
//        }
        for(int i = 0; i < a.size(); i++)
            System.out.print(a.get(i) + " ");
        System.out.println();
        return index;
        
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