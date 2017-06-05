import java.util.Scanner;

/**
 * Created by Vilcho on 6/2/2017.
 */
public class Ex_p07_CountOfCapitalLettersInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");

        int countSingleCharactersInArray = 0;

        for (String anArray : array) {

            if ((anArray.length()) == 1 && anArray.equals(anArray.toUpperCase())) {
                countSingleCharactersInArray++;
            }
        }
        System.out.println(countSingleCharactersInArray);

    }
}
