public class Merge{
    private static Comparable[] aux;
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        
        int mid = lo + (hi-lo)/2;        
        sort(a, lo, mid);
        sort(a, mid+1, hi);      
        merge(a, lo, mid, hi);
        show(a);
    }
    
    public static void merge(Comparable[] a, int lo,int mid, int hi){
        System.out.printf("merge(a, %d, %d, %d)\t",lo, mid, hi); 
        int i = lo;
        int j = mid+1;
        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];
        //show(aux);
        for(int k = lo; k <= hi; k++)
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux[j],aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];           
    }
    
    
    public static boolean isSorted(Comparable[] a){
        int N = a.length;
        for(int i = 1; i < N; i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }
    
    public static void show(Comparable[] a){
        int N = a.length;
        for(int i = 0; i < N; i++)
            System.out.print(a[i]+ " ");
        System.out.println();
    }
    
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    
        private static boolean lessOrEqual(Comparable v, Comparable w){
        return v.compareTo(w) < 0 || v.compareTo(w) == 0;
    }
    
    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    public static void exercise2_2_8(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        
        int mid = lo + (hi-lo)/2;        
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        if(!(lessOrEqual(a[mid],a[mid+1])) && ((mid+1) <= hi)){     
            merge(a, lo, mid, hi);
        }
        
    }
    
    public static void main(String[] args){
        String[] a = In.readStrings();
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
//        exercise2_2_8(a, 0, a.length-1);
//        Double[] a = new Double[39];
//        for(int i = 0; i < 39; i++){
//            a[i] = StdRandom.uniform();
//        }
//        sort(a);
    }
}

/*
 * Exercise2.2.1
 * C:\Users\ngunti\algs4\Sorting\MergeSort>java-algs4 Merge<221.txt
 A E Q S U Y E I N O S T
 merge(a, 0, 0, 1)       A E Q S U Y E I N O S T
 merge(a, 0, 1, 2)       A E Q S U Y E I N O S T
 merge(a, 3, 3, 4)       A E Q S U Y E I N O S T
 merge(a, 3, 4, 5)       A E Q S U Y E I N O S T
 merge(a, 0, 2, 5)       A E Q S U Y E I N O S T
 merge(a, 6, 6, 7)       A E Q S U Y E I N O S T
 merge(a, 6, 7, 8)       A E Q S U Y E I N O S T
 merge(a, 9, 9, 10)      A E Q S U Y E I N O S T
 merge(a, 9, 10, 11)     A E Q S U Y E I N O S T
 merge(a, 6, 8, 11)      A E Q S U Y E I N O S T
 merge(a, 0, 5, 11)      A E E Q I N O S U Y S T
 A E E Q I N O S U Y S T
 
 Exercise 2.2.2
 C:\Users\ngunti\algs4\Sorting\MergeSort>java-algs4 Merge<222.txt
 E A S Y Q U E S T I O N
 merge(a, 0, 0, 1)       A E S Y Q U E S T I O N
 merge(a, 0, 1, 2)       A E S Y Q U E S T I O N
 merge(a, 3, 3, 4)       A E S Q Y U E S T I O N
 merge(a, 3, 4, 5)       A E S Q U Y E S T I O N
 merge(a, 0, 2, 5)       A E Q S U Y E S T I O N
 merge(a, 6, 6, 7)       A E Q S U Y E S T I O N
 merge(a, 6, 7, 8)       A E Q S U Y E S T I O N
 merge(a, 9, 9, 10)      A E Q S U Y E S T I O N
 merge(a, 9, 10, 11)     A E Q S U Y E S T I N O
 merge(a, 6, 8, 11)      A E Q S U Y E I S N O T
 merge(a, 0, 5, 11)      A E E Q I S U S N O Y T
 A E E Q I S U S N O Y T
 
 
 Exercise 2.2.5
 C:\Users\ngunti\algs4\Sorting\MergeSort>java-algs4 Merge
 merge(a, 0, 0, 1)
 merge(a, 0, 1, 2)
 merge(a, 3, 3, 4)
 merge(a, 0, 2, 4)
 merge(a, 5, 5, 6)
 merge(a, 5, 6, 7)
 merge(a, 8, 8, 9)
 merge(a, 5, 7, 9)
 merge(a, 0, 4, 9)
 merge(a, 10, 10, 11)
 merge(a, 10, 11, 12)
 merge(a, 13, 13, 14)
 merge(a, 10, 12, 14)
 merge(a, 15, 15, 16)
 merge(a, 15, 16, 17)
 merge(a, 18, 18, 19)
 merge(a, 15, 17, 19)
 merge(a, 10, 14, 19)
 merge(a, 0, 9, 19)
 merge(a, 20, 20, 21)
 merge(a, 20, 21, 22)
 merge(a, 23, 23, 24)
 merge(a, 20, 22, 24)
 merge(a, 25, 25, 26)
 merge(a, 25, 26, 27)
 merge(a, 28, 28, 29)
 merge(a, 25, 27, 29)
 merge(a, 20, 24, 29)
 merge(a, 30, 30, 31)
 merge(a, 30, 31, 32)
 merge(a, 33, 33, 34)
 merge(a, 30, 32, 34)
 merge(a, 35, 35, 36)
 merge(a, 37, 37, 38)
 merge(a, 35, 36, 38)
 merge(a, 30, 34, 38)
 merge(a, 20, 29, 38)
 merge(a, 0, 19, 38)
 
 */