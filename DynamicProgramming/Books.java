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
public class Books{
    public static int books(ArrayList<Integer> a, int b) {
        int minPages = Integer.MAX_VALUE;
        int[] max = new int[b];
        
        for(int i = 0; i < b; i++){
            max[i] += a.get(j);
        }
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(12);
        a.add(34);
        a.add(67);
        a.add(90);
        int b = Integer.parseInt(args[0]);
        System.out.println(books(a, b));
        
    }
}
