import java.util.Scanner;

/**
 * Created by Vilcho on 6/2/2017.
 */
public class Ex_p08_ArraySymmetry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayOfStrings = scanner.nextLine().split(" ");

//        for (int i = 0; i < arrayOfStrings.length / 2; i++) {
//            if (!(arrayOfStrings[i].equals(arrayOfStrings[arrayOfStrings.length - 1 - i]))) {
//                System.out.println("No");
//                return;
//            }
//        }
//        System.out.println("Yes");

        String[] inversedArray = new String[arrayOfStrings.length];

        for (int i = 0; i < inversedArray.length; i++) {
            inversedArray[i] = arrayOfStrings[arrayOfStrings.length - 1 - i];
        }
        for (int i = 0; i < inversedArray.length; i++) {
            if (!(inversedArray[i].equals(arrayOfStrings[i]))){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
