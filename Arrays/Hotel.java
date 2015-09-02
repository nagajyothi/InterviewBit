/*
 * A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .

Input:


First list for arrival time of booking.
Second list for departure time of booking.
Third is K which denotes count of rooms.

Output:

A boolean which tells whether its possible to make a booking. 
Return 0/1 for C programs.
O -> No there are not enough rooms for N booking.
1 -> Yes there are enough rooms for N booking.
Example :

Input : 
        Arrivals :   [1 3 5]
        Departures : [2 6 8]
        K : 1

Return : False / 0 

At day = 5, there are 2 guests in the hotel. But I have only one room. 
 */
import java.util.*;
public class Hotel{
    class Interval implements Comparable<Interval>{
        int a;
        int d;
        public Interval(int a, int d){
            this.a = a;
            this.d = d;            
        }
        
        public int compareTo(Interval that){
            return this.a - that.a;
        }
        
    }
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        if(arrive == null || arrive.size() == 0||
           depart == null || depart.size() == 0 ||
           depart.size() != arrive.size() || K < 1)
            return false;
        Interval[] intervals = new Interval[arrive.size()];
        for(int i = 0; i < arrive.size(); i++){
            intervals[i] = new Interval(arrive.get(i), depart.get(i));            
        }
        
        for(int i = 0; i < arrive.size(); i++){
            System.out.print(intervals[i].a + " ");
        }
        System.out.println();
        for(int i = 0; i < arrive.size(); i++){
            System.out.print(intervals[i].d + " ");
        }
        System.out.println();
        
                
        Arrays.sort(intervals);
        System.out.println("After sorting");
        for(int i = 0; i < arrive.size(); i++){
            System.out.print(intervals[i].a + " ");
        }
        System.out.println();
        for(int i = 0; i < arrive.size(); i++){
            System.out.print(intervals[i].d + " ");
        }
        System.out.println();
        
        int rooms = K;
        rooms--;
        for(int i = 1; i < intervals.length; i++){
            if(rooms > 0){
                rooms--;
                continue;
            }
            else if(intervals[i].a < intervals[i-1].d){
                return false;
            }
            
        }
        
        
        return true;
    }
    
    public boolean hotelEfficient(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
         if(arrive == null || arrive.size() == 0||
           depart == null || depart.size() == 0 ||
           depart.size() != arrive.size() || K < 1)
            return false;
         
         Collections.sort(arrive);
         Collections.sort(depart);
         System.out.println("Arrive : " + arrive);
         System.out.println("Depart : " + depart);
         int aIndex = 0;
         int dIndex = 0;
         
         int currentRooms = 0;
         int max =0;
         while(aIndex < arrive.size()){
             if(arrive.get(aIndex) < depart.get(dIndex)) {
                 aIndex++;
                 currentRooms++;
                 max = Math.max(max, currentRooms);
             }
             else {
                 dIndex++;
                 currentRooms--;
             }
         }
         System.out.println("max : " + max);
         return max <= K;
    }
    public static void main(String[] args){
        
        ArrayList<Integer> arrive = new ArrayList<Integer>();
        ArrayList<Integer> depart = new ArrayList<Integer>();
        arrive.add(1);
        arrive.add(2);
        arrive.add(3);
        arrive.add(4);
        
        depart.add(10);
        depart.add(2);
        depart.add(6);
        depart.add(14);
        Hotel h = new Hotel();
        
        if(!h.hotelEfficient(arrive,depart, 4))
        System.out.print("Cannot be ");
        System.out.println("Accomodated");
    }
}