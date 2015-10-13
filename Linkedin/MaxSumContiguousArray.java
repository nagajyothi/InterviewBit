public class MaxSumContiguousArray {
    public static int maxSum(int[] a) {
        int currentSum = a[0];
        int maxSumSoFar = a[0];
        for(int i =1; i < a.length; i++) {
            currentSum = Math.max(currentSum + a[i], a[i]);
            maxSumSoFar = Math.max(currentSum, maxSumSoFar);
        }
        return maxSumSoFar;
    }
    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum(a));
    }
}