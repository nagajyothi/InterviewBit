/*
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * 
 Note:
 
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 The subsets must be sorted lexicographically.
 Example :
 If S = [1,2,2], the solution is:
 
 [
 [],
 [1],
 [1,2],
 [1,2,2],
 [2],
 [2, 2]
 ]
 */
import java.util.*;
public class SubSet2{
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
        if(a == null || a.size() == 0)
     return null;
     Collections.sort(a);
        HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < a.size(); i++){
            HashSet<ArrayList<Integer>> temp = new HashSet<ArrayList<Integer>>();
            for(ArrayList<Integer> list : result){
                if(!temp.contains(list))
                    temp.add(new ArrayList<Integer>(list));
            }
            System.out.println(" temp has: " );
            for(ArrayList<Integer> list : temp)
                System.out.println("\t" + list);
            
            for(ArrayList<Integer> list : temp){
                list.add(a.get(i));
            }
            ArrayList<Integer> single = new ArrayList<Integer>();
            single.add(a.get(i));
            temp.add(single);
            
            
            for(ArrayList<Integer> list : temp){
                if(!result.contains(list))
                    result.add(new ArrayList<Integer>(list));
            }
            
        }
        result.add(new ArrayList<Integer>());
        
        ArrayList<ArrayList<Integer>> result2 = new ArrayList<ArrayList<Integer>>();     
         for(ArrayList<Integer> list : result){
                
                    result2.add(new ArrayList<Integer>(list));
            }
         Collections.sort(result2, new Comparator<ArrayList<Integer>>(){
             @Override
             public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
                 for(int i = 0; i < Math.min(a.size(), b.size()); i++){
                     int cmp = Integer.compare(a.get(i), b.get(i));
                     if(cmp != 0)
                         return cmp;
                 }
                 return Integer.compare(a.size(), b.size());
             }
         });
         
        return result2;        
    }
    public static void main(String[] args){
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(2);
        ArrayList<ArrayList<Integer>> result = subsetsWithDup(a);
        for(ArrayList<Integer> list : result)
            System.out.println(list);
    }
}