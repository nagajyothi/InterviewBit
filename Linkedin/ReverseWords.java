public class ReverseWords {
    public String reverseWords(String A) {
        
        // take string into character array
        char [] array = A.toCharArray();
        int i;
        int n = A.length();
        
        for (i = 0; i < n; i++) {
            //Remove the spaces in beginning
            while (i < n && array[i] == ' ')
                i++;
            int start = i;
            int end = -1;
            
            //take a word which is until u find a space character.
            while (i < n && array[i] != ' ')
                i++;
            end = i - 1;
            if (end < start)
                break;
            
            //reverse the word
            reverse(array, start, end);
        }
        System.out.println("Before reversing the array :");
         System.out.print("\t '");
        for(int j = 0; j < n; j++)
            System.out.print(array[j]);
        System.out.println("'");
        
        reverse(array, 0, n - 1);
        
        
        System.out.println("After reversing the array :");
        System.out.print("\t '");
        for(int j = 0; j < n; j++)
            System.out.print(array[j]);
        System.out.println("'");
        
        return removeExtraSpaces(array);
    }
    
    public String removeExtraSpaces(char [] array) {
        int n = array.length;
        int index = 0;
        boolean cond = false;
        
        for (int i = 0; i < n;) {
            
            if (array[i] != ' ') {
                array[index] = array[i];
                index++;
                cond = true;
            } else {
                if (cond)
                    array[index++] = ' ';
                cond = false;
            }
            
            i++;
        }
        System.out.println("Extraspaces :");
        System.out.print("\t '");
        for(int i = 0; i < n; i++)
            System.out.print(array[i]);
        System.out.println("'");
        
        if (index - 1 >= 0 && index - 1 < n && array[index - 1] == ' ')
            index--;
        System.out.println("index :" + index);
        return new String(array, 0, index);
        
    }
    
    
    public void reverse(char [] array, int start, int end) {
        char temp;
        int i;
        
        for (i = 0; i < (end - start + 1) / 2; i++) {
            temp = array[start + i];
            array[start + i] = array[end - i];
            array[end - i] = temp;
        }
        
    }
    
    public static void main(String[] args){
        String a = "   the sky is blue  ";
        ReverseWords rw = new ReverseWords();
        System.out.println(rw.reverseWords(a));
        
    }
    
}
