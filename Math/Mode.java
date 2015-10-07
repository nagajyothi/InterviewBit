/*
 * 
 */
import java.util.*;
public class Mode {
    //static HashMap<Integer, Integer> map;
    public static ArrayList<Integer> getMode(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i : A) {
            if(map.containsKey(i))
                map.put(i, map.get(i) +1);
            else
                map.put(i, 1);
        }
        
        for(ArrayList<Integer> update : B){
            int index = update.get(0);
            int num = update.get(1);
            
            int toUpdate = A.get(index - 1);
            
            if(map.get(toUpdate) != null)
                map.put(toUpdate, map.get(toUpdate) - 1);
            A.set(index - 1, num);
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
            
            int modeindex = 0;
            int mode = -1;
            for(Map.Entry<Integer,Integer> pair : map.entrySet()) {
                if(modeindex == (int)pair.getValue() && mode > (int)pair.getKey())
                    mode = (int)pair.getKey();
                if(modeindex < (int)pair.getValue()){
                    modeindex = (int)pair.getValue();
                    mode = (int)pair.getKey();
                }
                System.out.println(pair.getKey() + " = " + pair.getValue());
            }
            
            // System.out.println("A : " + A);
            result.add(mode);
        }
        return result;
    }
    
    public static int mode(ArrayList<Integer> A, HashMap<Integer, Integer> map) {
        //HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>(map);
        int modeindex = 0;
        int mode = -1;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(modeindex == (int)pair.getValue() && mode > (int)pair.getKey())
                mode = (int)pair.getKey();
            if(modeindex < (int)pair.getValue()){
                modeindex = (int)pair.getValue();
                mode = (int)pair.getKey();
            }
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
        System.out.println();
        return mode;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(2);
        A.add(2);
        A.add(2);
        A.add(3);
        A.add(3);
        
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        B.add(new ArrayList<Integer>(list));
        list.clear();
        
        list.add(5);
        list.add(4);
        B.add(new ArrayList<Integer>(list));
        list.clear();
        
        list.add(2);
        list.add(4);
        B.add(new ArrayList<Integer>(list));
        list.clear();
        
        System.out.println("A: " + A);
        System.out.println("B: " + B);
        System.out.println(getMode(A, B));
    }
}