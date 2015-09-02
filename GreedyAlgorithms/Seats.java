/*
 * There is a row of seats. Assume that it contains N seats adjacent to each other. There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.
 * 
 An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')
 
 Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.
 
 Return minimum value % MOD where MOD = 10000003
 
 Example
 
 Here is the row having 15 seats represented by the String (0, 1, 2, 3, ......... , 14) -
 
 . . . . x . . x x . . . x . .
 
 Now to make them sit together one of approaches is -
 . . . . . . x x x x . . . . .
 
 Following are the steps to achieve this -
 1 - Move the person sitting at 4th index to 6th index -  
 Number of jumps by him =   (6 - 4) = 2
 
 2 - Bring the person sitting at 12th index to 9th index - 
 Number of jumps by him = (12 - 9) = 3
 
 So now the total number of jumps made = 
 ( 2 + 3 ) % MOD = 
 5 which is the minimum possible jumps to make them seat together.
 
 There are also other ways to make them sit together but the number of jumps will exceed 5 and that will not be minimum.
 
 For example bring them all towards the starting of the row i.e. start placing them from index 0. 
 In that case the total number of jumps will be 
 ( 4 + 6 + 6 + 9 )%MOD 
 = 25 which is very costly and not an optimized way to do this movement
 */
import java.util.*;
public class Seats{
    public static int seats(String a) {
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < a.length(); i++){
            int count = shift(a.toCharArray(), i);
            if(count < minCount)
                minCount = count;
            System.out.println("Count = " + count);
        }
        return minCount;
    }
    
    public static int shift(char[] s, int i){
        System.out.println("Shifting with i = " + i + " is " + String.valueOf(s));
        int count = 0;
        int j = 0;
        int k = i;
        while(j < k){
            if(s[j] == '.'){                
                j++;
                System.out.println("\t incremented j = " + j);
            }
            else if(s[k] == 'x'){
                k--;
                System.out.println("\t decremented k = "+ k);
            }
            else{
                s[k] = s[j];
                s[j] = '.';
                count += k-j;
                j++;
                k--;
                System.out.println("\t decremented j and incremented k " + j + ", " + k );
            }            
        }
        System.out.println("After shifting with first half is " + String.valueOf(s) +" count = " + count);
        j = s.length - 1;
        k = i;
        while (j > k) {
            if (s[j] == '.') {
                j--;
            }
            else if (s[k] == 'x') {
                k++;
            }
            else {
                s[k] = s[j];
                s[j] = '.';
                count += j-k;
                j--;
                k++;
            }
        }
        
        System.out.println("After shifting with i = " + i + " is " + String.valueOf(s) +" count = " + count);
        return count;
    }
    
     public static int seatsOptimized(String a) {
         int i = findMedian(a.toCharArray());
         if(i == -1)
             return 0;
         return shift(a.toCharArray(), i);
     }
     
     public static int findMedian(char[] s){
         int count1 = 0;
         for(int i = 0; i <s.length; i++){
             if(s[i] == 'x')
                 count1++;
         }
         if(count1 == 0)
             return -1;
         
         count1 = (count1 + 1)/2;
         int count2 = 0;
         for(int i = 0; i <s.length; i++){
             if(s[i] == 'x'){
                 count2++;
                 if(count2 == count1)
                     return i;
             }
         }
         return -1;
             
     }
    
    public static void main(String[] args){
        String a = "....x..xx...x..";
        System.out.println(seatsOptimized(a));
    }
}