/*
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class ArrayLargestNum{
    public static String largestNumber(Integer[] a){
        String result = "0";
        //String temp = "";
        int N = a.length;
        for(int i = 0; i < N; i++) {
            String temp = Integer.toString(a[i]);
            for(int j = 0; j < N; j++) {
                if(i != j){
                    temp = temp + Integer.toString(a[j]);
                }
            }
            System.out.println(temp);
            if(Integer.parseInt(temp) > Integer.parseInt(result))
                result = temp;
        }
        return result;
        
    }
    public static void main(String[] args){
        Integer[] a = {3, 30, 34, 5, 9};
        Merge m = new Merge();
        m.sort(a);
        System.out.println(ArrayLargestNum.largestNumber(a));
    }
    
}