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
//    public static int black(ArrayList<String> a) {
//        int count = 0;
//        if(a == null || a.size() == 0)
//            return count;
//        for(int i = 0; i < a.size(); i++){
//            for(int j = 0;  j < a.get(i).length(); j++){
//                if((j+1) < a.get(i).length()){
//                    if(a.get(i).charAt(j) == 'X'){
//                        //Adjacent columns are eqaul X
//                        if(a.get(i).charAt(j) == a.get(i).charAt(j + 1))
//                            count++;
//                        
//                        
//                        
//                        if((i+1) < a.size()){
//                            //bottom are equal X
//                            if(a.get(i + 1).charAt(j) == a.get(i).charAt(j))
//                                count++;
//                        }
//                        
//                    }
//                }
//            }
//        }
//        return count;
//    }
    boolean[][] marked;
     int count = 0;
     int di[] = new int[]{1, -1, 0, 0};
     int dj[] = new int[]{0, 0, 1, -1};
     ArrayList<String> a;
    public int blackSolutionBFS(ArrayList<String> a) {
       
        if(a == null || a.size() == 0)
            return count;
        
        int m = a.size();
        int n = a.get(0).length();
        marked = new boolean[a.size()][a.get(0).length()];
        this.a = a;
        for(int i = 0; i < a.size(); i++){
            for(int j = 0;  j < a.get(i).length(); j++){
                if(marked[i][j] == false && a.get(i).charAt(j) == 'X'){
                   dfs(i, j, m, n);
                   count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(int i, int j, int m, int n){
        marked[i][j] = true;
        for(int k = 0; k < 4; k++) {
            int ii = i + di[k];
            int jj = j + dj[k];
            if(isValid(ii, jj, m, n) && !marked[ii][jj]) 
                dfs(ii, jj, m, n);
        }
    }
    public boolean isValid(int i, int j, int m, int n) {
        if(i < 0 || i >= m ||
           j < 0 || j >= n)
            return false;
        if(a.get(i).charAt(j) != 'X')
            return false;
        
        return true;
               
    }
    public static void main(String[] args){
        Black b = new Black();
        ArrayList<String> a = new ArrayList<String>();
        a.add("OOOXOOO");
        a.add("OOXXOXO");
        a.add("OXOOOX0");
//        a.add("XXX");
//        a.add("XXX");
//        a.add("XXX");
        
        //System.out.println(black(a));
        System.out.println(b.blackSolutionBFS(a));
    }
}