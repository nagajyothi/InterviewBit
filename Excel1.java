public class Excel1{
    public static int titleToNumber(String A){
        if(A == null || A.length() == 0){
            return 0;
        }
        int result = 0;
        int i = A.length() - 1;
        int t = 0;
        while(i >= 0) {
            char c = A.charAt(i);
            result = result +(int)Math.pow(26, t) * (c - 'A' + 1);
            //System.out.println(result);
            t++;
            i--;
        }
        return result;
    }
    
    public static String titleToString(int N){
        StringBuffer sb = new StringBuffer();
        if(N <= 0)
            return null;
        int i = 0;
        while(N > 0) {
            int rem = N % 26;
            if(rem == 0) {
                rem = 26;
            }
            sb.insert(0, (char)('A' + rem -1));
            if(rem == 26)
                N = N/26 - 1;
            else
                N = N/26;
        }
        return sb.toString();
    }
    
    public static String convertToTitle(int n) {
        StringBuilder ans= new StringBuilder();
        while(n > 0) {
            ans.insert(0, (char)((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return ans.toString();
    }
    
    public static void main(String[] args){
        System.out.println(titleToNumber(args[0]));
        System.out.println(titleToString(titleToNumber(args[0])));
        System.out.println(convertToTitle(titleToNumber(args[0])));
    }
}