/*
 * Given A, how many structurally unique BST’s (binary search trees) that store values 1...A ?
 * 
 Example :
 
 Given A = 3, there are a total of 5 unique BST’s.
 
 
 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 
 */
import java.util.*;
public class UniqueTrees{
    public static int numTrees(int a) {
        if(a < 0)
            return 0;
        int[] count = new int[a+1];
        count[0] = 1;
        count[1] = 1;
        for(int i = 2; i <= a; i++){
            //int n = i - 1;;
            for(int j = 0; j <= i-1; j++){
                count[i] += count[j] * count[i - j - 1];
               // n--;
            }
                
        }
        return count[a];
    }
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        System.out.println(numTrees(a));
    }
}