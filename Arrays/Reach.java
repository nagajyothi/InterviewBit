/*
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 * 
 (x,y) to 
 (x+1, y), 
 (x - 1, y), 
 (x, y+1), 
 (x, y-1), 
 (x-1, y-1), 
 (x+1,y+1), 
 (x-1,y+1), 
 (x+1,y-1) 
 You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.
 
 Example :
 
 Input : [(0, 0), (1, 1), (1, 2)]
 Output : 2
 It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 
 This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.
 */
import java.util.*;
public class Reach{
    public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        if(X == null || X.size() == 0||
           Y == null || Y.size() == 0||
           X.size() != Y.size())
            return 0;
        int result = 0;
        for(int i = 0; i < X.size()-1; i++){
            if(Math.abs(X.get(i+1)- X.get(i)) == 1 &&
               Math.abs(Y.get(i+1) - Y.get(i)) == 1){
                result++;
                continue;
            }
            if(X.get(i+1) == X.get(i)){
                if(Math.abs(Y.get(i+1) - Y.get(i)) == 1){
                    result++;
                    continue;
                }
            }
            
            if(Y.get(i+1) == Y.get(i)){
                if(Math.abs(X.get(i+1) - X.get(i)) == 1){
                    result++;
                    continue;
                }
            }
            
        }
        return result;
    }
     public static int coverPointsEfficient(ArrayList<Integer> X, ArrayList<Integer> Y) {
      
        if(X == null || X.size() == 0||
           Y == null || Y.size() == 0||
           X.size() != Y.size())
            return 0;
        int result = 0;
        for(int i = 0; i < X.size()-1; i++){
            int x = Math.abs(X.get(i) - X.get(i + 1));
            int y = Math.abs(Y.get(i) - Y.get(i + 1));
            result += Math.max(x, y);
            
        }
        return result;
    
    }
    public static void main(String[] args){
        ArrayList<Integer> X = new ArrayList<Integer>();
        ArrayList<Integer> Y = new ArrayList<Integer>();
        
        X.add(-7);
        X.add(1);
        //X.add(1);
        
        Y.add(-13);
        //Y.add(1);
        Y.add(-5);
        System.out.println(coverPointsEfficient(X, Y));
        
    }
}