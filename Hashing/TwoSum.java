/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * 
 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based. 
 Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.
 
 If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
 
 Input: [2, 7, 11, 15], target=9
 Output: index1 = 1, index2 = 2
 */
import java.util.*;
public class TwoSum{
    //This is not returning minimum index1;
    public static ArrayList<Integer> twoSumSolution(final List<Integer> a, int b) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        result.add(0);
        for(int i = 0; i < a.size(); i++){
            if(map.containsKey(a.get(i))){
                int index = map.get(a.get(i));
                result.set(0, index + 1);
                result.set(1, i + 1);
                break;
            }
            else{
                map.put(b - a.get(i), i);
            }
        }
        
        
        
//         System.out.println("Printing");
//        for(int i : map.values())
//            System.out.print(i + " ");
//        
//        System.out.println();
        return result;
    }
   static class Node implements Comparable<Node> {
        
        int left;
        int right;
        
        public Node(int left, int right) {
            this.left = left;
            this.right  = right;
        }
        
        public int compareTo(Node o) {
            if (this.right < o.right)
                return -1;
            if (this.right > o.right)
                return 1;
                
            return Integer.compare(this.left, o.left);
        }
        
    }
    
 public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
     
     int sum = B;
     int diff;
     HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
     int size = A.size();
     int num;
     int index;
     ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Node> node = new ArrayList<>();
     
     for (int i = size - 1; i >= 0; i--) {
         num = A.get(i);
         diff = sum - num;
         
         if (hashMap.containsKey(diff)) {
             index = hashMap.get(diff);
             node.add(new Node(i + 1, index + 1));
         }
         
         hashMap.put(num, i);
         
     }
     
     if (node.size() > 0) {
         Collections.sort(node);
            res.add(node.get(0).left);
            res.add(node.get(0).right);
     }
     
     return res;
     
 }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(7);
        a.add(11);
        a.add(15);
        ArrayList<Integer> result = twoSumSolution(a, 9);
        for(int i : result)
            System.out.print(i + " ");
    }
}