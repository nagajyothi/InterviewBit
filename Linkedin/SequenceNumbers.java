/*
 * There is a particular sequence only uses the numbers 1, 2, 3, 4 and no two adjacent numbers are the same.
 Write a program that given n1 1s, n2 2s, n3 3s, n4 4s will output the number of such sequences using all these numbers.
 Output your answer modulo 1000000007 (10^9 + 7).
 */
import java.util.*;
public class SequenceNumbers {
    public static int numberOfSequences(int n1, int n2, int n3, int n4) {
        int[] result = new int[1];
        result[0]++; 
        numberOfSequencesHelper(n1, n2, n3, n4, 1, 0 , 0 , 0 , 1, result);
        result[0]++;
        numberOfSequencesHelper(n1, n2, n3, n4, 0, 1 , 0 , 0 , 2, result);
        result[0]++;
        numberOfSequencesHelper(n1, n2, n3, n4, 0, 0 , 1 , 0 , 3, result);
        result[0]++;
        numberOfSequencesHelper(n1, n2, n3, n4, 0, 0 , 0 , 1 , 4, result);
        return result[0];
    }
    
    public static void numberOfSequencesHelper(int n1, int n2, int n3, int n4,
                                               int k1, int k2, int k3, int k4, 
                                               int lastDigit, int[] result){
        if(k1 + k2 + k3 + k4 == n1 + n2 + n3 + n4) return;
        if(lastDigit == 1){
            if(k2 < n2){
                result[0]++;
                numberOfSequencesHelper(n1, n2, n3, n4, k1, k2+1, k3, k4, 2 , result);     
            }
            if(k3 < n3){
                result[0]++;
                numberOfSequencesHelper(n1, n2, n3, n4, k1, k2, k3 + 1, k4, 3 , result);     
            }
            if(k4 < n4){
                result[0]++;
                numberOfSequencesHelper(n1, n2, n3, n4, k1, k2, k3, k4 + 1, 4 , result);     
            }
        }
        if(lastDigit == 2){
            if(k1 < n1){
                result[0]++;
                numberOfSequencesHelper(n1, n2, n3, n4, k1 + 1, k2, k3, k4, 1 , result);     
            }
            if(k3 < n3){
                result[0]++;
                numberOfSequencesHelper(n1, n2, n3, n4, k1, k2, k3 + 1, k4, 3 , result); 
            }
            if(k4 < n4){
                result[0]++;
                numberOfSequencesHelper(n1, n2, n3, n4, k1, k2, k3, k4 + 1, 4 , result);     
            }
        }
        if(lastDigit == 3) {
            if(k1 < n1){
                result[0]++;
                numberOfSequencesHelper(n1, n2, n3, n4, k1 + 1, k2, k3, k4, 1 , result); 
            }
            if(k2 < n2){ 
                result[0]++;
                numberOfSequencesHelper(n1, n2, n3, n4, k1, k2+1, k3, k4, 2 , result);   
            }
            if(k4 < n4){
                result[0]++;
                numberOfSequencesHelper(n1, n2, n3, n4, k1, k2, k3, k4 + 1, 4 , result);    
            }
        }
        if(lastDigit == 4) {
            if(k1 < n1){
                result[0]++;
                numberOfSequencesHelper(n1, n2, n3, n4, k1 + 1, k2, k3, k4, 1 , result); 
            }
            if(k2 < n2){
                result[0]++;
                numberOfSequencesHelper(n1, n2, n3, n4, k1, k2+1, k3, k4, 2 , result);   
            }
            if(k3 < n3){
                result[0]++;
                numberOfSequencesHelper(n1, n2, n3, n4, k1, k2, k3 + 1, k4, 3 , result);    
            }
        }
        
    }
    public static int numberOfSequencesDP(int n1, int n2, int n3, int n4) {
        int[][][][] dp1 = new int[n1 + 1][n2 + 1][n3 + 1][n4 + 1];
        int[][][][] dp2 = new int[n1 + 1][n2 + 1][n3 + 1][n4 + 1];
        int[][][][] dp3 = new int[n1 + 1][n2 + 1][n3 + 1][n4 + 1];
        int[][][][] dp4 = new int[n1 + 1][n2 + 1][n3 + 1][n4 + 1];
        
        dp1[1][0][0][0] = 1;
        dp2[0][1][0][0] = 1;
        dp3[0][0][1][0] = 1;
        dp4[0][0][0][1] = 1;
        int MOD = 1000000007;
        for(int i = 0; i <= n1; i++){
            for(int j =0; j < n2; j++){
                for(int k = 0; k < n3; k++){
                    for(int l = 0; l < n4; l++){
                        if(i+j+k+l > 1){
                            if(i != 0)
                                dp1[i][j][k][l] = dp2[i-1][j][k][l] + dp3[i-1][j][k][l] + dp4[i-1][j][k][l] % MOD;
                            if(j != 0)
                                dp2[i][j][k][l] = dp1[i][j-1][k][l] + dp3[i][j-1][k][l] + dp4[i][j-1][k][l] % MOD;
                            if(k != 0)
                                dp3[i][j][k][l] = dp1[i][j][k-1][l] + dp2[i][j][k-1][l] + dp4[i][j][k-1][l] % MOD;
                            if(l != 0)
                                dp4[i][j][k][l] = dp1[i][j][k][l-1] + dp2[i][j][k][l-1] + dp3[i][j][k][l-1] % MOD;
                        }
                    }
                }
            }
        }
        return dp1[n1][n2][n3][n4] + dp2[n1][n2][n3][n4] + dp3[n1][n2][n3][n4] + dp4[n1][n2][n3][n4];
    }
    public static void main(String[] args){
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        int n3 = Integer.parseInt(args[2]);
        int n4 = Integer.parseInt(args[3]);
        
        System.out.println(numberOfSequences(n1, n2, n3, n4));
    }
}