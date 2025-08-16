import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("***************************");
        System.out.println("WELCOME TO THE HANGMAN GAME");
        System.out.println("***************************");

        String filepath = "src\\write.txt";
        ArrayList<String> wor = new ArrayList<>();

        try (BufferedReader file = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = file.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    wor.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        if (wor.isEmpty()) {
            System.out.println("Word list is empty. Please add words to write.txt");
            return;
        }

        int wrong = 0;
        Random random = new Random();
        String word = wor.get(random.nextInt(wor.size())).toLowerCase();

        ArrayList<Character> wordStatus = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            wordStatus.add('_');
        }

        Scanner sc = new Scanner(System.in);

        while (wrong < 6) {
            System.out.println(Hangman(wrong));
            System.out.print("\nWORD : ");
            for (char w : wordStatus) {
                System.out.print(w + " ");
            }

            System.out.println("\nAttempts left: " + (6 - wrong));
            System.out.print("Enter a letter: ");
            char c = sc.next().toLowerCase().charAt(0);

            if (word.indexOf(c) >= 0) {
                System.out.println("Correct guess!\n");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == c) {
                        wordStatus.set(i, c);
                    }
                }
                if (!wordStatus.contains('_')) {
                    System.out.println(Hangman(wrong));
                    System.out.println("----*************----");
                    System.out.println("YOU HAVE WON THE GAME");
                    System.out.println("----*************----");
                    System.out.println("The guessed word turned out to be: " + word);
                    return;
                }
            } else {
                System.out.println("Wrong guess!\n");
                wrong++;
            }
        }

        System.out.println(Hangman(wrong));
        System.out.println("*********");
        System.out.println("GAME OVER");
        System.out.println("*********");
        System.out.println("The Word was " + word);
    }

    static String Hangman(int wrong) {
        return switch (wrong) {
            case 0 -> """

                    """;
            case 1 -> """
                    O

                    """;
            case 2 -> """
                    O
                    |

                    """;
            case 3 -> """
                     O
                    /|

                    """;
            case 4 -> """
                     O
                    /|\\

                    """;
            case 5 -> """
                     O
                    /|\\
                    /
                    """;
            case 6 -> """
                     O
                    /|\\
                    / \\
                    """;
            default -> " ";
        };
    }
}
