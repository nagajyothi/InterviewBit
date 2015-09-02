/*
 * There are N Mice and N holes are placed in a straight line. 
Each hole can accomodate only 1 mouse. 
A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x ? 1. Any of these moves consumes 1 minute.
Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.

Example:

positions of mice are:
4 -4 2
positions of holes are:
4 0 5

Assign mouse at position x=4 to hole at position x=4 : Time taken is 0 minutes 
Assign mouse at position x=-4 to hole at position x=0 : Time taken is 4 minutes 
Assign mouse at position x=2 to hole at position x=5 : Time taken is 3 minutes 
After 4 minutes all of the mice are in the holes.

Since, there is no combination possible where the last mouse's time is less than 4, 
answer = 4.
Input:

A :  list of positions of mice
B :  list of positions of holes
Output:

single integer value
NOTE: The final answer will fit in a 32 bit signed integer.
 */
import java.util.*;
public class Mice{
    static class Mices implements Comparator<Mices>{
        int micePosition;
        int holePosition;
        public Mices(){}
        public Mices(int micePosition, int holePosition){
            this.micePosition = micePosition;
            this.holePosition = holePosition;
        }
        public int compare(Mices m1, Mices m2){
            return m1.holePosition - m2.holePosition;
        }
        
    }
    public static int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
        int minTime = Integer.MIN_VALUE;
        if(a == null || b == null || a.size() != b.size())
        return -1;
        int n = a.size();
        Mices[] mice = new Mices[n]; 
        int i =0;
        for(i = 0; i < n; i++)
            mice[i] = new Mices(a.get(i), b.get(i));
        Arrays.sort(mice, new Mices());
        
        i = 0;
        for(int j = 1; j < n; j++){
            if(mice[j].micePosition >= mice[i].holePosition){
                System.out.println(Math.abs(Math.abs(mice[j].micePosition) - Math.abs(mice[j].holePosition))); 
                                   
                i = j;
            }
        }
        
        return 0;
        
    }
    
    public static int miceEfficient(ArrayList<Integer> a, ArrayList<Integer> b) {
        if(a == null || b == null || a.size() != b.size())
            return -1;
        int maxTime = Integer.MIN_VALUE;
        System.out.println("Before Sorting a "+a);
        Collections.sort(a);
        System.out.println("After Sorting a " +a);
         System.out.println("Before Sorting a " + b);
        Collections.sort(b);
        System.out.println("After Sorting b " + b);        
        for(int i =0; i < a.size(); i++){
            maxTime = Math.max(Math.abs(b.get(i) - a.get(i)),maxTime);
        }
        return maxTime;
    }
    
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(-49);
        a.add(58);
        a.add(72);
        a.add(-78);
        a.add(9);
        a.add(65);
        a.add(-42);
        a.add(-3);
        
        
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(30);
        b.add(-13);
        b.add(-70);
        b.add(58);
        b.add(-34);
        b.add(79);
        b.add(-36);
        b.add(27);
        

        System.out.println(miceEfficient(a,b));
    }
}
/*class Mice implements Comparator<Mice>{
        int micePosition;
        int holePosition;
        public Mice(){}
        public Mice(micePosition, holePosition){
            this.micePosition = micePosition;
            this.holePosition = holePosition;
        }
        public int compare(Mice m1, Mice m2){
            return m1.micePosition - m2.micePosition;
        }
        
    }
    public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
        int minTime = Integer.MIN_VALUE;
        if(a == null || b == null || a.size() != b.size())
        return -1;
        int n = a.size();
        Mice[] mice = new Mice[n]; 
        for(int i = 0; i < n; i++)
            mice[i] = new Mice(a.get(i), b.get(i));
        Arrays.sort(mice, new Mice());
        
        for(int i = 0; i < n; i++){
            int change = Math.abs(a.get(i) - b.get(i));
            if(change > minTime)
            minTime = change;
        }
        return minTime;
        
        
        int[] timetaken = new int[n];
        
        for(int i = 0; i < n; i++){
            
            timetaken[i] = Math.abs(Math.abs(a.get(i)) - Math.abs(b.get(i)));            
            System.out.println(timetaken[i]);
        }
        Arrays.sort(timetaken);
                System.out.println();
        return timetaken[n-1];
        */