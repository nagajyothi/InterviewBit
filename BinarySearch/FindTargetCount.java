/*
 * 
 */
import java.util.*;
public class FindTargetCount {
    public int findCount(final List<Integer> a, int b) {
        
        int firstIndex = BinarySearch(a, b, true);
        if(firstIndex == -1)
            return 0;
        int lastIndex = BinarySearch(a, b, false);
        return lastIndex - firstIndex + 1;
    }
    
    public int BinarySearch(List<Integer> a, int b, boolean searchFirst) {
        int low = 0; 
        int high = a.size() -1;
        int result = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(a.get(mid) == b) {
                result= mid;
                if(searchFirst)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else if(b < a.get(mid))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(5);
        a.add(7);
        a.add(7);
        a.add(8);
        a.add(8);
        a.add(10);
        
        System.out.println(findCount(a, 8));
    }
}