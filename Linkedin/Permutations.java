//Permutations of a given string n! permutations possible
import java.util.*;
public class Permutations {
    public ArrayList<String> permute(String s) {
        String prefix = "";
        ArrayList<String> result = new ArrayList<String>();
        permuteHelper(prefix, s, result);
        System.out.println(result.size());
        return result;
    }
    
    public void permuteHelper(String prefix, String s,  ArrayList<String> result) {
        System.out.println("For s = " +  s);
        if(s.length() == 0) {
            System.out.println("\t Adding to result " +  prefix);
            result.add(prefix);
        }
        
        for(int i =0; i < s.length(); i++) {
            System.out.println("\t next prefix : "+ prefix + s.charAt(i));
            System.out.println("\t next string : "+s.substring(0, i) + s.substring(i+1, s.length()));
            permuteHelper(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, s.length()), result);
        }                        
    }
    public static void main(String[] args){
        Permutations p = new Permutations();
        System.out.println(p.permute(args[0]));
    }
}