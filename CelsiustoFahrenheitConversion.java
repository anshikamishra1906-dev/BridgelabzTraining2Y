import java.util.Scanner;
public class CelsiustoFahrenheitConversion {
    static void main() {
        Scanner sc = new Scanner(System.in);
        float Celsius = sc.nextFloat();
        double Fahrenheit = (Celsius * 9.0/5) + 32;
        System.out.println(Fahrenheit);
    }
}
