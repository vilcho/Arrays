import java.util.Scanner;

/**
 * Created by Vilcho on 5/29/2017.
 */
public class Ex_p01_LargestElementInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }

        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (array[i] > largest){
                largest = array[i];
            }
        }

        System.out.println(largest);
    }
}
