import java.util.*;
public class MaxSumContinguousSubArray{
    public static int maxSum(int[] a){
        int maxEndingHere = 0;
        int maxSoFar = 0;
        for(int i = 0; i < a.length; i++) {
            maxEndingHere += a[i];
            if(maxEndingHere < 0)
                maxEndingHere = 0;
            if(maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;            
            
        }
        return maxSoFar;
    }
    public static int sumArrayList(ArrayList<Integer> list){
        int sum = 0;
        for(int i =0; i < list.size(); i++)
            sum += list.get(i);
        return sum;
    }
    public static int maxSumEfficient(int[] a){
        int maxSoFar = a[0];
        int currentMax = a[0];
        ArrayList<Integer> result = new  ArrayList<Integer>();
        int toAdd = 0;
        for(int i = 1; i < a.length; i++){
            if(currentMax + a[i] > a[i]){               
                currentMax = currentMax + a[i];
            }
            else {
                result.clear();                
                currentMax = a[i];
            }
             result.add(a[i]);
            //currentMax = Math.max(a[i], currentMax + a[i]);
            if(currentMax > maxSoFar){
                maxSoFar = currentMax;
                
            }
                        
            //maxSoFar = Math.max(maxSoFar, currentMax);
            System.out.println("For i : " +  i + "---" + result);
        }
        
        while(sumArrayList(result) != maxSoFar) {
            result.remove(result.size() - 1);
        }
        
        System.out.println(result);
        return maxSoFar;
    }
    public static void main(String[] args){
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum(a));
        System.out.println(maxSumEfficient(a));
    }
}