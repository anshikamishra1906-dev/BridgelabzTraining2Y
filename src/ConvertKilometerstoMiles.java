import java.util.Scanner;
public class ConvertKilometerstoMiles {
    static void main() {
        Scanner sc = new Scanner(System.in);
        float km = sc.nextFloat();
        double miles = km * 0.621371;
        System.out.println(miles);
    }
}
