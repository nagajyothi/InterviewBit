/*
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The cell itself does not count as an adjacent cell. 
 The same letter cell may be used more than once.
 
 Example :
 
 Given board =
 
 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns 1,
 word = "SEE", -> returns 1,
 word = "ABCB", -> returns 1,
 word = "ABFSAB" -> returns 1
 word = "ABCD" -> returns 0
 Note that 1 corresponds to true, and 0 corresponds to false.
 * 
 */
import java.util.*;
public class WordSearch{
    public static int exist(ArrayList<String> a, String b) {
        if(a == null || a.size() == 0 || b == null || b.length() == 0)
            return 0;
        int result = 0;
        char[][] visited = new char[a.size()][a.get(0).length()];
        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < a.get(i).length(); j++){
                visited[i][j] = a.get(i).charAt(j);
            }
        }
        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < a.get(i).length(); j++){
                //if(b.charAt(0) == visited[i][j]){
                //System.out.println("start location  i = " +  i + " j = " + j);
                if(dfsSearch(a, b, i, j, 0, visited));
                return 1;
                //}
            }
        }
        return 0;
    }
    
    public static boolean dfsSearch(ArrayList<String> a, String b, int row, int column, int index, char[][] visited){
//        if(index == b.length())
//            return true;
        if(row < 0 ||
           row >= a.size() ||
           column < 0||
           column >= a.get(0).length())
//                visited[row][column] == '#' ||
//                b.charAt(index) != visited[row][column])
            return false;
        
        if(visited[row][column] == b.charAt(index)){     
            char temp = visited[row][column];
            visited[row][column] = '#';
            
            if(index == b.length() -1)
                return true;
            else if(dfsSearch(a, b, row, column + 1, index + 1, visited) ||
                    dfsSearch(a, b, row, column - 1, index + 1, visited) ||
                    dfsSearch(a, b, row -1, column, index + 1, visited)  ||
                    dfsSearch(a, b, row + 1, column, index + 1, visited))
                return true;
            visited[row][column] = temp;
        }
        return false;
        
    }
    
    
    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<String>();
        a.add("ADFFFFBFED");
        a.add("AEDFFBEECE");
        a.add("EBCCFCABFB");
        a.add("DEAGGBCGAE");
        a.add("EADEGEFBFE");
        a.add("BFAGDGAAFG");
//        a.add("ADGDCBAA");
//        a.add("EAABDDFF");
        
        
        String b = "DABABBD";
        for(String s : a){
            for(int i = 0; i < s.length(); i++)
                System.out.print(s.charAt(i) + " ");
            System.out.println();
        }
        System.out.println("b : " + b);
        System.out.println(exist(a, b));
    }
}
/*
 * //        System.out.println("\t right : " + right + " for row = " + row + ", column = " + (column + 1));
 //        right = ;
 //       
 //        System.out.println("\t left : " + left + " for row = " + row + ", column = " + (column - 1));
 //        left = dfsSearch(a, b, row, column - 1, index + 1, visited);
 
 //         System.out.println("\t top : " + top + " for row = " + (row - 1) + ", column = " + (column));
 //        top = dfsSearch(a, b, row -1, column, index + 1, visited);
 //       
 //        System.out.println("\t bottom : " + bottom + " for row = " + (row + 1) + ", column = " + (column));
 //        bottom = dfsSearch(a, b, row + 1, column, index + 1, visited);     
 
 */