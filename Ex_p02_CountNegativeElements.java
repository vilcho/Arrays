import java.util.Scanner;

/**
 * Created by Vilcho on 5/31/2017.
 */
public class Ex_p02_CountNegativeElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] arrayInt = new int[n];

        int countNegative = 0;

        for (int i = 0; i < n; i++) {
            arrayInt[i] = Integer.parseInt(scanner.nextLine());
            if (arrayInt[i] < 0){
                countNegative ++;
            }
        }
        System.out.println(countNegative);
    }
}
