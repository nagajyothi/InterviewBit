/*
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 Each number in C may only be used once in the combination.
 
 Note:
 
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ? a2 ? … ? ak).
 The solution set must not contain duplicate combinations.
 Example :
 
 Given candidate set 10,1,2,7,6,1,5 and target 8,
 
 A solution set is:
 
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
 Example : itertools.combinations in python.
 If you do, we will disqualify your submission retroactively and give you penalty points.
 
 http://www.programcreek.com/2014/02/leetcode-combination-sum-java/
 */
import java.util.*;
public class Combinations2{
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();
        if(a == null || a.size() == 0)
            return result;
        Collections.sort(a);
        
        ArrayList<Integer> currentList = new ArrayList<Integer>();
        HashSet<ArrayList<Integer>> set = new  HashSet<ArrayList<Integer>>();
        combinationSum(a, b, 0, currentList, result, set);
//        for(int i = 0;  i < result.size(); i++){
//            ArrayList<Intger> temp = result.get(i);
//            for(int j : temp)
//                
//        }
           
        return result;
    }
    
    
    public static void combinationSum(ArrayList<Integer> a, int b,int j, ArrayList<Integer> currentList, ArrayList<ArrayList<Integer>> result,  HashSet<ArrayList<Integer>> set){
        if(b == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>(currentList);
            if(!set.contains(temp)){
                set.add(temp);
                result.add(temp);
            }
            return;
        }
        
        for(int i = j; i < a.size(); i++){
            if(b < a.get(i))
                return;
            currentList.add(a.get(i));
            combinationSum(a, b - a.get(i), i+1, currentList, result, set);
            currentList.remove(currentList.size() - 1);
        }
    }
//    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> candidates, int target) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        
//        if(candidates == null || candidates.size() == 0) return result;
//        
//        ArrayList<Integer> current = new ArrayList<Integer>();
//        Collections.sort(candidates);
//        
//        combinationSum(candidates, target, 0, current, result);
//        
//        return result;
//    }
//    
//    public static void combinationSum(ArrayList<Integer> candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){
//        if(target == 0){
//            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
//            result.add(temp);
//            return;
//        }
//        
//        for(int i=j; i<candidates.size(); i++){
//            if(target < candidates.get(i)) 
//                return;
//            
//            curr.add(candidates.get(i));
//            combinationSum(candidates, target - candidates.get(i), i, curr, result);
//            curr.remove(curr.size()-1); 
//        }
//    }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(10);
        a.add(1);
        a.add(2);
        a.add(7);
        a.add(6);
        a.add(1);
        a.add(5);
        int b = Integer.parseInt(args[0]);
        ArrayList<ArrayList<Integer>> result = combinationSum(a, b);
        for(ArrayList<Integer> list : result)
            System.out.println(list);
        
    }
}