/*
 * There are two sorted arrays A and B of size m and n respectively.
 * 
 Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
 
 The overall run time complexity should be O(log (m+n)).
 
 Sample Input
 
 A : [1 4 5]
 B : [2 3]
 
 Sample Output
 
 3
 NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element. 
 For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5
 
 http://articles.leetcode.com/2011/03/median-of-two-sorted-arrays.html
 */
import java.util.*;
public class MedianArray{
    //By comparing the nedians of two arrays
    /*
     * 1) Calculate the medians m1 and m2 of the input arrays ar1[] 
     and ar2[] respectively.
     2) If m1 and m2 both are equal then we are done.
     return m1 (or m2)
     3) If m1 is greater than m2, then median is present in one 
     of the below two subarrays.
     a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
     b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
     4) If m2 is greater than m1, then median is present in one    
     of the below two subarrays.
     a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
     b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
     5) Repeat the above process until size of both the subarrays 
     becomes 2.
     6) If size of the two arrays is 2 then use below formula to get 
     the median.
     Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
     
     http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
     */
//    public static double findMedianSortedArraysByComparing(final List<Integer> a, final List<Integer> b) {
//        double m1; //median of a
//        double m2; //median of b
//        
//        if(a.size() +b.size() <= 0)
//            return -1.0;
//        
//        if(a.size() == 1 &&  b.size() == 1)
//            return (double)(a.get(0) +b.get(0))/2;
//        
//        if(a.size() == 2 &&  b.size() == 2)
//            return (double)(Math.max(a.get(0), b.get(0)) + Math.min(a.get(1), b.get(1)))/2;
//        
//        m1 = median(a);//get median of first array
//        m2 = median(b);//get median of second array
//        
//        if(m1 == m2)
//            return m1;
//        
//        if(m1 < m2){
//            
//        }
//        else{
//        }
//        
//        return m1;
//    }
    //Using Binary Search
    
    //Extra space
    /*
     * The basic idea is that if you are given two arrays ar1[] and ar2[] and know the length of each, you can check whether an element ar1[i] is the median in constant time. Suppose that the median is ar1[i]. Since the array is sorted, it is greater than exactly i values in array ar1[]. Then if it is the median, it is also greater than exactly j = n – i – 1 elements in ar2[].
     It requires constant time to check if ar2[j] <= ar1[i] <= ar2[j + 1]. If ar1[i] is not the median, then depending on whether ar1[i] is greater or less than ar2[j] and ar2[j + 1], you know that ar1[i] is either greater than or less than the median. Thus you can binary search for median in O(lg n) worst-case time.
     
     For two arrays ar1 and ar2, first do binary search in ar1[]. If you reach at the end (left or right) of the first array and don't find median, start searching in the second array ar2[].
     
     1) Get the middle element of ar1[] using array indexes left and right.  
     Let index of the middle element be i.
     2) Calculate the corresponding index j of ar2[]
     j = n – i – 1 
     3) If ar1[i] >= ar2[j] and ar1[i] <= ar2[j+1] then ar1[i] and ar2[j]
     are the middle elements.
     return average of ar2[j] and ar1[i]
     4) If ar1[i] is greater than both ar2[j] and ar2[j+1] then 
     do binary search in left half  (i.e., arr[left ... i-1])
     5) If ar1[i] is smaller than both ar2[j] and ar2[j+1] then
     do binary search in right half (i.e., arr[i+1....right])
     6) If you reach at any corner of ar1[] then do binary search in ar2[]
     */
    public static double getMedian(final List<Integer> a, final List<Integer> b){
        int m = a.size();
        int n = b.size();
        System.out.println("A : " + a);
        System.out.println("B : " + b);
//        if(a.get(m-1) < b.get(0))
//            return (double)(a.get(n-1) + b.get(0))/2;
//        if(b.get(n-1) < a.get(0))
//            return (double)(b.get(m-1) + a.get(0))/2;
        return getMedianRec(a, b, 0, m-1, n);
        
    }
    private static double getMedianRec(List<Integer> a, List<Integer> b, int left, int right, int n){
        int i, j;
        if(left > right)
            return getMedianRec(b, a, 0, n-1, a.size()-1);
        
        i = (left + right)/2;
        j = n - i - 1;
        
        //Recursion terminates here
        if(a.get(i) > b.get(j) && (j == n-1 || a.get(i) <= b.get(j+1))){
            /* a.get(i) is decides as median 2
             * now select the median 1 (element just before a.get(i) in merged array) to get average of both
             */
            if(i == 0 || b.get(j) > a.get(i-1))
                return (a.get(i) +b.get(j)) /2;
            else
                return (a.get(i) +a.get(i-1)) /2;
        }
        //Search in left half of a
        else if(a.get(i) > b.get(j) && j != n-1 && a.get(i) > b.get(j+1)){
            return getMedianRec(a, b, left, i-1, n);
        }
        //search in right half of a
        else{
            return getMedianRec(a,b, i+1, right, n);
        }
            
    }
    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        double median = 0;
        List<Integer> c = new ArrayList<Integer>();
        int i =0;
        int j =0;
        while(i < a.size() && j < b.size()){
            if(a.get(i) < b.get(j)){
                c.add(a.get(i));
                i++;
            }
            else if(a.get(i) > b.get(j)){
                c.add(b.get(j));
                j++;
            }
            else{
                c.add(a.get(i));
                c.add(b.get(j));
                i++;
                j++;
            }
        }
        while(i < a.size()){
            c.add(a.get(i));
            i++;
        }
        while(j < b.size()){
            c.add(b.get(j));
            j++;
        }
        
//        for(int k = 0; k < c.size(); k++){
//            System.out.print(c.get(k) + " ");
//        }
//        System.out.println();
        if(c.size() % 2 == 1){
            //System.out.println("Odd size");
            median = c.get(c.size()/2);
        }
        else{
//            System.out.println("Even size");
//            System.out.println(c.get((c.size()-1)/2));
//            System.out.println(c.get((c.size()-1)/2 + 1));
            median = (double)(c.get((c.size()-1)/2) + c.get((c.size()-1)/2 + 1))/2;
        }
        return median;
    }
    
    
    //Using divide and conquer: http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
    public static double getMedianDC(final List<Integer> a, final List<Integer> b) {
        double m1 = 0; // median of a
        double m2 = 0; // median of b
        int m = a.size();
        int n = b.size();
        
        if(m == 1 && n == 1) {
            return (a.get(0) + b.get(0)) / 2;
        }
        if(m == 2 && n == 2) {
            return (Math.max(a.get(0) + b.get(0)) + Math.min(a.get(1), b.get(1))) / 2;
        }
        
        m1 = median(a);
        m2 = median(b);
        if(m1 == m2) {
            return m1;
        }
        //if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2]
        if(m1 < m2) {
            return getMedian(
        }
    }
    
    public static double median(final List<Integer> a) {
        int n = a.size();
        if(n % 2 == 0) {
            return (a.get(n/2) + a.get(n/2 - 1)) / 2;            
        }
        return a.get(n/2);
    }
    
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        a.add(1);
        a.add(4);
        a.add(5);
        
        b.add(2);
        b.add(3);
        //getMedian(a,b);
        System.out.println(getMedian(a,b));
    }
}