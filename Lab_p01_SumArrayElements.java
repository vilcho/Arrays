import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.util.Scanner;

/**
 * Created by Vilcho on 5/27/2017.
 */
public class Lab_p01_SumArrayElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += array[i];
        }
        System.out.println(sum);
    }
}
