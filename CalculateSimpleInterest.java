import java.util.Scanner;
public class CalculateSimpleInterest {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        float r = sc.nextFloat();
        float t = sc.nextFloat();
        double si = (p*r*t)/100;
        System.out.println(si);
    }
}
