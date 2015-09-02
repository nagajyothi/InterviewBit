/*
 * Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * 
 Example Histogram
 
 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 
 Example2
 
 The largest rectangle is shown in the shaded area, which has area = 10 unit.
 
 For example,
 Given height = [2,1,5,6,2,3],
 return 10.
 
 http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 */
import java.util.*;
public class Histogram{
    public static int largestRectangleArea(ArrayList<Integer> a) {
        Stack<Integer> stack = new Stack<Integer>();
        int top =0;
        int maxArea =0;
        int areaWithTop;
        int i = 0;
        while(i < a.size()){
            System.out.println("When i = " + i);
            
            if(stack.isEmpty() || a.get(i) >= a.get(stack.peek())){
                System.out.println("\t Pushing to stack " +  i + " which has " +  a.get(i));
                stack.push(i);
                i++;
            }
            else {
                //if(a.get(i) < a.get(stack.peek())){
                top = stack.peek();
                stack.pop();
                areaWithTop = a.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
                System.out.println("\t Area of the Top " +  areaWithTop);
                if(maxArea < areaWithTop) 
                    maxArea = areaWithTop;
            }
        }
        System.out.println("Items in stack");
        for(int j : stack){
            System.out.print(j + " " );
        }
        System.out.println();
        while(!stack.isEmpty()){
            top = stack.peek();
            stack.pop();
            areaWithTop = a.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
            if(maxArea < areaWithTop) 
                    maxArea = areaWithTop;
        }
        return maxArea;
        
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(1);
        a.add(5);
        a.add(6);
        a.add(2);
        a.add(3);
        System.out.println(largestRectangleArea(a));
    }
}
/*
 * C:\Users\ngunti\algs4\InterviewBit\StacksAndQueues>java Histogram
When i = 0
         Pushing to stack 0 which has 2
When i = 1
         Area of the Top 2
When i = 1
         Pushing to stack 1 which has 1
When i = 2
         Pushing to stack 2 which has 5
When i = 3
         Pushing to stack 3 which has 6
When i = 4
         Area of the Top 6
When i = 4
         Area of the Top 10
When i = 4
         Pushing to stack 4 which has 2
When i = 5
         Pushing to stack 5 which has 3
Items in stack
1 4 5
10
 */