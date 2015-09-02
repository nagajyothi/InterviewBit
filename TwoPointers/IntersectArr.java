/*
 * Find the intersection of two sorted arrays.
 OR in other words,
 Given 2 sorted arrays, find all the elements which occur in both the arrays.
 
 Example :
 
 Input : 
 A : [1 2 3 3 4 5 6]
 B : [3 3 5]
 
 Output : [3 3 5]
 
 Input : 
 A : [1 2 3 3 4 5 6]
 B : [3 5]
 
 Output : [3 5]
 NOTE : For the purpose of this problem ( as also conveyed by the sample case ), assume that elements that appear more than once in both arrays should be included multiple times in the final output
 */
import java.util.*;
public class IntersectArr{
    public static ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> result = new  ArrayList<Integer>();
        int aN = a.size();
        int bN = b.size();        
        int j = 0;
        int i = 0;
        while(i < aN & j < bN){
            if(a.get(i) < b.get(j)){
               i++;
            }
            else if(a.get(i) > b.get(j)){
                j++;
            }
            else{
                result.add(b.get(j));
                j++;
                i++;
            }                                                
        }
        return result;
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new  ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        ArrayList<Integer> b = new  ArrayList<Integer>();
        b.add(3);
        b.add(3);
        b.add(5);
        ArrayList<Integer> result = new  ArrayList<Integer>();
        result = intersect(a, b);
        for(int i =0; i < result.size(); i++)
            System.out.print(result.get(i) + " ");
    }
}