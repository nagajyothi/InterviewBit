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
 */
import java.util.*;
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int len = a.size() + b.size();
        if(len % 2 == 1) {
            return findKthSmallest(a, 0, b, 0, len/2 + 1); 
        }
        return (findKthSmallest(a, 0, b, 0, len/2) + findKthSmallest(a, 0, b, 0, len/2 + 1)) / 2.0;
    }
    
    public static int findKthSmallest(final List<Integer> a, int aStart, final List<Integer> b, int bStart, int k) {
        if(aStart >= a.size()) {
            return b.get(bStart + k - 1);
        }
        if(bStart >= b.size()) {
            return a.get(aStart + k - 1);
        }
        if(k == 1) {
            return Math.min(a.get(aStart), b.get(bStart));
        }
        int aKey = 0;
        int bKey = 0;
        if(aStart + k/2 - 1 < a.size()) {
            aKey = a.get(aStart + k/2 -1);
        }
        else
            aKey = Integer.MAX_VALUE;
        if(bStart + k/2 - 1 < b.size()) {
            bKey = b.get(bStart + k / 2 -1);
        }
        else
            bKey = Integer.MAX_VALUE;
        
        if(aKey < bKey) {
            return findKthSmallest(a, aStart + k / 2, b, bStart, k - k / 2);
        }
        else {
            return findKthSmallest(a, aStart, b, bStart + k / 2, k - k / 2);
        }
    }
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        a.add(1);
        a.add(4);
        a.add(5);
        
        b.add(2);
        b.add(3);
        //getMedian(a,b);
        System.out.println(findMedianSortedArrays(a,b));
    }
}