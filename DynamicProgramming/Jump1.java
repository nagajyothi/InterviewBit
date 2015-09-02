/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 Each element in the array represents your maximum jump length at that position.
 
 Determine if you are able to reach the last index.
 
 For example:
 A = [2,3,1,1,4], return 1 ( true ).
 
 A = [3,2,1,0,4], return 0 ( false ).
 
 Return 0/1 for this problem
 
 http://n00tc0d3r.blogspot.com/2013/03/jump-game.html
 */
import java.util.*;
public class Jump1{
    public static int canJump(ArrayList<Integer> a) {
        if(a == null || a.size() == 0)
            return 0;
        if(a.size() == 1)
            return 1;
        
        int result = 0;
        int[] canReach = new int[a.size()];
        for(int i = a.size() -2, dist = 1; i >= 0; i--, dist++){
            System.out.println("For i : " +  i + " dist : " + dist);
            if(a.get(i) >= dist){
                System.out.println("\t a.get(i) : " + a.get(i) + " >=  " +dist);
                canReach[i] = 1;
            }
            else{
                int j = 1;
                while(j <= a.get(i) && canReach[i+j] != 1){
                    System.out.println("\t checking in jump range");
                    ++j;
                }
                if(j <= a.get(i))
                    canReach[i] = 1;
            }
        }
        for(int i =0; i < a.size(); i++)
            System.out.print(canReach[i] + " ");
        System.out.println();
        return canReach[0];
    }
    
    public static int canJumpDP(ArrayList<Integer> a) {
        int next = a.size() - 1;
        
        for(int i = a.size() - 2; i >= 0; i--){
            System.out.println("Next : " + next + " i : " + i);
            System.out.println("Check if a.get(i) " + a.get(i) + " >= " + (next - i) );
            if(a.get(i) >= next - i)
                next = i;            
        }
        return next == 0 ? 1 : 0;
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(3);
        a.add(1);
        a.add(1);
        a.add(4);
        System.out.println(canJumpDP(a));
    }
}
