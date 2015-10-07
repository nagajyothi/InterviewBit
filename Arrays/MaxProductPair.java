/*
 * 
 */
public class MaxProductPair {
    public static int maxProduct(int[] a) {
        int n = a.length;
        if(n < 2){
            System.out.println("No pairs exist");
            return 0;
        }
        if(n == 2)
            return a[0] * a[1];
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            if(a[i] > firstMax) {
                secondMax = firstMax;
                firstMax = a[i];
            }
            else if(a[i] > secondMax) {
                secondMax = a[i];                                
            }
            
            if(a[i] < firstMin) {
                secondMin = firstMin;
                firstMin = a[i];
            }
            else if(a[i] < secondMax) {
                secondMin = a[i];                                
            }
//            if(a[i] < 0 && Math.abs(a[i]) > Math.abs(firstMin)) {
//                secondMin = firstMin;
//                firstMin = a[i];
//            }
//            else if(a[i] < 0 && Math.abs(a[i]) > Math.abs(secondMin))
//                secondMin = a[i];
        }
        System.out.printf("firstMax : %d, secondMax : %d \n", firstMax, secondMax);
        System.out.printf("firstMin : %d, secondMin : %d \n", firstMin, secondMin);
        return Math.max(firstMin * secondMin, firstMax * secondMax);
            
    }
    public static void main(String[] args) {
        int[] a = {-1, -3, -4, 2, 0, -5};
        System.out.println(maxProduct(a));
    }
}