public class SecondSmallestNumber{
    public static int secondSmallest(int[] a){
        int s1 = Integer.MAX_VALUE;
        int s2 = s1;
        for(int i = 0; i < a.length; i++){
            if(a[i] < s1){
                s2 = s1;
                s1 = a[i];
            }
            else if(a[i] < s2 && a[i] != s1)
                s2 = a[i];
        }
        return s2;
    }
    public static void main(String[] args){
        int[] a = {1,3,2,5,6,9};
        System.out.println(secondSmallest(a));
    }
}