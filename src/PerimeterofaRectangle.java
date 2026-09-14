import java.util.Scanner;
public class PerimeterofaRectangle {
    static void main() {
        Scanner sc = new Scanner(System.in);
        float l = sc.nextFloat();
        float b = sc.nextFloat();
        double perimeter = 2*(l+b);
        System.out.println(perimeter);
    }
}
