package assigment6;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static boolean makeTheUserSayYesOrNo(Scanner sc, String questionToUser) {
        while (true) {
            // System.out.print("\nDo you want to save a dices for the next throw? Y/N:\n");
            System.out.println(questionToUser);
            String userAnswer = sc.nextLine().toUpperCase().strip();
            if (userAnswer.equals("Y")) {
                return true;
            }
            else if (userAnswer.equals("N")) {
                return false;
            }
            else {
                System.out.println("That wasn't a Yes/No answer");
            }
        }
    
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // System.out.println("Hello World!");

        System.out.println("Welcome to the name grapher CLI\n");

        System.out.println("Please write names to search in:");
        Scanner sc = new Scanner(System.in);
        String namesToSearchInDB = sc.nextLine().toUpperCase().strip();
        System.out.println("Are separated by ");

        NamesDB injectorDB = new NamesFromTextOnPremise("names-data.txt", " ");        
        
        NamesSeparator injectorSeparatorByComma = new SeparateNamesByComma();
        List<String> names = injectorSeparatorByComma.separateNames(namesToSearchInDB);
        


        sc.close();
    }
}
