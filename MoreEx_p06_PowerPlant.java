import java.util.Scanner;

/**
 * Created by Vilcho on 6/11/2017.
 */
public class MoreEx_p06_PowerPlant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] powerLevelString = scanner.nextLine().split(" ");

        int[] powerLevel = new int[powerLevelString.length];
        for (int i = 0; i < powerLevel.length; i++) {
            powerLevel[i] = Integer.parseInt(powerLevelString[i]);
        }

        int daysSurvived = 0;
        int seasonCount = 0;
        int sumOfAllElements = 0;

        sumOfAllElements = powerLevelElemtsAreDead(powerLevel);

        while (sumOfAllElements != 0) {

            for (int i = 0; i < powerLevel.length; i++) {
                if (powerLevel[i] != 0) {
                    powerLevel[i]++;
                }
                powerLevel = decreasePowerLevel(powerLevel);

                daysSurvived++;

                //ako wsichki elementi w array powerLevel==0, break. napravi si metod za tova.
                sumOfAllElements = powerLevelElemtsAreDead(powerLevel);
                if (sumOfAllElements == 0) {
                break;
                }

                if (daysSurvived % powerLevel.length == 0) {
                    seasonCount++;
                    sumOfAllElements = 0;
                    for (int j = 0; j < powerLevel.length; j++) {
                        if (powerLevel[j] > 0) {
                            powerLevel[j]++;
                            sumOfAllElements += powerLevel[j];
                        }
                        // i = -1;
                    }

                }
            }
        }

            System.out.println("survived " + daysSurvived + " days (" + seasonCount + " seasons)");
        }


    static int powerLevelElemtsAreDead(int[] powerLevel) {
        int sumOfAllElements = 0;
        for (int i = 0; i < powerLevel.length; i++) {
            sumOfAllElements += powerLevel[i];
        }
        return sumOfAllElements;
    }

    static int[] decreasePowerLevel(int[] powerLevel) {
        int[] powerLevelNextDay = new int[powerLevel.length];
        for (int i = 0; i < powerLevelNextDay.length; i++) {
            powerLevelNextDay[i] = powerLevel[i] - 1;
            if (powerLevelNextDay[i] < 0) {
                powerLevelNextDay[i] = 0;
            }
        }
        return powerLevelNextDay;
    }
}
