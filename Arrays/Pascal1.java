import java.util.*;
/*
 * Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given k = 3,

Return [1,3,3,1].
 */
public class Pascal1{
    public static ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(A < 0)
            return result;
        result.add(1);
        for(int i = 1; i <= A; i++){
            //System.out.println("result size: " + result.size());
            for(int j = result.size()-2; j >= 0; j--){
                result.set(j+1,result.get(j)+result.get(j+1));
            }
            result.add(1);
        }
        return result;
    }
    public static void main(String[] args){
        int A = Integer.parseInt(args[0]);
        ArrayList<Integer> result = getRow(A);
        for(int i = 0; i < result.size(); i++)
            System.out.print(result.get(i) + " ");
    }
}