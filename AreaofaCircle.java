import java.util.*;
public class AreaofaCircle {
    static void main() {
        Scanner sc = new Scanner(System.in);
        float rad = sc.nextFloat();
        double area = Math.PI * rad * rad;
        System.out.println(area);
    }
}
