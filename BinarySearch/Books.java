/*
 * N number of books are given. 
 The ith book has Pi number of pages. 
 You have to allocate books to M number of students so that maximum number of pages alloted to a student is minimum. A book will be allocated to exactly one student. Each student has to be allocated atleast one book.
 
 NOTE: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order.
 
 Input:
 List of Books M number of students 
 
 Your function should return an integer corresponding to the minimum number.
 
 Example:
 
 P : [12, 34, 67, 90]
 M : 2
 
 Output : 113
 
 There are 2 number of students. Books can be distributed in following fashion : 
 1) [12] and [34, 67, 90]
 Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
 2) [12, 34] and [67, 90]
 Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
 3) [12, 34, 67] and [90]
 Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
 
 Of the 3 cases, Option 3 has the minimum pages = 113. 
 
 */
import java.util.*;
public class Books {
    public static int getMax(ArrayList<Integer> a) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.size(); i++) {
            max = Math.max(a.get(i), max);
        }
        return max;
    }
    
    public static int getSum(ArrayList<Integer> a) {
        int total = 0;
        for(int i = 0; i < a.size(); i++) {
            total += a.get(i);
        }
        return total;
    }        
    
    public static int getRequiredReaders(ArrayList<Integer> a, int maxLengthPerReader) {
        int total = 0;
        int readers = 1;
        for(int i = 0; i < a.size(); i++) {
            total += a.get(i);
            if(total > maxLengthPerReader) {
                total = a.get(i);
                readers++;
            }
        }
        return readers;
    }
    
    public static int books(ArrayList<Integer> a, int b) {
        int lo = getMax(a);
        int hi = getSum(a);
        f(a.size() < b)
        return -1;
        while(lo < hi) {
            int mid = (int)(lo + (hi-lo)/2);
            System.out.println("For Mid = " + mid +" \n lo = " + lo + "\n hi = " +  hi);
            int requiredReaders = getRequiredReaders(a, mid);
            if(requiredReaders <= b) {
                hi = mid;
                System.out.println("\t hi = " + hi);
            }
            else {
                lo = mid + 1;                
                System.out.println("\t lo = " + lo);
            }
        }
        return lo;
    }
    
//    public static int books(ArrayList<Integer> a, int b) {
//        
//    }
    
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
//        a.add(12);
//        a.add(34);
//        a.add(67);
//        a.add(90);
        a.add(31);
        a.add(14);
        a.add(19);
        a.add(75);
        
        int b = Integer.parseInt(args[0]);
        System.out.println(books(a, b));
        
    }
    
}