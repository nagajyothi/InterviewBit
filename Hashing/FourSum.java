/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target ? Find all unique quadruplets in the array which gives the sum of target.
 * 
 Note:
 
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ? b ? c ? d)
 The solution set must not contain duplicate quadruplets.
 Example : 
 Given array S = {1 0 -1 0 -2 2}, and target = 0
 A solution set is:
 
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 (-1,  0, 0, 1)
 Also make sure that the solution set is lexicographically sorted.
 Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])
 */
import java.util.*;
public class FourSum{
    public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
        if(a.size() < 4)
            return null;
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < a.size()-3; i++){
            for(int j = i+1; j < a.size()-2; j++){
                for(int k = j +1; k < a.size()-1; k++){
                    for(int x =  k + 1; x < a.size();x++){
                        int sum = a.get(i) +a.get(j) + a.get(k) + a.get(x);
                        if(sum == b){
                            ArrayList<Integer> l = new ArrayList<Integer>();
                            l.add(a.get(i));
                            l.add(a.get(j));
                            l.add(a.get(k));
                            l.add(a.get(x));                            
                            result.add(l);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    //Efficient using Hashing
    public static ArrayList<ArrayList<Integer>> fourSumSolution(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(a.size() < 4)
            return result;
        for(int i = 0; i < a.size(); i++){
            for(int j = i+1; j < a.size(); j++){
                int k =j+1;
                int l = a.size()-1;
                
                while(k < l){
                    int sum = a.get(i) +a.get(j) + a.get(k) + a.get(l);
                    if(sum > b){
                        l--;
                    }
                    else if(sum < b){
                        k++;
                    }
                    else if(sum == b){
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(a.get(i));
                        list.add(a.get(j));
                        list.add(a.get(k));
                        list.add(a.get(l));   
                        if(!set.contains(list)){
                            set.add(list);
                            result.add(list);
                        }
                        k++;
                        l--;
                    }
                    
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(0);
        a.add(-1);
        a.add(0);
        a.add(-2);
        a.add(2);
        ArrayList<ArrayList<Integer>> result = fourSumSolution(a, 0);
        for(int i= 0; i < result.size(); i++){
            for(int j : result.get(i))           
                System.out.print(j + " ");
            System.out.println();
        }
        
    }
}