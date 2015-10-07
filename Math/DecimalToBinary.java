public class DecimalToBinary {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        StringBuilder sb = new StringBuilder();
        while(a > 0) {
            sb = sb.insert(0, String.valueOf(a%2));
            a = a/2;
        }
        System.out.println(sb.toString());
    }
}