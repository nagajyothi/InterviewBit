/*
 * Find shortest unique prefix to represent each word in the list.
 * 
 Example:
 
 Input: [zebra, dog, duck, dove]
 Output: {z, dog, du, dov}
 where we can see that
 zebra = z
 dog = dog
 duck = du
 dove = dov
 NOTE : Assume that no word is prefix of another. In other words, the representation is always possible.
 */
import java.util.*;
public class Prefix{
//    public static ArrayList<String> prefix(ArrayList<String> a) {
//        ArrayList<String> result = new ArrayList<String>(a);
//        //String[] result = new String[a.size()];
//        for(int i = 0; i < result.size(); i++){
//            if(i > 0){
//                if(a.get(i).matches(a.get(i-1))){
//                    continue;
//                }
//            }
//            result.set(i, Character.toString(a.get(i).charAt(0)));
//            checkPrefix(a, result, result.get(i), i);
//        }
//        return result;
//        
//    }
//    public static void checkPrefix(ArrayList<String> a, ArrayList<String> result, String s, int index){
//        for(int i = index - 1; i >= 0; i--){
//            if(s.matches(result.get(i))){
//                if(s.length() == a.get(i).length()){
//                    result.set(index, a.get(index).substring(0, s.length() + 1));
//                    checkPrefix(a, result, result.get(index), index);
//                    return;
//                }
//                else if(s.length() < a.get(i).length()){
//                    result.set(i, a.get(i).substring(0, s.length() + 1));
//                    checkPrefix(a, result, result.get(i), i);
//                    return;
//                }
//            }
//        }
//    }
    
    public static ArrayList<String> prefix(ArrayList<String> a) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(String s : a){
            for(int i = 0; i < s.length(); i++){
                if(map.containsKey(s.charAt(i)))
                    map.put(s.charAt(i), map.get(s.charAt(i))+1);
                else
                    map.put(s.charAt(i),1);
            }
            
            String pre = "";
            int j = 0;
            for(j = 0; j < s.length(); ++j){
                if(map.get(s.charAt(j)) > 1)
                    pre = pre + s.charAt(j);
                else
                    break;
            }
            if(j < s.length())
                pre = pre + s.charAt(j);
            result.add(pre);
        }
        
        
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            //it.remove(); // avoids a ConcurrentModificationException
        }
        
//        for(String s : a){
//            String pre = "";
//            int i = 0;
//            for(i = 0; i < s.length(); ++i){
//                if(map.get(s.charAt(i)) > 1)
//                    pre = pre + s.charAt(i);
//                else
//                    break;
//            }
//            if(i < s.length())
//                pre = pre + s.charAt(i);
//            result.add(pre);
//        }
        
        return result;
        
        
    }
    public static ArrayList<String> prefixEfficient(ArrayList<String> a) {
         ArrayList<String> result = new ArrayList<String>();
        HashMap<String, String> validSubs = new HashMap<String, String>();
        HashSet<String> usedSubs = new HashSet<String>();
        
        for (String option : a) {
            for(int i = 0; i <= option.length(); i++) {
                String sub = option.substring(0, i);
                if(usedSubs.contains(sub)) {
                    validSubs.remove(sub);
                } else {
                    validSubs.put(sub, option);
                    usedSubs.add(sub);
                }
            }
        }
        
        Iterator it = validSubs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            //it.remove(); // avoids a ConcurrentModificationException
        }
        
//        for(String s: a){
//            if(validSubs.containsKey(s))
//                result.add(validSubs.get(s));
//        }
        return result;
    }
    
    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<String>();
        a.add("bearcat");
        a.add("bert");
//        a.add("duck");
//        a.add("dove");
        ArrayList<String> result = prefixEfficient(a);
        System.out.println(a);
        System.out.println(result);
    }
}