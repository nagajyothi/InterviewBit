import java.util.ArrayList;
public class Array2DPrimer1{
    public ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());
            
            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }
            
            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }
    
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> A =new ArrayList<ArrayList<Integer>>();
        int k = 1;
        for(int i = 0; i < 3; i++){
            A.add(new ArrayList<Integer>());
            for(int j = 0; j < 4; j++){
                A.get(i).add(k);
                k++;
            }
        }
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                System.out.print(A.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
        Array2DPrimer1 p = new Array2DPrimer1();
        ArrayList<ArrayList<Integer>> B = p.performOps(A);
        for (int i = 0; i < B.size(); i++) {
            for (int j = 0; j < B.get(i).size(); j++) {
                System.out.print(B.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}