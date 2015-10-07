/*
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 Example,
 Given:
 
 s1 = "aabcc",
 s2 = "dbbca",
 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
import java.util.*;
public class InterLeave {
    public static int isInterleave(String a, String b, String c) {
        if(c.length() != a.length() + b.length())
            return 0;
        int ai = 0;
        int bi = 0;
        int ci = 0;
        while(ai < a.length() && bi < b.length()){
//             && ai < a.length() && bi < b.length()
            System.out.printf("ci : %d, ai : %d, bi : %d \n", ci, ai, bi); 
            System.out.println(c.charAt(ci) + " " + a.charAt(ai) + " " + b.charAt(bi));
//            if(c.charAt(ci) != a.charAt(ai) ||
//               c.charAt(ci) != b.charAt(bi))
//                return 0;
            
            if(c.charAt(ci) == a.charAt(ai)){                
                ai++;
            }
            else if(c.charAt(ci) == b.charAt(bi)){
                bi++;
            }
            else
                return 0;
            ci++;
        }
        
        
        while(ai < a.length()){
            System.out.printf("ci : %d, ai : %d \n", ci, ai); 
            System.out.println(c.charAt(ci) + " " + a.charAt(ai));
            if(c.charAt(ci) == a.charAt(ai)){
                ci++;
                ai++;
            }
            else 
                return 0;
        }
        while(bi < b.length()){
            System.out.printf("ci : %d,  bi : %d \n", ci, bi); 
            System.out.println(c.charAt(ci) + " " + b.charAt(bi));
            if(c.charAt(ci) == b.charAt(bi)){
                ci++;
                bi++;
            }
            else 
                return 0;
        }
        
        
        return 1;
        
        
    }
    
     public static int isInterleaveEfficient(String a, String b, String c) {
          if(c.length() != a.length() + b.length())
            return 0;
          
          boolean[][] match = new boolean[a.length() + 1][b.length() + 1];
          
          for(int i = 1; i <= a.length(); i++){
              if(a.charAt(i-1) == c.charAt(i-1))
                  match[i][0] = true;
              else
                  break;
          }
          for(int i = 1; i <= b.length(); i++){
              if(b.charAt(i-1) == c.charAt(i-1))
                  match[0][i] = true;
              else
                  break;
          }
          
           for(int i = 1; i <= a.length(); i++){
               char ai = a.charAt(i-1);
               for(int j = 1; j <= b.length(); j++){
                   char bi = b.charAt(j-1);
                   int k = i + j;
                   char ci = c.charAt(k-1);
                   if(ai == ci)
                       match[i][j] = (match[i-1][j] || match[i][j]);
                   if(bi == ci)
                       match[i][j] = (match[i][j - 1] || match[i][j]);
               }
           }
            for(int i = 1; i < a.length(); i++){
                for(int j = 1; j < b.length(); j++){
                    System.out.print(match[i][j] + " ");
                }
                System.out.println();
            }
           
           System.out.println();
          if(match[a.length()][b.length()])
              return 1;
          else
              return 0;
          
         
     }
    public static void main(String[] args) {
        String a = "Z";
        String b = "8GUKOk8Dm8LRdq9jIqKSNF1SCAppV0gCUxAACAF43R5F6W";
        String c = "8GUZKOk8Dm8LRdq9jIqKSNF1SCAppV0gCUxAACAF43R5F6W";
        System.out.println(isInterleaveEfficient(a, b, c));
    }
}