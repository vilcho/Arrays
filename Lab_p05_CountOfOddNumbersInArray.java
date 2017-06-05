import java.util.Scanner;

/**
 * Created by Vilcho on 5/27/2017.
 */
public class Lab_p05_CountOfOddNumbersInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringArr = scanner.nextLine().split(" ");

        int[] array = new int[stringArr.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(stringArr[i]);
        }

        int oddCounter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0){
                oddCounter++;
            }
        }
        System.out.println(oddCounter);
    }
}
