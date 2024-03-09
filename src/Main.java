import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logic convert = new Logic();
        Scanner scanner = new Scanner(System.in);
        String stop = "stop";
        String choice = "";
        do {
            try {
                System.out.println("Hello! Choose what you want to do:");
                System.out.println("1. Sentence to Morse code");
                System.out.println("2. Morse code to sentence");
                System.out.println("Type 'stop' to exit the program");
                choice = scanner.nextLine().toLowerCase();
                if (! choice.equals("1") && ! choice.equals("2") && ! choice.equals(stop)) {
                    throw new IllegalArgumentException("Invalid choice. Please choose '1', '2', or 'stop'.");
                }
                switch (choice) {
                    case "1" -> {
                        System.out.println("Type a sentence: ");
                        String letters = scanner.nextLine();
                        String morseCode = convert.convertLettersToMorse(letters);
                        System.out.println("Your Morse code: " + morseCode);

                    }
                    case "2" -> {
                        System.out.println("Type Morse code separated with space: ");
                        String morseCode = scanner.nextLine();
                        String letters = convert.convertMorseToLetters(morseCode);
                        System.out.println("Your sentence is: " + letters);
                    }
                    case "stop" -> {
                        System.out.println("Good bye!");
                        Logic.printCatAscii();
                    }
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } while ( ! choice.equals(stop) );
    }
}

