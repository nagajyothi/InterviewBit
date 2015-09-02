/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0 ? 
Find all unique triplets in the array which gives the sum of zero.

Note:

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
The solution set must not contain duplicate triplets.

For example, given array S = {-1 0 1 2 -1 -4},

A solution set is:
(-1, 0, 1)
(-1, -1, 2)

http://www.programcreek.com/2012/12/leetcode-3sum/
 */
import java.util.*;
public class ThreeSumZero{
    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(a.size() < 3)
            return result;
        Collections.sort(a);
        
        for(int i =0; i < a.size()-2; i++){
            if(i == 0 || a.get(i) > a.get(i-1)){
                int negate = -a.get(i);
                int start = i+1;
                int end = a.size()-1;
                while(start < end){
                    if(a.get(start) + a.get(end) == negate){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(a.get(i));
                        temp.add(a.get(start));
                        temp.add(a.get(end));
                        result.add(temp);
                        
                        start++;
                        end--;
                        
                        while(start < end && a.get(end) == a.get(end +1))
                            end--;
                        while(start < end && a.get(start) == a.get(start -1))
                            start++;                                                          
                    }
                    else if((a.get(start) + a.get(end)) < negate){
                        start++;
                    }
                    else {
                        end--;
                    }
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(-1);
        a.add(0);
        a.add(1);
        a.add(2);
        a.add(-1);
        a.add(-4);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result = threeSum(a);
        System.out.println();
        for(int i =0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size();j++)
                System.out.print(result.get(i).get(j) + " ");
            System.out.println();
        }
    }
}