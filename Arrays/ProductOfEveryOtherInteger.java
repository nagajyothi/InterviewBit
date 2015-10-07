/*
 * 
 */
public class ProductOfEveryOtherInteger {
    public static void multiply(int[] a) {
        int[] result = new int[a.length];
        
        int temp = 1;
        
        for(int i = 0; i < result.length; i++){
            result[i] = temp;
            temp *= a[i];
        }
        
        for(int i = 0; i < result.length; i++)
           System.out.print(result[i] + " ");
        System.out.println();
        temp = 1;
        for(int i = result.length - 1 ; i >= 0; i--){
            result[i] = result[i] * temp;
            temp *= a[i];
        }
         for(int i = 0; i < result.length; i++)
           System.out.print(result[i] + " ");
        System.out.println();
    }
    public static void main(String[] args){
        int[] a = {1, 7, 3, 4};
        int[] result = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            result[i] = 1;
            for(int j = 0; j < a.length; j++) {
                if(i != j)
                    result[i] *= a[j];
            }
        }
        multiply(a);
//       for(int i = 0; i < a.length; i++)
//           System.out.print(result[i] + " ");
//       System.out.println();
       
       
    }
}