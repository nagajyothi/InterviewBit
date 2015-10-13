/*
 * Sorted and rotated array problems
 *      3 4 5 1 2 
 * */
import java.util.*;
public class SortedAndRotated {
    public static int search(int[] a, int key, int start, int end) {        
        int mid = start + (end - start)/2;        
        if(a[mid] == key) {
            return mid;            
        }        
        
        // implies left part is sorted
        if(a[start] < a[mid]) { 
            if(key <= a[mid] && key >= a[start]) {
                return search(a, key, start, mid-1);
            }
            return search(a, key, mid + 1, end);
        }
        
        // implies the right part is sorted
        if(key >= a[mid] && key <= a[end]) {
            return search(a, key, mid + 1, end);
        }
        return search(a, key, start, mid-1);                    
    }
    
    
    
    public static void main(String[] args) {
        int [] a = {11, 15, 2, 3, 4, 6, 8, 9, 10};
        int key = 6;
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " " );
        }
        System.out.println();
        System.out.println(search(a, key, 0, a.length - 1));
    }
}