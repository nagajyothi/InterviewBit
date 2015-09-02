/*
 * 
 */
import java.util.*;
public class Order{
    static class Person implements Comparator<Person>{
        int height;
        int infront;
        public Person(){}
        public Person(int height, int infront){
            this.height = height;
            this.infront = infront;
        }
        public int compare(Person p1, Person p2){
            return p1.height - p2.height;
        }
    }
    
    
    public static ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(heights == null || infronts == null || heights.size() != infronts.size())
            return result;
        
        int n = heights.size();
        Person[] persons = new Person[n];
        for(int i = 0; i< n; i++)
            persons[i] = new Person(heights.get(i), infronts.get(i));
        
        Arrays.sort(persons, new Person());
        System.out.println("Persons after sorting");
        for(Person p : persons)
            System.out.println(p.height + " " + p.infront);
            
        Person[] temp = new Person[n];
        for(Person p : persons){
            int count = 0; 
            System.out.println("For person h = " + p.height + " and infront = " + p.infront);
            for(int i = 0; i < n; i++){
                System.out.println("\t at i = " +  i);
                if(count == p.infront){                    
                    while(temp[i] != null && i < n-1)
                        i++;
                    System.out.println("\t Putting " + p.height + " in temp at position " + i);
                    temp[i] = p;
                    break;
                }
                if(temp[i] == null){
                    
                    count++;
                    System.out.println("\t Incremented count to " + count);
                }
                    
            }            
        }
        for(int i = 0; i < n; i++)
            result.add(temp[i].height);
        return result;
    }
    public static void main(String[] args){
        ArrayList<Integer> heights = new ArrayList<Integer>();
        heights.add(5);
        heights.add(3);
        heights.add(2);
        heights.add(6);
        heights.add(1);
        heights.add(4);
        ArrayList<Integer> infronts = new ArrayList<Integer>();
        infronts.add(0);
        infronts.add(1);
        infronts.add(2);
        infronts.add(0);
        infronts.add(3);
        infronts.add(2);
        
        ArrayList<Integer> result = order(heights, infronts);
        System.out.println(result);
    }
}