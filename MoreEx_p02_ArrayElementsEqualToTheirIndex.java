import java.util.Scanner;

/**
 * Created by Vilcho on 6/5/2017.
 */
public class MoreEx_p02_ArrayElementsEqualToTheirIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayString = scanner.nextLine().split(" ");

        int[] arrayInt = new int[arrayString.length];

        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = Integer.parseInt(arrayString[i]);
            if (i == arrayInt[i]){
                System.out.print(arrayInt[i] + " ");
            }
        }
    }
}
