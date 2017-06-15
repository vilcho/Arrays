import java.util.Scanner;

/**
 * Created by Vilcho on 6/15/2017.
 */
public class MoreEx_p07_ResizableArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] initialArray = new int[4];

        String command = "";

        String[] stringInitialArray = new String[initialArray.length];
        for (int i = 0; i < stringInitialArray.length; i++) {
            stringInitialArray[i] = "";
        }

        String[] extendedStringArray = new String[]{"", "", "", "", "", "", "", ""};
        command = scanner.nextLine();

        while (!command.equals("end")) {

            while (stringInitialArray != null) {
                if (command.startsWith("push") && stringInitialArray[3].equals("")) {
                    stringInitialArray = addNumberToEndOfArray(command, stringInitialArray);
                    command = scanner.nextLine();
                } else if (command.startsWith("push") && (!stringInitialArray[3].equals(""))) {
                    for (int i = 0; i < stringInitialArray.length; i++) {
                        extendedStringArray[i] = stringInitialArray[i];
                    }
                    for (int i = 5; i < extendedStringArray.length; i++) {
                        extendedStringArray[i] = "";
                    }
                    stringInitialArray = null;
                    extendedStringArray = addNumberToEndOfArray(command, extendedStringArray);
                    command = scanner.nextLine();
                } else if (command.equals("pop")) {
                    stringInitialArray = removeLastIntFromArray(command, stringInitialArray);
                } else if (command.startsWith("removeAt") && (command.charAt(9) < 49 || command.charAt(9) > 51)) {
                    stringInitialArray = removeIntAtIndex(command, stringInitialArray);
                } else if (command.equals("clear")) {
                    stringInitialArray = eraseAllContentsOfArray(command, stringInitialArray);
                }
            }
            if (stringInitialArray == null) {
                if (command.startsWith("push")) {
                    extendedStringArray = addNumberToEndOfArray(command, extendedStringArray);
                } else if (command.equals("pop")) {
                    extendedStringArray = removeLastIntFromArray(command, extendedStringArray);
                } else if (command.startsWith("removeAt")) {
                    extendedStringArray = removeIntAtIndex(command, extendedStringArray);
                } else if (command.equals("clear")) {
                    extendedStringArray = eraseAllContentsOfArray(command, extendedStringArray);
                }

            }
            command = scanner.nextLine();
        }
        if (stringInitialArray == null) {
            printFinalArray(extendedStringArray);
        } else {
            printFinalArray(stringInitialArray);
        }
    }

    static void printFinalArray(String[] stringArray) {
        //int[] intArray = new int[stringArray.length];
        String stringArrayIsEmpty = "empty array";
        for (String element : stringArray) {
            if (element.equals("")) {
                stringArrayIsEmpty += "";
            } else {
                stringArrayIsEmpty = "not empty";
            }
        }
        if (stringArrayIsEmpty.startsWith("empty array")) {
            System.out.println("empty array");
        } else {
            System.out.print(String.join(" ", stringArray));
            }
        }

        static String[] removeLastIntFromArray (String command, String[]stringArray){
            for (int i = 0; i < stringArray.length; i++) {
                if (stringArray[i].equals("")) {
                    stringArray[i - 1] = "";
                    break;
                }

            }
            return stringArray;
        }

        static String[] eraseAllContentsOfArray (String command, String[]stringArray){
            for (int i = 0; i < stringArray.length; i++) {
                stringArray[i] = "";
            }
            return stringArray;
        }

        static String[] removeIntAtIndex (String command, String[]stringArray){
            String[] arrayAfterRemoveCom = new String[stringArray.length];
            for (int i = 0; i < arrayAfterRemoveCom.length; i++) {
                arrayAfterRemoveCom[i] = stringArray[i];
            }


            String[] commandString = command.split(" ");
            String indexToRemoveElementAt = commandString[1];
            int intIndexToRemoveElementAt = Integer.parseInt(indexToRemoveElementAt);
            for (int i = 0; i < arrayAfterRemoveCom.length; i++) {
                if (i == intIndexToRemoveElementAt) {
                    arrayAfterRemoveCom[i] = "";
                }
            }
            for (int i = 0; i < arrayAfterRemoveCom.length - 1; i++) {
                if (arrayAfterRemoveCom[i].equals("")) {
                    arrayAfterRemoveCom[i] = arrayAfterRemoveCom[i + 1];
                    arrayAfterRemoveCom[i+1] = "";
                }
            }
            return arrayAfterRemoveCom;
        }


        static String[] addNumberToEndOfArray (String command, String[]stringArray){
            String[] commandString = command.split(" ");
            String numberFromCommandPush = commandString[commandString.length - 1];

            for (int i = 0; i < stringArray.length; i++) {
                if (stringArray[i].equals("")) {
                    stringArray[i] = numberFromCommandPush;
                    break;
                }
            }
            return stringArray;
        }
    }
