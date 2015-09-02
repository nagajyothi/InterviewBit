/*
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * 
 A region is captured by flipping all 'O's into 'X's in that surrounded region.
 
 For example,
 
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:
 
 X X X X
 X X X X
 X X X X
 X O X X
 */
import java.util.*;
public class Surrounding{
    public static void solve(ArrayList<ArrayList<Character>> a) {
        if(a == null || a.size() == 0)
            return;
        int m = a.size();
        int n = a.get(0).size();
        
        //merge O's on left and right border
        for(int i =0; i < m; i++){
            if(a.get(i).get(0) == '0')
                merge(a, i, 0);
            if(a.get(i).get(n-1) == '0')
                merge(a, i, n-1);
        }
        
        //merge top and bottom
        for(int j =0; j < n; j++){
            if(a.get(0).get(j) == '0')
                merge(a, 0, j);
            if(a.get(m-1).get(j) == '0')
                merge(a, m-1, j);
        }
        
        System.out.println();
        for(ArrayList<Character> list : a){
            System.out.println(list);
        }
        for(int i = 0; i < m; i++){
            for(int j =0; j < n; j++){
                if(a.get(i).get(j) == '0')
                    a.get(i).set(j, 'X');
                else if(a.get(i).get(j) == '#')
                    a.get(i).set(j, '0');
            }
        }
        
       
        
    }
    
    public static void merge(ArrayList<ArrayList<Character>> a, int i, int j){
        if(i < 0 || i >= a.size() || j < 0 || j >= a.get(0).size())
            return;
        
        if(a.get(i).get(j) != '0')
            return;
        
        a.get(i).set(j, '#');
        
        merge(a, i - 1, j); // top
        merge(a, i + 1, j); // bottom
        merge(a, i, j - 1); // left
        merge(a, i, j + 1); // right
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Character>> a = new ArrayList<ArrayList<Character>>();
        ArrayList<Character> temp = new ArrayList<Character>();
        temp.add('X');
        temp.add('X');
        temp.add('X');
        //temp.add('X');
        a.add(new ArrayList<Character>(temp));
        temp.clear();
        
        temp.add('X');
        temp.add('0');
        //temp.add('0');
        temp.add('X');
        a.add(new ArrayList<Character>(temp));
        temp.clear();
        
//        temp.add('X');
//        temp.add('X');
//        temp.add('0');
//        temp.add('X');
//        a.add(new ArrayList<Character>(temp));
//        temp.clear();
        
        
        temp.add('X');
        //temp.add('0');
        temp.add('X');
        temp.add('X');
        a.add(new ArrayList<Character>(temp));
        temp.clear();
        
         for(ArrayList<Character> list : a){
            System.out.println(list);
        }
        
        solve(a);
         System.out.println();
        for(ArrayList<Character> list : a){
            System.out.println(list);
        }
    }
}
/*
 * int m = a.size();
        int n = a.get(0).size();
        System.out.println("Rows: " + m + " Columns : " + n);
        for(int i = 1; i < m-1; i++){
            for(int j = 1; j < n-1; j++){
                System.out.printf("\t a.get(%d).get(%d) = %c \n ", i, j, a.get(i).get(j));
                if(a.get(i).get(j) == '0'){
                    //left and right
                    //top and bottom
                    System.out.println(a.get(i).get(j - 1) + " "+ a.get(i).get(j + 1) + " " +a.get(i - 1).get(j) + " "+a.get(i + 1).get(j));
                    if(a.get(i).get(j - 1) == 'X' && a.get(i).get(j + 1) == 'X' &&
                       a.get(i - 1).get(j) == 'X' && a.get(i + 1).get(j) == 'X')
                        a.get(i).set(j, 'X');
                }
            }
        }
        System.out.println();
        for(ArrayList<Character> list : a){
            System.out.println(list);
        }
 */