import java.util.*;
public class MinimumDistance{
    //minimum distance between two numbers in a given array O(n^2)
    public int distance(int[] a, int x, int y){
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                if((a[i] == x && a[j] == y) ||
                   (a[i] == y && a[j] == x) && (Math.abs(i-j) < minDistance))
                    minDistance = Math.abs(i-j);
            }
        }
        return minDistance;
    }
    
    ////minimum distance between two numbers in a given array O(n)
    public int distanceEfficient(int[] a, int x, int y){
        int i = 0;
        int minDistance = Integer.MAX_VALUE;
        int prev = 0;
        for(i = 0; i < a.length; i++){
            if(a[i] == x || a[i] == y){
                prev = i;
                break;
            }                
        }
        
        while(i < a.length) {
            if(a[i] == x ||a[i] == y){
                if(a[prev] != a[i] && Math.abs(i-prev) < minDistance)
                    minDistance = Math.abs(i-prev);
                prev = i;
            }
            i++;
        }
        return minDistance;
    }
    
    //Min Distance for String arrays
    public int distanceStrings(String[] a, String x, String y){
        int i = 0;
        int minDistance = Integer.MAX_VALUE;
        int prev = 0;
        for(i = 0; i < a.length; i++){
            if(a[i].equals(x) || a[i].equals(y)){
                prev = i;
                break;
            }                
        }
        
        while(i < a.length) {
            if(a[i].equals(x) || a[i].equals(y)){
                if(!a[prev].equals(a[i]) && Math.abs(i-prev) < minDistance)
                    minDistance = Math.abs(i-prev);
                prev = i;
            }
            i++;
        }
        return minDistance;
    }
    
    public static void main(String[] args){
        int[] a = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        int x = 3;
        int y = 6;
        String[] arr = {"the", "quick", "brown", "fox", "quick"};     
        String one = "quick";
        String two = "fox";
        MinimumDistance md = new MinimumDistance();
        System.out.println("MinDistance between " + x + " and " +  y +  " = " + md.distance(a, x, y));
        System.out.println("MinDistance between " + x + " and " +  y +  " = " + md.distanceEfficient(a, x, y));
        System.out.println("MinDistance between " + one + " and " +  two +  " = " + md.distanceStrings(arr, one, two));
    }
}