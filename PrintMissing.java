/*
 * Given an array of integers print the missing elements that lie in range 0-99. If there are more than one missing, collate them, otherwise just print the number.
 * 
 Note that the input array may not be sorted and may contain numbers outside the range [0-99], but only this range is to be considered for printing missing elements.
 
 Examples
 
 Input: {88, 105, 3, 2, 200, 0, 10}
 Output: 1
 4-9
 11-87
 89-99
 
 
 Input: {9, 6, 900, 850, 5, 90, 100, 99}
 Output: 0-4
 7-8
 10-89
 91-98
 */
public class PrintMissing{
    public static void printMissingElements(int[] A, int n){
        boolean[] seen = new boolean[n];
       
        for(int j = 0; j < A.length; j++){
            if(A[j] < n)
                seen[A[j]] = true;
        }
        int i = 0;
        while(i < n){
            if(!seen[i]){
                int j = i+1;
                while(j < n && !seen[j])
                    j++;
                if(i+1 == j)
                    System.out.printf("%d \n", i);
                else
                    System.out.printf("%d - %d \n", i, j-1);
                i = j;                          
            }
            else{
                i++;
            }
        }
    }
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int[] A = {9, 6, 900, 850, 5, 90, 100, 99};
        printMissingElements(A, n);
    }
}