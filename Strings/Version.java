/*
 * Compare two version numbers version1 and version2.
 * 
 If version1 > version2 return 1,
 If version1 < version2 return -1,
 otherwise return 0.
 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 
 Here is an example of version numbers ordering:
 
 0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Version{
    public static int compareVersion(String a, String b) {
        //System.out.print(a + " " + b);
        String[] aSplit = a.split("\\.");
        String[] bSplit = b.split("\\.");
//        for(int i = 0; i < aSplit.length; i++)
//            System.out.print(aSplit[i] + " ");
//        System.out.println();
//        for(int i = 0; i < bSplit.length; i++)
//            System.out.print(bSplit[i] + " ");
//        System.out.println();
        
        int i = 0;
        int j = 0;
        while(i < aSplit.length && j < bSplit.length){
            if(Integer.parseInt(aSplit[i]) > Integer.parseInt(bSplit[j]))
                return 1;
            else if(Integer.parseInt(aSplit[i]) < Integer.parseInt(bSplit[j]))
                return -1;
            else {
                //check next
                i++;
                j++;
            }
        }
        if(i == aSplit.length && j == bSplit.length) return 0;
        else if(i < aSplit.length) return 1;
        else if(j < bSplit.length) return -1;
        return 0;          
    }
    //Better
    public int compareVersionBetter(String a, String b) {
        String[] arr1 = a.split("\\.");
        String[] arr2 = b.split("\\.");
        
        int i=0;
        while(i<arr1.length || i<arr2.length){
            if(i<arr1.length && i<arr2.length){
                if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])){
                    return -1;
                }else if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])){
                    return 1;
                }
            } else if(i<arr1.length){
                if(Integer.parseInt(arr1[i]) != 0){
                    return 1;
                }
            } else if(i<arr2.length){
                if(Integer.parseInt(arr2[i]) != 0){
                    return -1;
                }
            }
            
            i++;
        }
        
        return 0;
    }
    
    public static int compareVersionString(String a, String b) {
        String[] arr1 = a.split("\\.");
        String[] arr2 = b.split("\\.");
        
        int i=0;
        while(i<arr1.length || i<arr2.length){
            if(i<arr1.length && i<arr2.length){
                if(arr1[i].compareTo(arr2[i]) < 0){
                    return -1;
                }else if(arr1[i].compareTo(arr2[i]) > 0){
                    return 1;
                }
            } else if(i<arr1.length){
                if(arr1[i] != null){
                    return 1;
                }
            } else if(i<arr2.length){
                if(arr2[i] != null){
                    return -1;
                }
            }
            
            i++;
        }
        
        return 0;
    }
    
    //from solution
    public static int compareVersionSolution(String a, String b) {

    
    a = a.replaceAll ("\\b0", "");
    b = b.replaceAll ("\\b0", "");
    System.out.println(a + " " + b);
        int al = a.length();
        int bl = b.length();
        
        int l = bl;
        if(bl > al){
            l = al;
        }
        
        for(int i = 0;i < l; i++){
            if((a.charAt(i) == '.' && b.charAt(i) == '.') || a.charAt(i) == b.charAt(i))
                continue;
            if(a.charAt(i) == '.' && b.charAt(i) != '.')
                return -1;
            if(a.charAt(i) != '.' && b.charAt(i) == '.')
                return 1;
            if(a.charAt(i) > b.charAt(i))
                return 1;
            if(a.charAt(i) < b.charAt(i))
                return -1;              
        }
        if(al > bl)
            return 1;          
        if(bl > al)
            return -1;
        return 0;
    }
    public static void main(String[] args){
        String a = args[0];
        String b = args[1];
        System.out.println(compareVersionSolution(a, b));
    }
}