//import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Vilcho on 6/6/2017.
 */
public class MoreEx_p04_Phone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phonesString = scanner.nextLine().split(" "); 
        //String[] phonesString = {"0888888888", "0888123456", "+359886001122"};
        String[] namesString = scanner.nextLine().split(" "); 
        //String[] namesString = {"Nakov", "Ivan", "Maria"};

        String phonebook = phonebook(phonesString, namesString);

        String allResultsToPrint = "";
        
        String action = "";

        while (!(action.equals("done"))) {
        action = scanner.nextLine();
        String[] actionCommand = action.split(" ");
        //String[] actionCommand = {"call", "0888888888"}; 

        String calling = "";
        String callingResult = "";
        String usingPhonebookEntry = "";
        String allAboutCallToPrint = "";
        String messaging = "";
        String messagingResult ="";
        String allAboutMessageToPrint = "";

        switch (actionCommand[0]) {
            case "call":
                usingPhonebookEntry = callingDetails(actionCommand, phonebook);
                calling = callingWho(usingPhonebookEntry, actionCommand);
                callingResult = whatHappenedToCall(usingPhonebookEntry);
                allAboutCallToPrint = calling + callingResult;
                allResultsToPrint += allAboutCallToPrint;
                break;

            case "message":
                usingPhonebookEntry = callingDetails(actionCommand, phonebook);
                messaging = messagingWho(usingPhonebookEntry, actionCommand);
                messagingResult = whatHappenedToMessage(usingPhonebookEntry);
                allAboutMessageToPrint = messaging + messagingResult;
                allResultsToPrint += allAboutMessageToPrint;
                break;
            } 
        }
        System.out.println(allResultsToPrint);
    }


    static String whatHappenedToMessage(String usingPhonebookEntry){
        String whatHappenedToMessage = "";

        String[] messagingNameAndNumArray = usingPhonebookEntry.split(" -> ");

        String phoneNumberString = messagingNameAndNumArray[1];
        //String phoneNumOthersReplacedWithZeros = "";

        char[] phoneNumberChar = phoneNumberString.toCharArray();
        for (int i = 0; i < phoneNumberChar.length; i++) {
            if (phoneNumberChar[i] < 48 || phoneNumberChar[i] > 57) {
                phoneNumberChar[i] = '0';
            }
           // phoneNumOthersReplacedWithZeros += phoneNumberChar[i];
        }

        int[] phoneNumCleanedInt = new int[phoneNumberChar.length];
        int differencePhoneDigits = 0;
        for (int i = 0; i < phoneNumCleanedInt.length; i++) {
            phoneNumCleanedInt[i]= Integer.parseInt(String.valueOf(phoneNumberChar[i]));
            differencePhoneDigits -= phoneNumCleanedInt[i];
        }

        if (differencePhoneDigits % 2 == 0){
            whatHappenedToMessage = "meet me there" + System.lineSeparator();
        } else {
            whatHappenedToMessage = "busy" + System.lineSeparator();
        }
        return whatHappenedToMessage;
        
    }

    static String messagingWho(String usingPhonebookEntry, String[] actionCommand) {
            String messaging = "";
            
            String[] nameAndNum = usingPhonebookEntry.split(" -> ");

        if (actionCommand[1].equals(nameAndNum[1])) {
            messaging += "sending sms to " + nameAndNum[0] + "..." + System.lineSeparator();;
        } else if (actionCommand[1].equals(nameAndNum[0])) {
            messaging += "sending sms to " + nameAndNum[1] + "..." + System.lineSeparator();
        }
    
    return messaging;
    }


    static String whatHappenedToCall(String usingPhonebookEntry) {
        String whatHappenedToCall = "";

        String[] callingNameAndNumArray = usingPhonebookEntry.split(" -> ");

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
        int durationMM = sumPhoneDigits % 60;
        int durationHH = sumPhoneDigits / 60;
        //double duration = ((double) sumPhoneDigits / 60.0);
        //DecimalFormat df = new DecimalFormat("##:##");
        //String durationStr = String.valueOf(df.format(duration));
        String durationStr = String.format("%02d", durationHH) + ":" + String.format("%02d", durationMM);

        if (sumPhoneDigits % 2 == 0){
            whatHappenedToCall = "call ended. duration: " + durationStr + System.lineSeparator();
        } else {
            whatHappenedToCall = "no answer" + System.lineSeparator();
        }
        return whatHappenedToCall;
    }


    static String callingWho(String usingPhonebookEntry, String[] actionCommand) {

        String calling = "";

        String[] nameAndNum = usingPhonebookEntry.split(" -> ");

        if (actionCommand[1].equals(nameAndNum[1])) {
            calling = "calling " + nameAndNum[0] + "..." + System.lineSeparator();;
        } else if (actionCommand[1].equals(nameAndNum[0])) {
            calling = "calling " + nameAndNum[1] + "..." + System.lineSeparator();
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


    static String phonebook(String[] phonesString, String[] namesString) {

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
