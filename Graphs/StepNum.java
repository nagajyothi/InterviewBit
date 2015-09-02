/*
 * Given N and M find all stepping numbers in range N to M
 * 
 The stepping number:
 
 A number is called as a stepping number if the adjacent digits have a difference of 1.
 e.g 123 is stepping number, but 358 is not a stepping number
 
 Example:
 
 N = 10, M = 20
 all stepping numbers are 10 , 12 
 Return the numbers in sorted order.
 */
import java.util.*;
public class StepNum {
    public static ArrayList<Integer> stepnum(int a, int b) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int i = 0;
        int temp =0;
        if(a == 0)
        result.add(a);
        for(int j = 1; j < 10; j++){
            queue.offer(j);
        }
        temp = queue.poll();
        while(temp <= b){
            
            if(a <= temp && temp <= b){
                result.add(temp);
            }
            
            int lastDigit = temp % 10;
            if(lastDigit == 0)
                queue.offer(temp * 10 + 1);
            else if(lastDigit == 9)
                queue.offer(temp * 10 + 8);
            else{
                queue.offer(temp * 10 + lastDigit - 1);
                queue.offer(temp * 10 + lastDigit + 1);
            }
            System.out.println(" Queue: " + queue);

            temp = queue.poll();
        }
        return result;
    }
    
    
//    public static ArrayList<Integer> stepnum(int a, int b) {
//        ArrayList<Integer> result = new ArrayList<Integer>();
//        dfs(a, b, 0, result);
//        Collections.sort(result);
//        return result;
//    }
//    
//    public static void dfs(int a, int b, int num, ArrayList<Integer> result){
//        System.out.println("num : " + num);
//        if(num > b)
//            return;
//        if(a <= num && num <= b)
//            result.add(num);
//        
//        int lastDigit = num % 10;
//        System.out.println("lastDigit : " + lastDigit);
//        
//        if(lastDigit == 0)
//            dfs(a, b, num * 10 + 1, result);
//        else if(lastDigit == 9)
//            dfs(a, b, num * 10 + 8, result);
//        else{
//            dfs(a, b, num * 10 + lastDigit - 1, result);
//            dfs(a, b, num * 10 + lastDigit + 1, result);
//        }
//    }
    
    
    public static ArrayList<Integer> steppingNo(int s, int e) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int i = 0;
        while (s <= e) {
            if (isStepping(s)) {
                res.add(s);
            }
            s++;
        }
        return res;
    }
    
    private static boolean isStepping(int i) {
        if (i >= 0 && i <= 9) return true;
        while (i >= 10) {
            if (Math.abs(i % 10 - (i / 10) % 10) != 1) { // compare last two digits
                return false;
            }
            i = i / 10;
        }
        return true;
    }
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        ArrayList<Integer> result = stepnum(a, b);
        System.out.println(result);
    }
}