/*
 * Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
 * 
 Example:
 
 
 Input:  
 
 1 2 3
 4 5 6
 7 8 9
 
 Return the following :
 
 [ 
 [1],
 [2, 4],
 [3, 5, 7],
 [6, 8],
 [9]
 ]
 
 
 Input : 
 1 2
 3 4
 
 Return the following  : 
 
 [
 [1],
 [2, 3],
 [4]
 ]
 
 */
import java.util.*;
public class Diagonal{
    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int m = A.size();
        int n = A.get(0).size();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(A.get(0).get(0));
        result.add(new ArrayList<Integer>(temp));
        int i = 0;
        while(i < m){            
            System.out.printf("For i : %d \n", i );
            int j = i+1;
            while(j < n){
                int k = i;
                int l = j;
                temp.clear();
                System.out.printf("\t For j : %d \n", j );
                while(l >= 0 && k < m){
                    System.out.printf("\t \t For k : %d and l : %d  add \n", k, l, A.get(k).get(l) );
                    temp.add(A.get(k).get(l));
                    k++;
                    l--;
                }
                System.out.println("\t \t Temp : " + temp);
                
                result.add(new ArrayList<Integer>(temp));
                j++;                                
            }
            
            
            i++;
        }
        temp.clear();
        temp.add(A.get(m-1).get(n-1));
        result.add(new ArrayList<Integer>(temp));
        return result;
    }
    
    public static ArrayList<ArrayList<Integer>> diagonalEfficient(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int m = A.size();
        int n = A.get(0).size();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(A.get(0).get(0));
        result.add(new ArrayList<Integer>(temp));
        
        
            int j;
            int i = 0;
            j = i+1;
            while(j < n){
                int k = i;
                int l = j;
                temp.clear();
                while(k < m && l >= 0){
                    temp.add(A.get(k).get(l));
                    k++;
                    l--;
                }
                result.add(new ArrayList<Integer>(temp));
                j++;
            }
            
            i = 1;
            j = n-1;
            while(i < m){
                int k = i;
                int l = j;
                temp.clear();
                while(k < m && l >= 0){
                    temp.add(A.get(k).get(l));
                    k++;
                    l--;
                }
                result.add(new ArrayList<Integer>(temp));
                i++;
            }
                
        
        
        temp.clear();
//        temp.add(A.get(m-1).get(n-1));
//        result.add(new ArrayList<Integer>(temp));
        return result;
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(2965);
        temp.add(1638);
        temp.add(2726);
        temp.add(4245);
        A.add(new ArrayList<Integer>(temp));
        temp.clear();
        
        temp.add(3560);
        temp.add(2898);
        temp.add(356);
        temp.add(489);
        A.add(new ArrayList<Integer>(temp));
        temp.clear();
        
        temp.add(2308);
        temp.add(800);
        temp.add(2903);
        temp.add(5404);
        A.add(new ArrayList<Integer>(temp));
        temp.clear();
        for(ArrayList<Integer> t : A)
            System.out.println(t);
        
        ArrayList<ArrayList<Integer>> result  = diagonalEfficient(A);
        for(ArrayList<Integer> t : result)
            System.out.println(t);
    }
}