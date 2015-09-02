import java.util.*;
public class Arrange{
    public static void arrange(int[] A){
        int[] K = new int[A.length];
        int N = A.length;
        for(int i = 0; i < N; i++){
            K[i] = A[i];
        }
        for(int i = 0; i < N; i++){
            A[i] = K[K[i]];
        }
        for(int i = 0; i < N; i++){
            System.out.print(A[i] + " ");            
        }
        System.out.println();
    }
    public static void arrange(ArrayList<Integer> A) {
        ArrayList<Integer> K = new ArrayList<Integer>();
        int N = A.size();
        for(int i = 0; i < N; i++){
            K.add(A.get(i));
        }
       
        for(int i = 0; i < N; i++){
            A.set(i,K.get(K.get(i)));
        }
        for(int i = 0; i < N; i++){
            System.out.print(A.get(i) + " ");            
        }
    }
    
    public static void bestArrange(ArrayList<Integer> A) {
        int N = A.size();
        for(int i = 0; i < N; i++){
            A.set(i, (A.get(i) + (A.get(A.get(i))%N) * N));
        }
        for(int i = 0; i < N; i++)
            A.set(i, A.get(i)/N);
        for(int i = 0; i < N; i++){
            System.out.print(A.get(i) + " ");            
        }
    }
    
    public static void main(String[] args){
//        int[] A = {1,2,4,3,0,5};
//        for(int i = 0; i < A.length; i++){
//            System.out.print(A[i] + " ");            
//        }
//        System.out.println();
//        arrange(A);
        
        ArrayList<Integer> K = new ArrayList<Integer>();
        K.add(1);
        K.add(2);
        K.add(4);
        K.add(3);
        K.add(0);
        K.add(5);
        for(int i = 0; i < K.size(); i++){
            System.out.print(K.get(i) + " ");            
        }
        System.out.println(); 
        bestArrange(K);
    }
}