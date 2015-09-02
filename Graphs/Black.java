/*
 * Given N * M field of O's and X's, where O=white, X=black
 Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)
 
 Example:
 
 OOOXOOO
 OOXXOXO
 OXOOOXO
 
 answer is 3 shapes are  :
 (i)    X
 X X
 (ii)
 X
 (iii)
 X
 X
 Note that we are looking for connected shapes here.
 
 For example,
 
 XXX
 XXX
 XXX
 is just one single connected black shape.
 */
import java.util.*;
public class Black{
    public static int black(ArrayList<String> a) {
        int count = 0;
        if(a == null || a.size() == 0)
            return count;
        for(int i = 0; i < a.size(); i++){
            for(int j = 0;  j < a.get(i).length(); j++){
                if((j+1) < a.get(i).length()){
                    if(a.get(i).charAt(j) == 'X'){
                        if(a.get(i).charAt(j) == a.get(i).charAt(j + 1))
                            count++;
//                        if((i-1) >= 0){
//                            if(a.get(i-1).charAt(j) == a.get(i).charAt(j))
//                                count++;
//                        }
                        if((i+1) < a.size()){
                            if(a.get(i + 1).charAt(j) == a.get(i).charAt(j))
                                count++;
                        }
                        
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        
        ArrayList<String> a = new ArrayList<String>();
        a.add("OOOXOOO");
        a.add("OOXXOXO");
        a.add("OXOOOX0");
        System.out.println(black(a));
    }
}