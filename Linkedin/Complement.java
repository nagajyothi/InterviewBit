public class Complement{
    public static int getIntComplement(int n){
        int complement = 0;
        int remainder = 0;
        int count = 0;
        if(n == 1)
            return 0;
        if(n == 0)
            return 1;
        while(n > 1){
            remainder = n % 2;
            n = n >> 1;
            System.out.println("For  n = " +  n);
            System.out.println("\t remainder = " + remainder);
            System.out.println("\t Count = " + count);
            if(remainder == 0)
                complement = (int)(complement  + Math.pow(2, count));
            count++;
            System.out.println("\t Complement " + complement);
        }
        if(n == 0){
            System.out.println("Complement for n = " +  n + " is " + complement);
            complement = (int)(complement + Math.pow(2, count));
        }
        return complement;
    }
    public static void main(String[] args){
        
        System.out.println(getIntComplement(Integer.parseInt(args[0])));
        
    }
}