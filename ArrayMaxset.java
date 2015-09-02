import java.util.ArrayList;
public class ArrayMaxset{
    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> B =new ArrayList<Integer>();
        int max = 0;
        int total = 0;
        for(int i = 0; i < A.size(); i++){
            total += A.get(i);
            if(total > max) {
                max = total;
                B.add(A.get(i));
            }
            
        }
        return B;
    }
    
    public static ArrayList<Integer> maxsetSolution(ArrayList<Integer> A) {
        ArrayList<Integer> B =new ArrayList<Integer>();
        int maxSum = A.get(0);
        int currSum = A.get(0);
        B.add(A.get(0));
        for(int i = 1; i<A.size(); i++){
            if(A.get(i) >= 0){
                currSum = currSum + A.get(i);
                if(maxSum <= currSum){
                    maxSum = currSum;
                    B.add(A.get(i));
                }
            }
            else{
                currSum = 0;
                //B.clear();
            }
        }
        return B;
    }
    public static int maxSubArray(ArrayList<Integer> A) {
        int maxi = A.get(0);
        int i;
        int cur = A.get(0);
        for(i = 1; i < A.size(); i++){
            cur = Math.max(A.get(i), cur+A.get(i));
            maxi = Math.max(maxi, cur);
        }
        
        return maxi;
    }
    
    public static void main(String[] args){
        ArrayList<Integer> A =new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(-7);
        A.add(2);
        A.add(3);

//        System.out.println();
//        System.out.println(maxSubArray(A));
                
        ArrayList<Integer> B = maxsetSolution(A);
        for (int i = 0; i < B.size(); i++) {
            System.out.print(B.get(i) + " ");
        }
    }
}