/*
 * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
 * 
 The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.
 
 
 
 The input corresponding to the above configuration :
 
 ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
 A partially filled sudoku which is valid.
 
 Note:
 
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
import java.util.*;
public class ValidSudoku{
    public static int isValidSudoku(final List<String> a) {
        int[] col = new int[9];
        int[] box = new int[9];
        for(int i = 0; i < 9; i++){
            int row = 0;
            
            for(int j = 0; j < 9; j++){
                if(a.get(i).charAt(j) == '.')
                    continue;
                int bit = 1 << (a.get(i).charAt(j) - '1');
                int box_index = i/3*3 + j/3;
                if((bit & row) != 0 || (bit & col[j]) != 0 || (bit & box[box_index]) != 0){
                    return 0;
                }
                row |= bit;
                col[j] |= bit;
                box[box_index] |= bit;
            }
        }
        return 1;
    }
    //Effective Hash solution
    public static int isValidSodukuEfficient(final List<String> a) {
        if(a == null)
            return 0;
        int n = a.size();
        if(n != 0 || a.get(0).length() != 9)
            return 0;
        HashSet<Character> set = new HashSet<Character>();
        
        for(int i =0; i < 9; i++){
            set.clear();
            for(int j = 0; j < 9; j++){
                char c = a.get(i).charAt(j);
                if(c == '.')
                    continue;
                if(set.contains(c))
                    return 0;
                set.add(c);
            }
        }
        
        for(int i = 0; i < 9; i++){
            set.clear();
            for(int j = 0; j < 9; j++){
                char c = a.get(j).charAt(i);
                if(c == '.')
                    continue;
                if(set.contains(c))
                    return 0;
                set.add(c);
            }
        }
        
        for(int k =0; k < 9; k++){
            int x = k / 3;
            int y = k % 3;
            
            for(int i = 3*x; i < 3*x + 3; i++){
                for(int j = 3*y; j < 3*y + 3; j++){
                    char c = a.get(j).charAt(i);
                    if(c == '.')
                        continue;
                    if(set.contains(c))
                        return 0;
                    set.add(c);
                }
            }
        }
        
        return 1;
    }
    public static void main(String[] args){
        List<String> a = new ArrayList<String>();
        a.add("..5.....6");
        a.add("....14...");
        a.add(".........");
        a.add(".....92..");
        
        a.add("5....2...");
        a.add(".......3.");
        a.add("...54....");
        a.add("3.....42.");
        a.add("...27.6..");
     
        System.out.println(isValidSudoku(a));
    }
}