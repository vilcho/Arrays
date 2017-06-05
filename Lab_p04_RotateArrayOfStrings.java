import java.util.Scanner;

/**
 * Created by Vilcho on 5/27/2017.
 */
public class Lab_p04_RotateArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");

        String[] secondArray = new String[array.length];
        for (int i = 0; i < (secondArray.length - 1); i++) {
            secondArray[i+1] = array[i];
        }
        secondArray[0] = array[array.length - 1];

        System.out.println(String.join(" ", secondArray));

    }
}
