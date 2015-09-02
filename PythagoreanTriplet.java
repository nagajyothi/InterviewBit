/*
 * Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
 * 
 Example:
 
 Input: arr[] = {3, 1, 4, 6, 5}
 Output: True
 There is a Pythagorean triplet (3, 4, 5).
 
 Input: arr[] = {10, 4, 6, 12, 5}
 Output: False
 There is no Pythagorean triplet.
 */
import java.util.*;
public class PythagoreanTriplet{
    public static boolean bruteForce(int[] A){
        //ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < A.length; i++){
            for(int j = i+1; j < A.length; j++){
                for(int k = j + 1; k < A.length; k++){
                    if(Math.pow(A[i], 2) + Math.pow(A[j], 2) == Math.pow(A[k], 2) ||
                       Math.pow(A[j], 2) + Math.pow(A[k], 2) == Math.pow(A[i], 2) ||
                       Math.pow(A[i], 2) + Math.pow(A[k], 2) == Math.pow(A[j], 2)){
                        System.out.print("[" + A[i] + " ," + A[j] + " ," + A[k] +"]");
                        
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean sortSolution(int[] A){
        for(int i = 0; i < A.length; i++){
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        for(int i = A.length-1; i >= 2; i--){
            int l = 0;
            int r = i-1;
            while(l < r){
                if(A[l] + A[r] == A[i]){
                    System.out.print("[" + (int)Math.sqrt(A[l]) + " ," + (int)Math.sqrt(A[r]) + " ," + (int)Math.sqrt(A[i]) +"]");
                    return true;
                }
                if(A[l] + A[r] < A[i]){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] A = {3, 1, 4, 6, 5};
        System.out.print("There is ");
        if(!sortSolution(A)){
            System.out.print("no ");            
        }
        System.out.println(" Pythogorean triplet ");;
    }
}