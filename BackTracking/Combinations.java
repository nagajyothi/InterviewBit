/*
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ? a2 ? … ? ak).
The combinations themselves must be sorted in ascending order.
CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
The solution set must not contain duplicate combinations.
Example, 
Given candidate set 2,3,6,7 and target 7,
A solution set is:

[2, 2, 3]
[7]
Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.
 */
import java.util.*;
public class Combinations{
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();
        if(a == null || a.size() == 0)
            return result;
        Collections.sort(a);
        
        ArrayList<Integer> currentList = new ArrayList<Integer>();
        HashSet<ArrayList<Integer>> set = new  HashSet<ArrayList<Integer>>();
        combinationSum(a, b, 0, currentList, result, set);
           
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
            combinationSum(a, b - a.get(i), i, currentList, result, set);
            currentList.remove(currentList.size() - 1);
        }
    }

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