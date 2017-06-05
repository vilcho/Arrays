import java.util.Scanner;

/**
 * Created by Vilcho on 5/31/2017.
 */
public class Ex_p03_CountGivenElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayStr = scanner.nextLine().split(" ");

        int[] arrayInt = new int[arrayStr.length];

        for (int i = 0; i < arrayStr.length; i++) {
            arrayInt[i] = Integer.parseInt(arrayStr[i]);
        }

        int element = Integer.parseInt(scanner.nextLine());

        int occurence = 0;

        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] == element){
                occurence ++;
            }
        }
        System.out.println(occurence);
    }
}
