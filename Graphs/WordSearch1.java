import java.util.*;
public class WordSearch1{
    public static int exist(ArrayList<String> a, String word) {
        int m = a.size();
        int n = a.get(0).length();
        
        char[][] visited = new char[a.size()][a.get(0).length()];
        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < a.get(i).length(); j++){
                visited[i][j] = a.get(i).charAt(j);
            }
        }
        
        int result = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(visited,word,i,j,0)){
                    result = 1;
                }
            }
        }
        
        return result;
    }
    
    public static boolean dfs(char[][] board, String word, int i, int j, int k){
        int m = board.length;
        int n = board[0].length;
        
        if(i<0 || j<0 || i>=m || j>=n){
            return false;
        }
        
        if(board[i][j] == word.charAt(k)){
            char temp = board[i][j];
            board[i][j]='#';
            if(k == word.length()-1){
                return true;
            }else if(dfs(board, word, i-1, j, k+1)
                         ||dfs(board, word, i+1, j, k+1)
                         ||dfs(board, word, i, j-1, k+1)
                         ||dfs(board, word, i, j+1, k+1)){
                return true;
            }
            board[i][j]=temp;
        }
        
        return false;
    }
    
    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<String>();
        a.add("FEDCBECD");
        a.add("FABBGACG");
        a.add("CDEDGAEC");
        a.add("BFFEGGBA");
        a.add("FCEEAFDA");
        a.add("AGFADEAC");
        a.add("ADGDCBAA");
        a.add("EAABDDFF");
        
        
        String b = "BCDCB";
        for(String s : a){
            for(int i = 0; i < s.length(); i++)
                System.out.print(s.charAt(i) + " ");
            System.out.println();
        }
        System.out.println("b : " + b);
        if(exist(a, b) == 1)
        System.out.println("true");
        else
            System.out.println("false");
    }
}