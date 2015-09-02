/*
 * Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.
 */
import java.util.*;
public class SortColor{
    public static void sortColors(ArrayList<Integer> a) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0; i < a.size(); i++)
            System.out.print(a.get(i) + " ");
        System.out.println();
        for(int i = 0; i < a.size(); i++){
            if(a.get(i) == 0)
                count0++;
            else if(a.get(i) == 1)
                count1++;
            else if(a.get(i) == 2)
                count2++;
        }
        
        for(int i = 0; i < count0; i++)
            a.set(i, 0);
        for(int i = count0; i < count0+count1; i++)
            a.set(i, 1);
        
        for(int i = count0+count1; i < count0+count1+count2; i++)
            a.set(i, 2);
        
        System.out.print(count0 + " " +count1+" " +count2);
        System.out.println();
        for(int i = 0; i < a.size(); i++)
            System.out.print(a.get(i) + " ");
    }
    //From Solution
    public static void sortColorsSolution(ArrayList<Integer> a) {
        int n = a.size();
        int k = n-1;
        int i = 0;
        for(i = 0; i < n; i++){
            if(a.get(i) != 0)
                break;
        }
        int j = i;
        for(; i <= k; i++){
            if(a.get(i) == 0){
                int temp = a.get(i);
                a.set(i,a.get(j));
                a.set(j,temp);
                j++;
            }
            else if(a.get(i) == 2){
                int temp = a.get(i);
                a.set(i,a.get(k));
                a.set(k,temp);
                i--;
                k--;
            }
        }
        for(i = 0; i < a.size(); i++)
            System.out.print(a.get(i) + " ");
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
        sortColorsSolution(a);
    }
}