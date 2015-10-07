/*
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

Unfortunately, there is no magic trick to solving this problem. This is more of a bruteforce problem. A more intelligent bruteforce.

Notes : 
1) There can exactly be one queen per row. Otherwise the 2 queens in the row would collide. If you miss out on a row, there cannot be N queens on the board. 
2) Every column needs to have exactly one queen. 
3) The left diagonal cannot have more than one queen ( Unique (row + col) )
4) The right diagonal cannot have more thna one queen ( Unique (row - col) )

We can start placing a queen per row. When placing a queen on a row, col, we need to check if the position is available based on what we have already placed. Then we move to the next row.
 */
import java.util.*;
public class NQueens{
    public static ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(a < 1)
            return result;
        int[] queens = new int[a];
        enumerate(queens, 0, result);
        return result;
    }
    public static void enumerate(int[] queens, int n, ArrayList<ArrayList<String>> result){
        int N = queens.length;
        
        if(n == N)
            addQueensToResult(queens, result);
        else{
            for(int i = 0; i < N; i++){
                System.out.println("****************For row = " + i + " place queens["+n+"] = " + i +"***********");
                queens[n] = i;
                if(isConsistent(queens, n))
                    enumerate(queens, n+1, result);
            }
        }
    }
    public static boolean isConsistent(int[] queens, int n){
        for(int i =0; i < n; i++){
            System.out.printf("queens[%d] = %d and queens[%d] = %d \n", i, n, queens[i], queens[n]);
            if(queens[i] == queens[n]){ // same column
                System.out.println("\t Same Column");
                return false;
            }
            if((queens[i] - queens[n]) == (n - i)) {// same major diagonal
                System.out.println("\t Same major diagonal");
                return false;
            }
            if((queens[n] - queens[i]) == (n - i)) {//same minor diagonal
                System.out.println("\t Same minor diagonal");
                return false;
            }
        }
        System.out.println("\t Is consistent so enumerate " + (n+1));
        return true;
    }
    public static void addQueensToResult(int[] queens, ArrayList<ArrayList<String>> result){
        int N = queens.length;
        ArrayList<String> temp = new ArrayList<String>();
        for(int i =0; i < N; i++){
            String row = "";
            for(int j = 0; j < N; j++){
                if(queens[i] == j)
                    row += "Q";
                else
                    row += ".";
            }
            temp.add(row);
        }
        result.add(temp);
    }
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        ArrayList<ArrayList<String>> result = solveNQueens(a);
        for(ArrayList<String> list : result)
            System.out.println(list);
    }
}