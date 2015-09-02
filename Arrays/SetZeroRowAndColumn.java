/*
 * 
 */
import java.util.*;
public class SetZeroRowAndColumn{
    public static void setZeroes(ArrayList<ArrayList<Integer>> A) {
        int[] rows = new int[A.size()];
        int[] columns = new int[A.get(0).size()];
        for(int i = 0; i < A.size(); i++){
            for(int j = 0; j < A.get(i).size(); j++){
                if(A.get(i).get(j) == 0){
                    rows[i] = 1;
                    columns[j] = 1;
                }
            }
        }
        
        for(int i = 0; i < A.size(); i++){
            for(int j = 0; j < A.get(i).size(); j++){
                if(rows[i] == 1 ||columns[j] == 1){
                    A.get(i).set(j, 0);
                }
            }
        }
        for(int i = 0; i < A.size(); i++) {
            System.out.print("[");
            for(int j = 0; j < A.get(i).size(); j++){
                System.out.print(A.get(i).get(j));
                if(j != A.get(i).size()-1)
                    System.out.print(", ");
            }
            if(i != A.size()-1)
                System.out.print("] \n ");
            else
                System.out.print("]");
            
        }
        
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A = Spiral.generateMatrix(3);
//        for(int k = 0; k < A.size(); k++){
//            A.add(new ArrayList<Integer>());
//            for(int j = 0; j < A.get(k).size(); j++){
//                A.get(k).add(0);
//            }
//        }
//        System.out.println("printing");
//        for(int i = 0; i < A.size(); i++) {
//            
//            System.out.print("[");
//            for(int j = 0; j < A.get(i).size(); j++){
//                System.out.print(A.get(i).get(j));
//                if(j != A.get(i).size()-1)
//                    System.out.print(", ");
//            }
//            if(i != A.size()-1)
//                System.out.print("], ");
//            else
//                System.out.print("]");
//            
//        }
//        A.get(0).set(0,1);
//        A.get(0).set(1,0);
//        A.get(0).set(2,1);
//        
//        A.get(1).set(0,1);
//        A.get(1).set(1,1);
//        A.get(1).set(2,1);
//        
//        A.get(2).set(0,1);
//        A.get(2).set(1,1);
//        A.get(2).set(2,1);
        
       setZeroes(A);
    }
}