/*
 * Find Union and Intersection of two unsorted arrays
 * Given two unsorted arrays that represent two sets (elements in every array are distinct), find union and intersection of two arrays.
 * 
 For example, if the input arrays are:
 arr1[] = {7, 1, 5, 2, 3, 6}
 arr2[] = {3, 8, 6, 20, 7}
 Then your program should print Union as {1, 2, 3, 5, 6, 7, 8, 20} and Intersection as {3, 6}. Note that the elements of union and intersection can be printed in any order.
 */
import java.util.*;
public class UnionAndIntersection{
    public static int[] bruteForceUnion(int[] A, int[] B){
        int[] union = new int[A.length+B.length];
        for(int i = 0; i < A.length; i++)
            union[i] = A[i];
        int k = A.length;
        for(int i = 0; i < B.length; i++){
            int flag = 0;
            for(int j = 0; j < A.length; j++){
                if(B[i] == union[j])
                    flag = 1;
            }
            if(flag == 0){
                union[k] = B[i];
                k++;
            }
            
        }
        return union;
    }
    public static int[] bruteForceIntersection(int[] A, int[] B){
        int[] intersection = new int[A.length+B.length];
        
        int k = 0;
        for(int i = 0; i < B.length; i++){
            int flag = 0;
            for(int j = 0; j < A.length; j++){
                if(B[i] == A[j])
                    flag = 1;
            }
            if(flag == 1){
                intersection[k] = B[i];
                k++;
            }
            
        }
        return intersection;
    }
    
    public static ArrayList<Integer> union(int[] A, int[] B){
        ArrayList<Integer> U = new ArrayList<Integer>();
        int[] smaller;
        int[] larger;
        if(A.length < B.length){            
            smaller = A;
            larger = B;            
        }
        else{            
            smaller = B;
            larger = A;
        }
        Arrays.sort(smaller);
        for(int i = 0; i < smaller.length; i++)
            U.add(smaller[i]);
        for(int i = 0; i < larger.length; i++){
            if(BinarySearch.rank(larger[i], smaller) == -1)
                U.add(larger[i]);
        }
        return U;
    }
    public static ArrayList<Integer> intersection(int[] A, int[] B){
        ArrayList<Integer> I = new ArrayList<Integer>();
        int[] smaller;
        int[] larger;
        if(A.length <= B.length){            
            smaller = A;
            larger = B;            
        }
        else{            
            smaller = B;
            larger = A;
        }
        Arrays.sort(smaller);
//        for(int i = 0; i < smaller.length; i++)
//            U.add(A[i]);
        for(int i = 0; i < larger.length; i++){
            if(BinarySearch.rank(larger[i], smaller) != -1)
                I.add(larger[i]);
        }
        return I;
    }
    public static void main(String[] args){
        int[] A = {7, 1, 5, 2, 3, 6};
        int[] B = {3, 8, 6, 20, 7};
        int[] union = bruteForceUnion(A, B);
        for(int i = 0; i < union.length; i++){
            System.out.print(union[i] + " ");
        }
        System.out.println();
        
        int[] intersection = bruteForceIntersection(A, B);
        for(int i = 0; i < intersection.length; i++){
            System.out.print(intersection[i] + " ");
        }
        System.out.println();
        
        ArrayList<Integer> U = union(A, B);
        for(int i = 0; i < U.size(); i++){
            System.out.print(U.get(i) + " ");
        }
        System.out.println();
        ArrayList<Integer> I = intersection(A, B);
        for(int i = 0; i < I.size(); i++){
            System.out.print(I.get(i) + " ");
        }
        System.out.println();
    }
}