
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by Vilcho on 5/27/2017.
 */
public class Lab_p02_MultiplyAnArrayOfDoubles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String someDoublesInString = scanner.nextLine();
        double p = Double.parseDouble(scanner.nextLine());

        String[] arrayElements = someDoublesInString.split(" ");

        double[] theSameArrayAsDoubles = new double[arrayElements.length];

        double [] result = new double[arrayElements.length];

        for (int i = 0; i < arrayElements.length; i++) {
            theSameArrayAsDoubles[i] = Double.parseDouble(arrayElements[i]);
            result [i] = theSameArrayAsDoubles[i]*p;
        }
        NumberFormat myFormatter = new DecimalFormat("############.##########");

        for (int i = 0; i < result.length; i++) {
           System.out.print(myFormatter.format(result[i]) + " ");
        }



    }
}
