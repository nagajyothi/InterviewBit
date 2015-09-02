/*
 * You are given 3 arrays A, B and C. All 3 of the arrays are sorted.
 * 
 Find i, j, k such that :
 max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
 Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
 
 **abs(x) is absolute value of x and is implemented in the following manner : **
 * 
 if (x < 0) return -x;
 else return x;
 */
import java.util.*;
public class Array3Pointer{
    public static int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
        int result = Integer.MAX_VALUE;
//        int i = 0;
//        int j = 0;
//        int k = 0;
        for(int i = 0; i< a.size(); i++){
            for(int j = 0; j < b.size(); j++){
                for(int k = 0; k < c.size(); k++){
                    int max1 = Math.max(Math.abs(a.get(i) - b.get(j)),
                                        Math.abs(b.get(j) - c.get(k)));
                    int max2 = Math.max(max1,
                                        Math.abs(c.get(k) - a.get(i)));
                    if(max2 < result)                
                        result = max2;
                }
            }
            
        }
        return result;
    }
    //from career cup
    //http://www.careercup.com/question?id=14805690
    public static int minimizeBetter(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
        int diff = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i, j, k;
        for(i = 0, j = 0, k = 0; i < a.size() && j < b.size() && k < c.size();){
            min = Math.min(a.get(i), Math.min(b.get(j), c.get(k)));
            max = Math.max(a.get(i), Math.max(b.get(j), c.get(k)));
            diff = Math.min(diff, max - min);
            if(diff == 0)
                break;
            if(a.get(i) == min)
                i++;
            else if(b.get(j) == min)
                j++;
            else
                k++;
        }
        return diff;
        
            
    }
    
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        List<Integer> b = new ArrayList<Integer>();
        b.add(4);
        b.add(5);
        b.add(6);
        List<Integer> c = new ArrayList<Integer>();
        c.add(7);
        c.add(8);
        c.add(9);
        System.out.println(minimize(a,b,c));
        System.out.println(minimizeBetter(a,b,c));
    }
}