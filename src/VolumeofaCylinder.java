import java.util.Scanner;
public class VolumeofaCylinder {
    static void main() {
        Scanner sc = new Scanner(System.in);
        float r = sc.nextFloat();
        float h = sc.nextFloat();
        double vol = Math.PI* r* r* h;
        System.out.println(vol);
    }
}
