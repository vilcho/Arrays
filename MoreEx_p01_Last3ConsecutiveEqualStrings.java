import java.util.Scanner;

/**
 * Created by Vilcho on 6/5/2017.
 */
public class MoreEx_p01_Last3ConsecutiveEqualStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");

        int countEquals = 1;

        String elementToCompare = array[array.length - 1];

        for (int i = array.length - 2; i >= 0; i--) {
            if (elementToCompare.equals(array[i])) {
                countEquals++;
                elementToCompare = array[i];
                if (countEquals == 3) {
                    System.out.println(array[i] + " " + array[i + 1] + " " + array[i + 2]);
                    return;
                }
            } else {
                countEquals = 1;
                elementToCompare = array[i];
            }
        }
    }
}
