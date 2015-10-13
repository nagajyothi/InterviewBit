public class NumberOfTriangles {
    public static int findNumberOfTriangles(int[] a) {        
        //Sort the array
        Arrays.sort(a);
        
        int n = a.length;
        int count = 0;
        
        //Fix the first element, we will need to run till n-3 as the other two elements are selected from a[i+1.. n-1]
        for(int i =0; i < n-2; i++){
            
            //Initialize index of the rightmost third element
            int k = i + 2;            
            System.out.println("For i = " +  i );
            
            // Fix the second element
            for(int j = i+1; j < n; j++){
                System.out.println("\t For  j = " + j);
                
                /*
                 * Find the rightmost element which is smaller than the sum of two fixed elements
                 * Note: we use previous value of k. if value of a[i] + a[j-1] > a[k] then
                 *       a[i] + a[j] > a[k] since array is sorted
                 */                
                while(k < n && a[i] + a[j] > a[k]) {
                    System.out.println("\t \t For k = " + k);
                    System.out.println("\t \t [" + a[i] + ", " + a[j] + ", " + a[k] + "]");
                    k++;
                }
                
                /*
                 * Total number of possible triangles that can be formed with the two fixed elements is k-j-1;
                 * The two fixed elements are a[i] and a[j].
                 * All the elements between a[j+1] to a[k-1] can form a triangle with a[i] and a[j]
                 * One is subtracted from k because k is incremented one extra in above while loop.
                 * k will always be grater than j.
                 * if j becomes equal to k, then above loop will increment k,
                 * because a[k] + a[i] > a[j]
                 */
                count += k-j-1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] a = {10, 21, 22, 100, 101, 200, 300};
        System.out.println(findNumberOfTriangles(a));
        
    }
}