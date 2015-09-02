/*
 * Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.
 * 
 Bonus if you can solve it in O(n^2) or less.
 
 Example :
 
 A : [  1 1 1
 0 1 1
 1 0 0 
 ]
 
 Output : 4 
 
 As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)
 
 */
import java.util.*;
public class MaxRectangle{
    public static int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
        int area = 0;
        int m = a.size();
        int n = a.get(0).size();
        int i, j;
        int[][] s = new int[m][n];
        
//        for(i = 0; i < m; i++)
//            s[i][0] = a.get(i).get(0);
//        
//        for(j = 0; j < n; j++)
//            s[0][j] = a.get(0).get(j);
        
        for(i = 0; i < m; i++){
            for(j = 0; j < n; j++){
                if(a.get(i).get(j) == 1)
                    s[i][j] = (i == 0) ? 1 : s[i-1][j] + 1;
                else
                    s[i][j] = 0;
            }
        }
        System.out.println("Height matrix has : " );
        for(i = 0; i < m; i++){
            for(j = 0; j < n; j++){
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
        
        for(i =0; i < m; i++)
            area = Math.max(area, largestRectangleArea(s[i]));
        return area;
    }
    
    public static int largestRectangleArea(int[] heights){
        if(heights == null || heights.length == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        
        int i = 0;
        
        while(i < heights.length){
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]){
                stack.push(i);
                i++;
            }
            else{
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
        }
        
        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() -1;
            max = Math.max(max, height * width);
        }
        return max;
    }
    public static int min(int a, int b, int c){
        int m = Math.min(a, b);
        m = Math.min(m, c);
        return m;
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(1);
        temp.add(1);
        a.add(new ArrayList<Integer>(temp));
        temp.clear();
        
        temp.add(0);
        temp.add(1);
        temp.add(1);
        a.add(new ArrayList<Integer>(temp));
        temp.clear();
        
        temp.add(1);
        temp.add(0);
        temp.add(0);
        a.add(new ArrayList<Integer>(temp));
        temp.clear();
        
        for(ArrayList<Integer> list : a)
            System.out.println(list);
        System.out.println("Area : " + maximalRectangle(a));
    }
}
/*
 * int maxOfS = s[0][0];
 int maxI = 0;
 int maxJ = 0;
 for(i = 1; i < m; i++){
 for(j = 1; j < n; j++){
 if(maxOfS < s[i][j]){
 maxOfS = s[i][j];
 maxI = i;
 maxJ = j;
 }                
 }
 }
 
 for(i = 0; i < m; i++){
 for(j = 0; j < n; j++){
 System.out.print(s[i][j] + " ");
 }
 System.out.println();
 }
 System.out.printf("maxofS = %d \n maxI = %d \n maxJ = %d \n", maxOfS, maxI, maxJ);
 for(i = maxI; i > maxI - maxOfS; i--)
 {
 for(j = maxJ; j > maxJ - maxOfS; j--)
 {
 System.out.printf("%d ", a.get(i).get(j));
 }  
 System.out.println();
 }  
 
 area = maxOfS  * maxOfS;        
 */