import java.util.Scanner;

/**
 * Created by Vilcho on 5/27/2017.
 */
public class Lab_p06_OddNumbersAtOddPositions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] stringArray = scanner.nextLine().split(" ");

        int[] array = new int[stringArray.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }

        for (int i = 0; i < array.length; i++) {
            if ((i % 2 != 0) && (array[i] % 2 != 0)) {
                System.out.print("Index " + i + " -> " + array[i]);
                System.out.println();
            }
        }
    }
}
