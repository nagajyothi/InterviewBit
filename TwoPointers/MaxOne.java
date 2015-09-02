/*
 * You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input : 
Array = {1 1 0 1 1 0 0 1 1 1 } 
M = 1

Output : 
[0, 1, 2, 3, 4] 

If there are multiple possible solutions, return the sequence which has the minimum start index.

https://github.com/bitec/sandbox/blob/master/src/main/java/com/alisovenko/careerup/Longest1sWithKFlips.java
 */
import java.util.*;
public class MaxOne{
    public static ArrayList<Integer> maxone(ArrayList<Integer> arr, int b) {
        int maxLength = 0;
        int start = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        int curZerosCnt = 0;
        int curStart = 0;
        int curLength = 0;
        
        
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 0) {
                curZerosCnt++;
            }
            if (arr.get(i) == 0 && curZerosCnt > b) {
                int nStart = findLeftMostZeroInclusive(arr, curStart);
                curLength -= nStart - curStart - 1;
                curStart = nStart;
                curZerosCnt--;
                continue;
            }
            if (++curLength > maxLength) {
                start = curStart;
                maxLength = curLength;
            }
            
        }
        
        // Move from start, flip m zero elements to 1
        int i = start; int j = 0;
        for (int p = b; i < arr.size()&&(p > 0 || j < maxLength); i++) {
            if (arr.get(i) == 0) {
                result.add(i);
                j++;
                p--;
            }
            else{
                result.add(i);
                j++;
            }
        }        
        return result;
    }
    
    private static int findLeftMostZeroInclusive(ArrayList<Integer> arr, int curStart) {
        int i = curStart;
        while (arr.get(i) != 0 && arr.size() > i - 1) {
            i++;
        }
        
        // returning the next element after 0
        return i + 1;
    }

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
//        a.add(1);
//        a.add(1);
        a.add(0);
        a.add(1);
        a.add(1);
//        a.add(0);
//        a.add(0);
//        a.add(1);
//        a.add(1);
        a.add(1);
        ArrayList<Integer> result = new ArrayList<Integer>();
        result = maxone(a,0);
        for(int i = 0; i < result.size(); i++)
            System.out.print(result.get(i)+ " ");
        System.out.println();        
    }
}