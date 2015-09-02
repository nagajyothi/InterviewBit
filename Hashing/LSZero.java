/*
 * Find the largest continuous sequence in a array which sums to zero.
 * 
 Example:
 
 
 Input:  {1 ,2 ,-2 ,4 ,-4}
 Output: {2 ,-2 ,4 ,-4}
 
 NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 */
import java.util.*;
public class LSZero{
    public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        int[] sum = new int[A.size() + 1];
//        sum[0] = 0;
        map.put(0, -1);
        int start = -1;
        int end = -1;
        int sum = 0;
        int maxLength  = Integer.MIN_VALUE;
        for(int i = 0; i < A.size(); i++){
            sum += A.get(i);
//            if(sum[i+1] == 0 && maxLength == Integer.MIN_VALUE){
//                start = 0;
//                end = i;
//                maxLength = Math.max(maxLength, (end - start));
//                //break;
//                
//            }
            if(map.get(sum) != null){
                if(maxLength <= (i - map.get(sum))){
                    start = map.get(sum) + 1;
                    end = i;
                    maxLength = i - map.get(sum); 
                    System.out.printf("start = %d, end = %d, maxLength = %d \n", start, end, maxLength);
                    
                }
               
            }
            
            else
                map.put(sum, i);
        }
//        System.out.print(" ");
//        for(int i = 0; i < sum.length; i++)
//            System.out.print(sum[i] + ", ");
//        System.out.println();
        if(start >= 0 && end >= 0){
            for(int i = start; i <= end; i++){
                result.add(A.get(i));
            }
        }
        return result;
    }
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<Integer>();
        //A : [ 1, 2, -2, 4, -4 ]
//        A.add(1);
//        A.add(2);
//        A.add(-2);
//        A.add(4);
//        A.add(-4);
//        
        //A : [ -1, 1, 1, -1, -1, 1, 1, -1 ]
        A.add(-1);
        A.add(1);
        A.add(1);
        A.add(-1);
        A.add(-1);
        A.add(1);
        A.add(1);
        A.add(-1);
        
//        A.add(1);
//        A.add(2);
//        A.add(-1);
//        A.add(1);
//        A.add(3);
//        A.add(-1);
//        A.add(1);
//        A.add(4);
        
//        //A : [ 1, 2, -3, 3 ]
//        A.add(1);
//        A.add(2);
//        A.add(-3);
//        A.add(3);
        System.out.println(A);
        ArrayList<Integer> result = lszero(A);
        System.out.println(result);
    }
}
/*
 *             //System.out.printf("sum[%d] = %d \n", i, sum[i]);
 * 
 //            System.out.println("in map : " + map.get(sum[i]));
 */