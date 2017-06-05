import java.util.Scanner;

/**
 * Created by Vilcho on 6/2/2017.
 */
public class Ex_p06_EqualSequenceOfElementsInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringArray = scanner.nextLine().split(" ");

        int[] array = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }

        for (int i = 1; i < array.length; i++) {
            if (!(array[i] == array[i-1])){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
