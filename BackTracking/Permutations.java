/*
 * Given a collection of numbers, return all possible permutations.
 * 
 Example:
 
 [1,2,3] will have the following permutations:
 
 [1,2,3]
 [1,3,2]
 [2,1,3] 
 [2,3,1] 
 [3,1,2] 
 [3,2,1]
 NOTE
 
 No two entries in the permutation sequence should be the same.
 For the purpose of this problem, assume that all the numbers in the collection are unique.
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 Example : next_permutations in C++ / itertools.permutations in python.
 If you do, we will disqualify your submission retroactively and give you penalty points.
 
 http://www.programcreek.com/2013/02/leetcode-permutations-java/
 
 
 */
import java.util.*;
public class Permutations{
    
    
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        result.add(new ArrayList<Integer>());
        for(int i =0; i < a.size(); i++){
            System.out.println("For i : " + i);
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
            
            for(ArrayList<Integer> l : result){
                
                for(int j =0; j < l.size() + 1; j++){
                    System.out.println("For J : " +  j);
                    System.out.println("list is: " + l);
                    
                    l.add(j, a.get(i));
                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);
                    System.out.println("\t current: " );
                    for(int k = 0; k< current.size(); k++)                        
                        System.out.println("\t \t" + current.get(k));
                                        
                    System.out.println("\t Temp: " + temp);
                    
                    
                    l.remove(j);
                }
            }
            result = new ArrayList<ArrayList<Integer>>(current);
        }
        return result;
        
    }
    
    //We can also recursively solve this problem. Swap each element with each element after it.
    
//    public ArrayList<ArrayList<Integer>> permute(int[] num) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        permute(num, 0, result);
//        return result;
//    }
//    
//    void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
//        
//        if (start >= num.length) {
//            ArrayList<Integer> item = convertArrayToList(num);
//            result.add(item);
//        }
//        
//        for (int j = start; j <= num.length - 1; j++) {
//            swap(num, start, j);
//            permute(num, start + 1, result);
//            swap(num, start, j);
//        }
//    }
//    
//    private ArrayList<Integer> convertArrayToList(int[] num) {
//        ArrayList<Integer> item = new ArrayList<Integer>();
//        for (int h = 0; h < num.length; h++) {
//            item.add(num[h]);
//        }
//        return item;
//    }
//    
//    private void swap(int[] a, int i, int j) {
//        int temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }
    
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        //a.add(4);
        ArrayList<ArrayList<Integer>> result = permute(a);
        for(int i = 0; i< result.size(); i++){
            
            System.out.println(result.get(i));
            
        }
    }
}