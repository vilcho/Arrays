import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Vilcho on 6/3/2017.
 */
public class Ex_p09_Altitude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayCommandsStr = scanner.nextLine().split(" ");

        double[] arrayNumbersOnly = new double[(arrayCommandsStr.length / 2) + 1];
        arrayNumbersOnly[0] = Double.parseDouble(arrayCommandsStr[0]);

        for (int i = 2; i < arrayCommandsStr.length; i = i + 2) {
            if (arrayCommandsStr[i - 1].equals("up")) {
                arrayNumbersOnly[i / 2] = Double.parseDouble(arrayCommandsStr[i]);
            } else if (arrayCommandsStr[i - 1].equals("down")) {
                arrayNumbersOnly[i / 2] = Double.parseDouble("-" + arrayCommandsStr[i]);
            }
        }

        double currentAltitude = 0.0;

        for (int i = 0; i < arrayNumbersOnly.length; i++) {
            currentAltitude += arrayNumbersOnly[i];
            if (currentAltitude <= 0){
                System.out.println("crashed");
                return;
            }
        }

        DecimalFormat df = new DecimalFormat("#########################.#############################");
        System.out.println("got through safely. current altitude: " + df.format(currentAltitude) + "m");
    }
}
