import java.util.Scanner;

/**
 * Created by Vilcho on 6/2/2017.
 */
public class Ex_p04_CountOccurencesOfLargerNumbersInArr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayString = scanner.nextLine().split(" ");

        double p = Double.parseDouble(scanner.nextLine());

        int biggerThanP = 0;

        double[] array = new double[arrayString.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(arrayString[i]);
            if (array[i] > p){
                biggerThanP ++;
            }
        }
        System.out.println(biggerThanP);
    }
}
