/*
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 Note:
 
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 Also, the subsets should be sorted in ascending ( lexicographic ) order.
 Example :
 
 If S = [1,2,3], a solution is:
 
 [
 [],
 [1],
 [1, 2],
 [1, 2, 3],
 [1, 3],
 [2],
 [2, 3],
 [3],
 ]
 */
import java.util.*;
public class SubSet{
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        if(a == null)
            return null;
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();        
        
        for(int i = 0; i < a.size(); i++){            
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
            
            for(ArrayList<Integer> list : result){
                temp.add(new ArrayList<Integer>(list));
            }
//            System.out.println(" temp has: " );
//            for(ArrayList<Integer> list : temp)
//                System.out.println("\t" + list);
            
            for(ArrayList<Integer> list : temp){
                list.add(a.get(i));
            }
            ArrayList<Integer> single = new ArrayList<Integer>();
            single.add(a.get(i));
            temp.add(single);
           
            
            result.addAll(temp);
        }
        result.add(0, new ArrayList<Integer>());
        //Collections.sort(result);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int an = a.size();
                int bn = b.size();
                for (int i = 0; i < Math.min(an, bn); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });

        return result;
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        ArrayList<ArrayList<Integer>> result = subsets(a);
        for(ArrayList<Integer> list : result)
            System.out.println(list);
    }
}