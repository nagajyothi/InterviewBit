/*
 * Given numRows, generate the first numRows of Pascal’s triangle.
 * 
 Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
 
 Example:
 
 Given numRows = 5,
 
 Return
 [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ] 
 */
import java.util.*;
public class Pascal2{
    public static ArrayList<ArrayList<Integer>> generate(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(A <= 0)
            return result;
        ArrayList<Integer> preRow = new ArrayList<Integer>();        
        preRow.add(1);
        result.add(preRow);                
        for(int i = 2; i <= A; i++){
            ArrayList<Integer> currRow = new ArrayList<Integer>(); 
            currRow.add(1);
            for(int j = 0; j < preRow.size()- 1; j++){
                currRow.add(preRow.get(j) + preRow.get(j+1));
            }
            currRow.add(1);
            result.add(currRow);
            preRow = currRow;
        }                
        return result;
    }
    public static void main(String[] args){
        int A = Integer.parseInt(args[0]);
        ArrayList<ArrayList<Integer>> result = generate(A);
        System.out.print("[");
        for(int i = 0; i < result.size(); i++) {
            System.out.print("[");
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j));
                if(j != result.get(i).size()-1)
                    System.out.print(", ");
            }
            if(i != result.size()-1)
                System.out.print("], ");
            else
                System.out.print("]");
            
        }
        System.out.print("]");
    }
}