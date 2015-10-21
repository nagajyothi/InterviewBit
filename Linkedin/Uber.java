public class Uber {
    public static double distance(double x1, double y1, double x2, double y2) {
        double total = 0.0;
        if(Math.ceil(x1) != x1) {
            total += Math.ceil(x1) - x1;
        }
        if(Math.ceil(x2) != x2) {
            total += Math.ceil(x2) - x2;
        }
        
        if(Math.ceil(y1) != y1) {
            total += Math.ceil(y1) - y1;
        }
        if(Math.ceil(y2) != y2) {
            total += Math.ceil(y2) - y2;
        }
        
        return total;
    }
    public static void main(String[] args) {
        
        System.out.println(distance(0.4, 1, 0.9, 3));
    }
}