/*
 * For Given Number N find if its COLORFUL number or not
 * 
 Return 0/1
 
 COLORFUL number:
 
 A number can be broken into different sub-sequence parts. 
 Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
 And this number is a COLORFUL number, since product of every digit of a sub-sequence are different
 Example:
 
 N = 23
 2 3 23
 2 -> 2
 3 -> 3
 23 -> 6
 this number is a COLORFUL number since product of every digit of a sub-sequence are different. 
 
 Output : 1
 */
import java.util.*;
public class ColorFull{
    public static int colorful(int a) {
        ArrayList<Integer> list = new ArrayList<Integer>();     
        HashSet<Integer> set= new HashSet<Integer>();

        while(a > 0){
            int remainder = a % 10;
            //System.out.println("remainder : "+ remainder);
            list.add(remainder);
            a = a/10;
            //System.out.println("a : "+ a);
            
        }
        for(int k : list)
            System.out.print(k + " ");
        
        int i = 0;
        while(i < list.size()){
            
            int j = i + 1;
            //System.out.printf("For i = %d and j = %d \n ", i ,  j);
            if(set.contains(list.get(i)))
                return 0;
            //System.out.println("\t digit = " + list.get(i));
            set.add(list.get(i));
            int result = list.get(i);
            //System.out.println("Result before j loop:" +result);
            while(j < list.size() && i != list.size() - 1){
                result = result * list.get(j);
                if(set.contains(result))
                    return 0;
                set.add(result);
                j++;
            }
            i++;                    
        }
        
//        Iterator it = set.iterator();
//        while(it.hasNext()){
//            System.out.print(it.next() + " ");
//        }
//        System.out.println();
        return 1;
    }
    
    //From solution
     public int colorful(int A) {
     HashSet<Integer> hashSet = new HashSet<>();
     ArrayList<Integer> numbers = new ArrayList<>();
     
     while (A != 0) {
         int num = A % 10;
         numbers.add(num);
         A /= 10;
     }
     
     Collections.reverse(numbers);
     int n = numbers.size();
     
     for (int i = 0; i < n; i++) {
         for (int j = i; j < n; j++) {
             int prod = 1;
             for (int k = i; k <= j; k++) {
                 prod *= numbers.get(k);
             }
             
             if (hashSet.contains(prod))
                 return 0;
                 
             hashSet.add(prod);
         }
     }
     
     return 1;
     
 }
    public static void main(String[] args){
        int num = Integer.parseInt(args[0]);
        System.out.println(colorful(num));
    }
}