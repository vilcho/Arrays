import java.util.Scanner;

/**
 * Created by Vilcho on 6/3/2017.
 */
public class Ex_p10_BallisticsTraining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] targetStr = scanner.nextLine().split(" ");

        String[] commandsStr = scanner.nextLine().split(" "); // right 18 down 6 left -7 up 3

        int[] targetCoordinates = new int[targetStr.length];
        for (int i = 0; i < targetStr.length; i++) {
            targetCoordinates[i] = Integer.parseInt(targetStr[i]);
        }

        //int[] commands = new int[commandsStr.length];
        int[] xAndY = {0, 0};

        for (int i = 1; i < commandsStr.length; i = i + 2) {
            if (commandsStr[i - 1].equals("up")) {
                xAndY[1] += Integer.parseInt(commandsStr[i]);
            } else if (commandsStr[i - 1].equals("down")) {
                if (Integer.parseInt(commandsStr[i]) < 0) {
                    xAndY[1] += Math.abs(Integer.parseInt(commandsStr[i]));
                } else {
                    xAndY[1] -= Integer.parseInt(commandsStr[i]);
                }
            } else if (commandsStr[i - 1].equals("left")) {
                if (Integer.parseInt(commandsStr[i]) < 0) {
                    xAndY[0] += Math.abs(Integer.parseInt(commandsStr[i]));
                } else {
                    xAndY[0] -= Integer.parseInt(commandsStr[i]);
                }
            } else if (commandsStr[i - 1].equals("right")) {
                xAndY[0] += Integer.parseInt(commandsStr[i]);
            }
        }
        System.out.println("firing at [" + xAndY[0] + ", " + xAndY[1] + "]");

        if (xAndY[0] == targetCoordinates[0] && xAndY[1] == targetCoordinates[1]) {
            System.out.println("got 'em!");
        } else {
            System.out.println("better luck next time...");
        }
    }
}
