/*
 * Knight movement on a chess board
 * 
 Given any source point and destination point on a chess board, we need to find whether Knight can move to the destination or not.
 
 Knight's movements
 
 The above figure details the movements for a knight ( 8 possibilities ). Note that a knight cannot go out of the board.
 
 If yes, then what would be the minimum number of steps for the knight to move to the said point.
 If knight can not move from the source point to the destination point, then return -1
 
 Input:
 
 N, M, x1, y1, x2, y2
 where N and M are size of chess board
 x1, y1  coordinates of source point
 x2, y2  coordinates of destination point
 Output:
 
 return Minimum moves or -1
 Example
 
 Input : 8 8 1 1 8 8
 Output :  6
 */
import java.util.*;
public class Knight {
//    private boolean[] marked;  // marked[v] = is there an s-v path
//    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
//    private int[] distTo; 
    private int moves;
    class Point {
        private int x;
        private int y;
        private boolean visited;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
            this.visited = false;
        }
        public ArrayList<Point> adj(int i, int j) {
            ArrayList<Point> result = new ArrayList<Point>();
            result.add(new Point(i - 2, j - 1));
            result.add(new Point(i - 1, j - 2));
            result.add(new Point(i + 1, j - 2));
            result.add(new Point(i + 2, j - 1));
            result.add(new Point(i - 2, j + 1));
            result.add(new Point(i - 1, j + 2));
            result.add(new Point(i + 1, j + 2));
            result.add(new Point(i + 2, j + 1));
            
            return result;
        }
    }
    public static int knight(int N, int M, int x1, int y1, int x2, int y2) {
        int i = x1;
        int j = y1;
        int steps = -1;
        if(i == x2 && j == y2)
            return 0;
        int[][] dp = new int[N][M];
        dp[0][0] = 0;
        
        Point start = new Point(x1, y1);
        Point end = new Point(x2, y2);
        
        Queue<Point> queue = new LinkedList<Point>();
        
        for(Point p : adj(i, j)){
            p.visited = true;
            
        }
        for(i = x1 - 1; i <= x2 - 1; i++) {
            for(j = y1 - 1; j <= y2-1; j++) {
                dp[i][j] = -1;
                
            }
            
        }
        while(i != x2 && j != y2){
            
        }
        return dp[x2][y2];
        
    }
    
    public ArrayList<Point> adj(int i, int j) {
        ArrayList<Point> result = new ArrayList<Point>();
        result.add(new Point(i - 2, j - 1));
        result.add(new Point(i - 1, j - 2));
        result.add(new Point(i + 1, j - 2));
        result.add(new Point(i + 2, j - 1));
        result.add(new Point(i - 2, j + 1));
        result.add(new Point(i - 1, j + 2));
        result.add(new Point(i + 1, j + 2));
        result.add(new Point(i + 2, j + 1));
        
        return result;
    }
    public static void main(String[] args) {
    }
}