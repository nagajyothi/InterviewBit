public class Paths{
    public static int uniquePaths(int A, int B) {
        int[][] matrix = new int[A+10][B+10];
        for(int i = 0; i < A+10; i++){
            for(int j = 0; j< B+10; j++)
                matrix[i][j] = 0;
        }
        matrix[A][B+1] = 1;
        for(int r = A; r >= 1; r--){
            for(int c = B; c >= 1; c--){
                matrix[r][c] = matrix[r+1][c]+matrix[r][c+1];
            }
        }
        return matrix[1][1];
    }
    public static void main(String[] args){
        int A = Integer.parseInt(args[0]);
        int B = Integer.parseInt(args[1]);
        System.out.println(uniquePaths(A,B));
    }
}