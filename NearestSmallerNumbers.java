/*
 * Given an array of integers, find the nearest smaller number for every element
 * such that the smaller element is on left side
 * Input:  arr[] = {1, 6, 4, 10, 2, 5}
 * Output:         {_, 1, 1,  4, 1, 2}First element ('1') has no element on left side. For 6, 
 * there is only one smaller element on left side '1'. 
 * For 10, there are three smaller elements on left side (1,
 * 6 and 4), nearest among the three elements is 4.
 * Input: arr[] = {1, 3, 0, 2, 5}
 * Output:        {_, 1, _, 0, 2}
 */
public class NearestSmallerNumbers{
    public static void prevSmallerNumber(int[] a){
        Stack<Integer> s = new Stack<Integer>();
        int popped = 0;
        
        for(int i = 0; i < a.length; i++){                        
            while(!s.isEmpty() && s.peek() >= a[i]){                
                popped = s.pop();                
            }
            if(s.isEmpty())
                System.out.print("_, ");               
            else
                System.out.print(s.peek() + ", ");
            s.push(a[i]);
        }
    }
    public static void main(String[] args){
        int[] a = {1, 6, 4, 10, 2, 5};
        prevSmallerNumber(a);
    }
}