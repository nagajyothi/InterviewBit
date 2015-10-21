/*
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
import java.util.*;
public class LargestNumber {
    // For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
    public class Node implements Comparable<Node> {
        int number;
        public Node(int num) {
            this.number = num;
        }
        
        @Override
        public int compareTo(Node that) {
            String first = String.valueOf(this.number) + String.valueOf(that.number);
            String second = String.valueOf(that.number) + String.valueOf(this.number);
            return second.compareTo(first);
        }                
    }
    public String largestNumber(final List<Integer> A) {
        StringBuffer result = new StringBuffer();
        Node num[];
        int i =0;
        num = new Node[A.size()];
        
        for(int n : A) {
            num[i] = new Node(n);
            i++;
        }
        
        Arrays.sort(num);
        for(Node n : num) {
            if(n.number == 0 && result.length() != 0)
                continue;
            result.append(n.number);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<Integer>();
        A.add(3);
        A.add(30);
        A.add(34);
        A.add(5);
        A.add(9);
        A.add(0);
        A.add(0);
        A.add(0);
        A.add(0);
        A.add(0);
        LargestNumber l = new LargestNumber();
        String result = l.largestNumber(A);
        int flag = 0;
        for(int i = 0; i < result.length(); i++){
            if(result.charAt(i) != '0')
                flag = 1;
        }
        if(flag == 1){
            System.out.println(l.largestNumber(A));
        }
        else {
            System.out.println("0");
        }
    }
}