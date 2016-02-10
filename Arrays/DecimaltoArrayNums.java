import java.util.*;
public class DecimaltoArrayNums{
    public static void main(String[] args){
        ArrayList<String> result = exp("7496314.4356");
        
            System.out.print(result );
        
    }
    public static ArrayList<String> exp(String n) {
        String[] arr= new String[2];
        if(n.contains(".")){
         arr = n.split(".");
        }
        else{
            arr[0] = n;
        }
        ArrayList<String> result = new ArrayList<String>();
        String pattern = "^\\d*.?\\d*";
        System.out.println("String matches: " + n.matches(pattern) + " " + arr[0]);
        if(!n.matches(pattern))
            return result;
        
        //System.out.println("array length: " + arr.length);
        if(arr.length > 0){
            System.out.println("entered if");
            for(int i = 0; i < arr[0].length(); i++){
                if(arr[0].charAt(i) != '0'){
                    int cal = (int)(Math.pow(10,(arr[0].length() - i-1))) * (arr[0].charAt(i)-'0');   
                    System.out.println("cal: " +  cal);
                    result.add(Integer.toString(cal));
                }
            }
            if(arr.length > 1){
                for(int j = 0; j < arr[1].length(); j++){
                    double calculate = Math.pow(0.1, j+1) * (arr[1].charAt(j)-'0');
                    System.out.println("calculate: " +  calculate);
                    result.add(Double.toString(calculate));
                }
            }
        }
        return result;
    }
    
}