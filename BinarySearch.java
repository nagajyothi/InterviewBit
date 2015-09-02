import java.util.Arrays;
public class BinarySearch {
    
    public static int rank(int key, int[] a){
        int lo = 0;
        int hi = a.length - 1;
        
        while(lo <=  hi){
            int mid = (lo+hi)/2;
            if(key > a[mid]) lo = mid+1;   
            else if(key < a[mid]) hi = mid-1;   
            else return mid;   
        }
        return -1;
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        In in = new In();
        int[] whiteList = in.readInts(args[0]);
        Arrays.sort(whiteList);
        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if(rank(key,whiteList) < 0){
                StdOut.println(key);
            }
        }
    }
    
}