import java.util.Scanner;

/**
 * Created by Vilcho on 6/6/2017.
 */
public class MoreEx_p03_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phonesString = scanner.nextLine().split(" "); //0888888888 0888123456 +359886001122

        String[] namesString = scanner.nextLine().split(" "); //Nakov Ivan Maria

        String name = "";

        String phonebook = "";

        while (!(name.equals("done"))) {
            name = scanner.nextLine();
            for (int i = 0; i < namesString.length; i++) {
                if (name.equals(namesString[i])) {
                    phonebook += name + " -> " + phonesString[i] + System.lineSeparator();
                }
            }
        }
        System.out.println(phonebook);
    }
}
