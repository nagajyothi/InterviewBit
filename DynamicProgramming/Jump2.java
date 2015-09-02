/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 Each element in the array represents your maximum jump length at that position.
 
 Your goal is to reach the last index in the minimum number of jumps.
 
 Example :
 Given array A = [2,3,1,1,4]
 
 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 
 If it is not possible to reach the end index, return -1.
 */
import java.util.*;
public class Jump2{
    public static int jump(ArrayList<Integer> a) {
        if(a == null || a.size() == 0)
            return 0;
        int steps = 0;
        int max =0;
        int next =0;
        for(int i =0; i < a.size() - 1 && next < a.size() -1; i++){
            max = Math.max(max, i + a.get(i));
            if(i == next){//ready to jump
                if(max == next)
                    return -1;//unreachable
                next = max;
                steps++;
            }
        }
        return steps;
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(3);
        a.add(1);
        a.add(1);
        a.add(4);
        System.out.println(jump(a));
    }
}