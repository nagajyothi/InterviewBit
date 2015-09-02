/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 Example:
 
 Given n = 3,
 
 You should return the following matrix:
 [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ] 
 */
import java.util.*;
public class Spiral{
    public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        //System.out.println("Entering function");
        int i = 1;
        int top = 0; 
        int bottom = A - 1;
        int left = 0;
        int right = A-1;
        int direction = 0; // 0- right, 1- down, 2 - left, 3- up
        //int aSqaure = Math.pow(A, 2);
        //System.out.println(Math.pow(A, 2));
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int k = 0; k < A; k++){
            result.add(new ArrayList<Integer>());
            //result.get(A-1).add(0);
            for(int j = 0; j < A; j++){
                result.get(k).add(0);
                //System.out.print(result.get(k).get(j) + " ");
            }
        }
        
        while(i <= Math.pow(A, 2) && top <= bottom && left <= right){
            if(direction == 0){
                for(int j = left; j <= right; j++){                    
                    result.get(top).set(j, i++);  
                    //System.out.println(result.get(top).get(j));
                    //i++;
                }
                top++;
            }
            else if(direction == 1){
                for(int j = top; j <= bottom; j++){                    
                    result.get(j).set(right, i++);  
                    //System.out.println(result.get(j).get(right));
                    //i++;
                }
                right--;
            }
            else if(direction == 2){
                for(int j = right; j >= left; j--){                    
                    result.get(bottom).set(j, i++); 
                    //System.out.println(result.get(bottom).get(j));
                    //i++;
                }
                bottom--;
            }
            else if (direction == 3){
                for(int j = bottom; j >= top; j--){                    
                    result.get(j).set(left, i++); 
                    //System.out.println(result.get(j).get(left));
                    //i++;
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return result;
    }
    
    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int top = 0;
        int left = 0;
        int bottom = A.size() -1;
        int right = A.get(top).size() - 1;
        int direction = 0;
        while(top <= bottom && left <= right){
            if(direction == 0){
                for(int i = top; i <= right; i++)
                    result.add(A.get(top).get(i));
                top++;
            }
            else if(direction == 1){
                for(int i = top; i <= bottom; i++)
                    result.add(A.get(i).get(right));
                right--;
            }
            else if(direction == 2){
                for(int i = right; i >= left; i--)
                    result.add(A.get(bottom).get(i));
                bottom--;
            }
            else if(direction == 3){
                for(int i = bottom; i >= top; i--)
                    result.add(A.get(i).get(left));
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return result;
    }
    public static int[][] generateMatrixArray(int A) {
        System.out.println("Entering function");
        int i = 1;
        int top = 0; 
        int bottom = A - 1;
        int left = 0;
        int right = A-1;
        int direction = 0; // 0- right, 1- down, 2 - left, 3- up
        //int aSqaure = Math.pow(A, 2);
        System.out.println(Math.pow(A, 2));
        int[][] result = new int[A][A];
//        for(int k = 0; k < A; k++){
//            result.set(k, new ArrayList<Integer>());
//            for(int j = 0; j < A; j++){
//                result.get(k).set(j, 0);
//                System.out.print(result.get(k).get(j) + " ");
//            }
//        }
        
        while(i <= Math.pow(A, 2) && top <= bottom && left <= right){
            if(direction == 0){
                for(int j = left; j <= right; j++){ 
                    result[top][j] = i++;
                    
                }
                top++;
            }
            else if(direction == 1){
                for(int j = top; j <= bottom; j++){                    
                    result[j][right] = i++;  
                    
                }
                right--;
            }
            else if(direction == 2){
                for(int j = right; j >= left; j--){                    
                    result[bottom][j] = i++; 
                    
                }
                bottom--;
            }
            else if (direction == 3){
                for(int j = bottom; j >= top; j--){                    
                    result[j][left] = i++; 
                    
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return result;
    }
    public static void main(String[] args){
        int A = Integer.parseInt(args[0]);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int[][] result2 = generateMatrixArray(A);
        for(int i = 0; i < A; i++) {
            System.out.print("[");
            for(int j = 0; j < A; j++){
                System.out.print(result2[i][j]);
                if(j != A-1)
                    System.out.print(", ");
            }
            if(i != A-1)
                System.out.print("], ");
            else
                System.out.print("]");
            
        }
        System.out.print("]");
        System.out.println();
        result = generateMatrix(A);
        System.out.print("[");
        for(int i = 0; i < result.size(); i++) {
            System.out.print("[");
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j));
                if(j != result.get(i).size()-1)
                    System.out.print(", ");
            }
            if(i != result.size()-1)
                System.out.print("], ");
            else
                System.out.print("]");
            
        }
        System.out.print("]");
        System.out.println();
        ArrayList<Integer> spiral = new ArrayList<Integer>();
        spiral = spiralOrder(result);
        System.out.print("[");
        for(int i = 0; i < spiral.size(); i++){
            System.out.print(spiral.get(i));
            if(i != spiral.size() -1)
                System.out.print(", ");
        }
        System.out.println("]");
        
    }
}