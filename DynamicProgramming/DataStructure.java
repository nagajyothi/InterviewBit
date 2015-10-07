import java.util.*;
public class DataStructure {
    ArrayList<Integer> a;
    HashMap<Integer,Integer> map;
    //Difference between using hashmap and hashtable
    public DataStructure() {
        a = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    public void add(int t){        
        if(map.get(t) != null) return;
        a.add(t);
        map.put(t, a.size()-1);
    }
    public void remove(int t){
        if(map.get(t) != null) {
            int index = map.get(t);
            map.remove(t);
            
            int size = a.size();
            Integer last = a.get(size - 1);
            Collections.swap(a, index, size - 1);
            a.remove(size - 1);
            map.put(last, index);
        }
    }
    
    
    public int getRandom(){
        Random rand = new Random();
        int index = rand.nextInt(a.size());
        return a.get(index);
    }
    public Integer search(int t){
        return map.get(t);
    }
    public void display(){
        System.out.println(a);
    }
    public static void main(String[] args){
        DataStructure ds = new DataStructure();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.add(40);
        ds.display();
        System.out.println(ds.search(30));
        ds.display();
        ds.remove(20);
        System.out.print("After removing 20");
        ds.display();
        ds.add(50);
        System.out.print("After adding 50");
        ds.display();
        System.out.println(ds.search(50));
        System.out.println("Get random " + ds.getRandom());
    }
}