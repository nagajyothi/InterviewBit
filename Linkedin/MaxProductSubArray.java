/*
 * Find max product of continuous sequence
 */
public class MaxProductSubArray {
    public static int maxProduct(int[] a) {
        int maxEndingHere = 1;
        int minEndingHere = 1;
        int maxProductSoFar = 1;
        
        for(int i = 0; i < a.length; i++) {
            if(a[i] > 0){
                maxEndingHere = maxEndingHere * a[i];
                minEndingHere = Math.min(1, minEndingHere * a[i]);
            }
            else if(a[i] == 0){
                maxEndingHere = 1;
                minEndingHere = 1;
            }
            else {
                int temp = maxEndingHere;
                maxEndingHere = Math.max(minEndingHere * a[i], 1);
                minEndingHere = temp * a[i];
            }
            maxProductSoFar = Math.max(maxProductSoFar, maxEndingHere);
        }
        return maxProductSoFar;
    }
    public static void main(String[] args){
        int[] a = {6, -3, -10, 0, 2};
        System.out.println(maxProduct(a));
        
    }
}