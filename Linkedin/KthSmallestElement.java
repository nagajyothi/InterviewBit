/*
 * Return the Kth smallest element in an array
 */
public class KthSmallestElement {
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static int partition(int[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while(true) {
            while(a[++i] < v) {
                if(i == hi)
                    break;
            }
            while(v < a[--j]) {
                if(j == lo)
                    break;
            }
            if(i >= j)
                break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }
    
    public static int findKthSmallest(int[] a, int k) {
        return findKthSmallestHelper(a, k, 0, a.length - 1);
    }
    public static int findKthSmallestHelper(int[] a, int k, int lo, int hi) {
        if(k > 0 && k <= hi - lo + 1) {
            int pos = partition(a, lo, hi);
            if(pos - lo == k - 1) {
                return a[pos];
            }
            if(pos - lo  > k - 1) {
                return findKthSmallestHelper(a, k, lo, pos - 1);
            }
            else {
                return findKthSmallestHelper(a, k - pos + lo - 1, pos + 1, hi);
            }       
        }
        return Integer.MAX_VALUE;
    }
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 8, 10, 11};
        int k = 8;
        System.out.println(findKthSmallest(a, k));
        
    }
}