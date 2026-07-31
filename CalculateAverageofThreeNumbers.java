import java.util.Scanner;
public class CalculateAverageofThreeNumbers {
    static void main() {
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        float c = sc.nextFloat();
        double avg = (a+b+c)/3;
        System.out.println(avg);
    }
}
