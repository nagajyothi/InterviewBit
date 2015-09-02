/*
 * http://www.geeksforgeeks.org/sort-array-wave-form-2/
 */
import java.util.*;
public class Wave{
    public static int[] wave(int[] A){
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
        System.out.println();

        for(int i = 0; i < A.length; i = i+2){
            int temp = A[i];
            A[i] = A[i+1];
            A[i+1] = temp;
        }
        for(int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
        return A;
    }
    public static int[] sortWave(int[] A){
        for(int i = 0; i < A.length; i = i + 2){
            if(i > 0 && A[i] < A[i-1]){
                int temp = A[i];
            A[i] = A[i-1];
            A[i-1] = temp;
            }
            if(i < A.length - 1 && A[i] < A[i+1]){
                int temp = A[i];
            A[i] = A[i+1];
            A[i+1] = temp;
            }
                
        }
        return A;
    }
    
    public static ArrayList<Integer> wave(ArrayList<Integer> A)
    {
        Collections.sort(A);
        for(int i = 0; i < A.size(); i = i + 2){
            if(i > 0 && A.get(i) < A.get(i-1)){
                swap(A,i, i-1);
            }
            if(i < A.size()-1 && A.get(i) < A.get(i+1)){
                swap(A, i, i+1);
            }
        }
        return A;
    }
    
    public static void swap(ArrayList<Integer> A, int a,int b){
        int temp = A.get(a);
        A.set(a,A.get(b));
        A.set(b, temp);
    }
    public static void main(String[] args){
        int[] A =  {3, 6, 5, 10, 7, 20};
        A = sortWave(A);
        for(int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
       
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(3);
        B.add(6);
        B.add(5);
        B.add(10);
        B.add(7);
        B.add(20);
        System.out.println();
        ArrayList<Integer> result = wave(B);
        for(int i = 0; i < result.size(); i++)
            System.out.print(result.get(i) + " ");
    }
}