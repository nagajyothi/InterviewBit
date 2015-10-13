public class NumberOfTriangles {
    public static int findNumberOfTriangles(int[] a) {
        int n = a.length;
        int count = 0;
        for(int i =0; i < n-2; i++){
            int k = i + 2;
            System.out.println("For i = " +  i );
            for(int j = i+1; j < n; j++){
                System.out.println("\t For  j = " + j);
                while(k < n && a[i] + a[j] > a[k]) {
                    System.out.println("\t \t For k = " + k);
                    System.out.println("\t \t [" + a[i] + ", " + a[j] + ", " + a[k] + "]");
                    k++;
                }
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