/*
 * Given an unsorted array of n integers which can contain integers from 1 to n.
 * Some elements can be repeated multiple times and some other elements can be absent from the array.
 * Count frequency of all elements that are present and print the missing elements.
 */
public class CountFrequencies{
    //O(N) space
    public static int[] bruteForceCount(int[] A){
        int[] B = new int[A.length];
        for(int i = 0; i < A.length; i++){
            B[A[i]-1]++;
        }
        return B;            
    }
    
    public static int[] bestCount(int[] A){
        int i =0;
        while(i < A.length){
            if(A[i] <= 0){
                i++;
                continue;
            }
            
            int elementIndex = A[i] - 1;
            
            if(A[elementIndex] > 0){
                A[i] = A[elementIndex];
                A[elementIndex] = -1;
            }
            else{
                A[elementIndex]--;
                A[i] = 0;                
                i++;
            }
        }
        for(int j = 0; j < A.length; j++)
            A[j] = Math.abs(A[j]);
        return A;
    }
    
    public static void main(String[] args){
        int[] A = {2,3,3,2,5};
        A = bestCount(A);
        for(int i = 0; i < A.length; i++){
            System.out.printf("%d -> %d \n",i + 1, A[i]);
        }
    }
}