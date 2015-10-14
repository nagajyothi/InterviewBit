/*
 * Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example : 
edit distance between
"Anshuman" and "Antihuman" is 2.

Operation 1: Replace s with t.
Operation 2: Insert i.
 */
public class EditDistance {
   public int minDistance(String a, String b) {
     int aLength = a.length();
        int bLength = b.length();
        if(aLength == 0){
            return bLength;
        }
        if(bLength == 0){
            return aLength;
        }
        
        int[][] table = new int[aLength + 1][bLength + 1];
        for(int i = 1; i <= aLength; i++)
            table[i][0] = i;
        for(int i = 1; i <= bLength; i++)
            table[0][i] = i;
        
        for(int i = 0; i < aLength; i++){
            for(int j = 0; j < bLength; j++){
                table[i+1][j+1] = Math.min(table[i+1][j],
                                           table[i][j+1]) + 1;
                if(a.charAt(i) == b.charAt(j))
                    table[i+1][j+1] = Math.min(table[i+1][j+1],
                                               table[i][j]);
                else
                    table[i+1][j+1] = Math.min(table[i+1][j+1],
                                               table[i][j] + 1);
            }
        }
        // for(int i = 0; i <= aLength; i++){
        //     for(int j = 0; j <= bLength; j++){
        //         System.out.print(table[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return table[aLength][bLength];
 }  
}