import java.util.*;
public class LargestNumber implements Comparator<Integer> {
    // For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
    public String largestNumber(final List<Integer> A) {
        List<Integer> B = A;
        Collections.sort(B, this);
        String ans = "";
        for(int i=B.size()-1;i>=0;i--)
            ans = ans+Integer.toString(B.get(i));
        return ans;
    }
    public int compare(Integer a,Integer b){
        String as = Integer.toString(a);
        String bs = Integer.toString(b);
        String fe = as+bs;
        String se = bs+as;
        return (fe.compareTo(se));
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