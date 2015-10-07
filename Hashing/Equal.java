/*
 * Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array
 * 
 Note:
 
 1) Return the indices `A1 B1 C1 D1`, so that 
 A[A1] + A[B1] = A[C1] + A[D1]
 A1 < B1, C1 < D1
 A1 < C1, B1 != D1, B1 != C1 
 
 2) If there are more than one solutions, 
 then return the tuple of values which are lexicographical smallest. 
 
 Assume we have two solutions
 S1 : A1 B1 C1 D1 ( these are values of indices int the array )  
 S2 : A2 B2 C2 D2
 
 S1 is lexicographically smaller than S2 iff
 A1 < A2 OR
 A1 = A2 AND B1 < B2 OR
 A1 = A2 AND B1 = B2 AND C1 < C2 OR 
 A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
 Example:
 
 Input: [3, 4, 7, 1, 2, 9, 8]
 Output: [0, 2, 3, 5] (O index)
 */
import java.util.*;
public class Equal{
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        public String toString(){
            String s = "[" + x + ", " + y + "]";
            return s;
        }
    }
    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int n = a.size();
        int sum = 0;
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        for(int i =0; i < n-1; i++){
            for(int j = i + 1; j < n; j++){
                sum = a.get(i) + a.get(j);
                Pair p = new Pair(i, j);
                if(map.containsKey(sum)){
                    ArrayList<Pair> list = map.get(sum);
                    list.add(p);
                    map.remove(sum);
                    
                    map.put(sum,list);
                }
                else {
                    ArrayList<Pair> list = new ArrayList<Pair>();
                    list.add(p);
                    map.put(sum, list);
                }
            }
        }
        
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry)iterator2.next();
            System.out.println("Key is: "+mentry2.getKey() + " & Value is: ");
            System.out.println("\t" +  mentry2.getValue());
            if(mentry2.getValue().size() >= 2){
                int l = mentry2.getValue().size();
                for(int i = 0; i < l -1; i++){
                    for(int j = i + 1; j < l; j++){
                        
                    }
                }
            }
        }
        
        return result;
    }
    public static void main(String[] args){
        ArrayList<Integer> a =  new ArrayList<Integer>();
        a.add(3);
        a.add(4);
        a.add(7);
        a.add(1);
        a.add(2);        
        a.add(9);
        a.add(8);
        System.out.println(a);
        ArrayList<Integer> result = new ArrayList<Integer>();
        Equal e = new Equal();
        result = e.equal(a);
        System.out.println(result);
        
    }
}