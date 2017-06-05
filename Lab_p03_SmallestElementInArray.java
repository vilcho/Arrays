import java.util.Scanner;

/**
 * Created by Vilcho on 5/27/2017.
 */
public class Lab_p03_SmallestElementInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");

        int[] intArray = new int[array.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }

        int smallestElementInIntArray = Integer.MAX_VALUE;

        for (int eachIntArrayElement : intArray) {
            if (eachIntArrayElement < smallestElementInIntArray) {
                smallestElementInIntArray = eachIntArrayElement;
            }
        }
        System.out.println(smallestElementInIntArray);

    }
}
