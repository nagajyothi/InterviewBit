/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
TIP: C users, please malloc the result into a new array and return the result.
If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n

http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
 */
import java.util.*;
public class Merge{
    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int aN = a.size();
        int bN = b.size();        
        int j = 0;
        int i = 0;
        while(i < a.size() && j < b.size()){
           System.out.println("i : " + i + " j : " + j);
            if(a.get(i) < b.get(j)){
                i++;               
            }
            else if(a.get(i) > b.get(j)){
                a.add(i,b.get(j));
                i++;
                j++;                
            }
            else{
                 a.add(i,b.get(j));
                i++;
                j++;
            }
            
            System.out.print("\t");
            for(int k =0; k < a.size(); k++)
                System.out.print(a.get(k) + " ");
             System.out.println();
            System.out.print("\t");
            for(int k =0; k < b.size(); k++)
                System.out.print(b.get(k) + " ");
            System.out.println();
        }
        while(j < bN){
            a.add(b.get(j++));
        }
        for(int k =0; k < a.size(); k++)
            System.out.print(a.get(k) + " ");
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new  ArrayList<Integer>();
        a.add(1);
        a.add(2);
//        a.add(4);
//        a.add(5);
//        a.add(7);
        ArrayList<Integer> b = new  ArrayList<Integer>();
        b.add(-1);
        b.add(2);
//        b.add(5);        
//        b.add(6);
        merge(a, b);
        
    }
}