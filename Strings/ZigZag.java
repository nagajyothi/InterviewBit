/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * 
 P.......A........H.......N
 ..A..P....L....S....I...I....G
 ....Y.........I........R
 And then read line by line: PAHNAPLSIIGYIR
 Write the code that will take a string and make this conversion given a number of rows:
 
 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 **Example 2 : **
 ABCD, 2 can be written as
 
 A....C
 ...B....D
 and hence the answer would be ACBD.
 
 http://n00tc0d3r.blogspot.com/2013/06/zigzag-conversion.html 
 Some useful properties:
 For any full columns, the odd ones have nRows characters, even ones have (nRows - 2) characters.
 For the first and last rows, we read one single character from each expended column;
 For the rest of rows, we read two characters, one from top part and one from bottom part, from each expended column.
 One edge case is that nRows = 1, where (nRows*2 - 2) becomes 0. In this case, we should simply return the original string.
 */
public class ZigZag{
    public static String convert(String a, int b) {
        if(b == 1)
            return a;
        StringBuilder result = new StringBuilder();
        int n = b + b - 2;
        for(int i = 0; i < b; i++){
            int cur = i;
            while(cur < a.length()){
                result.append(a.charAt(cur));
                cur += n;
                if(i > 0 && i < b - 1 && (cur-i-i) < a.length()){
                    result.append(a.charAt(cur - i - i));
                }
            }
        }
        return result.toString();
    }
    public static void main(String[] args){
        String a = "ABCD";
        int b = 2;
        System.out.println(convert(a, b));
    }
}
