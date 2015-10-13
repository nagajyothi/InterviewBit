/*
 * Given a target and a sorted array, find the element that is strictly larger than the target. 
 * {a,c,d,e} b output: c 
 */
public class StrictlyLargerTarget {
    public static int rank(char[] a, char key) {
        int n = a.length;
        int start = 0;
        int end = n -1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(a[mid] == key) {
               return mid;
            }
            if(key < a[mid]) {
                end = mid - 1;
            }
            else if(key > a[mid]) {
                start = mid + 1;
            }
                
        }
        return start;        
    }
    
    //if celing does not exist that is larger number greater than key then it returns 0
    public static char ceiling(char[] a, char key) {
        int i = rank(a, key);
        if(i == a.length) return '0';
        return a[i];
    }
    
    //returns the number below the given key
    public static char floor(char[] a, char key) {
        int i = rank(a, key);
        if(i < a.length &&
           key == a[i])
            return a[i];
        return a[i-1];
    }
    public static void main(String[] args) {
        char[] a = {'b', 'c', 'd', 'e'}; 
        System.out.println("Ceiling : " + ceiling(a, 'f'));
        System.out.println("Floor: " + floor(a, 'f'));
    }
}