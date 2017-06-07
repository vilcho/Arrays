import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Vilcho on 6/6/2017.
 */
public class MoreEx_p04_Phone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = "";
        String phoneNum = "";

        String phonebook = phonebook(name, phoneNum);

        String[] actionCommand = scanner.nextLine().split(" ");

        String calling = "";
        String callingResult = "";
        String callingNameAndNum = "";
        String allAboutCallToPrint = "";

        switch (actionCommand[0]) {
            case "call":
                callingNameAndNum = callingDetails(actionCommand, phonebook);
                calling = callingWho(callingNameAndNum, actionCommand);
                callingResult = whatHappenedToCall(callingNameAndNum);
                allAboutCallToPrint = calling + callingResult;
                break;

//            case "message":
////            } else if (actionCommand[0].equals("message")) {
//                if (actionCommand[1].equals(nameAndNum[1])) {
//                    output += "sending sms to " + nameAndNum[0] + "...";
//                } else if (actionCommand[1].equals(nameAndNum[0])) {
//                    output += "sending sms to " + nameAndNum[1] + "...";
//                }

        }
        System.out.println(allAboutCallToPrint);
    }


    static String whatHappenedToCall(String callingNameAndNum) {
        String whatHappenedToCall = "";

        String[] callingNameAndNumArray = callingNameAndNum.split(" -> ");

        String phoneNumberString = callingNameAndNumArray[1];
        //String phoneNumOthersReplacedWithZeros = "";

        char[] phoneNumberChar = phoneNumberString.toCharArray();
        for (int i = 0; i < phoneNumberChar.length; i++) {
            if (phoneNumberChar[i] < 48 || phoneNumberChar[i] > 57) {
                phoneNumberChar[i] = '0';
            }
           // phoneNumOthersReplacedWithZeros += phoneNumberChar[i];
        }

        int[] phoneNumCleanedInt = new int[phoneNumberChar.length];
        int sumPhoneDigits = 0;
        for (int i = 0; i < phoneNumCleanedInt.length; i++) {
            phoneNumCleanedInt[i]= Integer.parseInt(String.valueOf(phoneNumberChar[i]));
            sumPhoneDigits += phoneNumCleanedInt[i];
        }
//        int durationMM = sumPhoneDigits % 60;
//        int durationHH = sumPhoneDigits / 60;
        double duration = (double) sumPhoneDigits / 60;
        DecimalFormat df = new DecimalFormat("##:##");
        String durationStr = df.format(duration);

        if (sumPhoneDigits % 2 == 0){
            whatHappenedToCall = "call ended. duration: " + durationStr;
        } else {
            whatHappenedToCall = "no answer";
        }
        return whatHappenedToCall;
    }


    static String callingWho(String callingNameAndNum, String[] actionCommand) {

        String calling = "";

        String[] nameAndNum = callingNameAndNum.split(" -> ");

        if (actionCommand[1].equals(nameAndNum[1])) {
            calling += "calling " + nameAndNum[0] + "...";
        } else if (actionCommand[1].equals(nameAndNum[0])) {
            calling += "calling " + nameAndNum[1] + "..." + System.lineSeparator();
        }
        return calling;
    }

    static String callingDetails(String[] actionCommand, String phonebook) {

        String callingDetails = "";

        String[] phonebookStr = phonebook.split(System.lineSeparator());

        for (int i = 0; i < phonebookStr.length; i++) {
            String[] nameAndNum = phonebookStr[i].split(" -> ");

            if (actionCommand[1].equals(nameAndNum[1])) {
                callingDetails = phonebookStr[i];
            } else if (actionCommand[1].equals(nameAndNum[0])) {
                callingDetails = phonebookStr[i];
            }
        }
        return callingDetails;
    }


    static String phonebook(String name, String phoneNumber) {
        Scanner scanner = new Scanner(System.in);

        String[] phonesString = scanner.nextLine().split(" "); //0888888888 0888123456 +359886001122
        String[] namesString = scanner.nextLine().split(" "); //Nakov Ivan Maria

        String phonebook = "";

//        while (!(name.equals("done"))) {
//            name = scanner.nextLine();
        for (int i = 0; i < namesString.length; i++) {
//                if (name.equals(namesString[i])) {
            phonebook += namesString[i] + " -> " + phonesString[i] + System.lineSeparator();
//                }
        }
        return phonebook;
    }
}
