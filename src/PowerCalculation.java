import java.util.*;
public class PowerCalculation {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int exp = sc.nextInt();
        double power = Math.pow(base,exp);
        System.out.println(power);
    }
}
