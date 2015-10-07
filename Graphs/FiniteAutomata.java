/*
 * 
 */
import java.util.*;
public class FiniteAutomata {
    ArrayList<String> result;
    
    public void printAllKLength(char[] set, int n){
        result = new ArrayList<String>();
        printAllKLengthRec(set, "", set.length, n);
    }
    public void printAllKLengthRec(char[] set, String prefix, int length, int n){
        if(n == 0) {
            result.add(prefix);
            return;
        }
        for(int i = 0; i < length; i++) {
            String newPrefix = prefix + set[i];
            printAllKLengthRec(set, newPrefix, length, n-1);
        }
    }
    public int automata(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, int D, int N) {
        int count = 0;
        String a = "01";
        printAllKLength(a.toCharArray(), N);
        
        for(String s : result) {
            char[] arr = s.toCharArray();
            if(arr[0] == A.get(D)
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == )
            }
        }
        
        
        return count;
    }
}