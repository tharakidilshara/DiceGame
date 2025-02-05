import java.util.Random;
import java.util.Scanner;

public class RockScissorPaper {
    public static void play(){

        Scanner scanner = new Scanner(System.in);
        String userChoice;
        int userScore = 0, maxScore = 0;

        System.out.println("Welcome to a game of rock ✊, scissor ✂, paper ✋!");
        System.out.println("You will play against Max and we keep score.");

        while (true) {
            System.out.println("\nScore: You " + userScore + " - Max " + maxScore);
            System.out.println("Select rock ✊ [r], scissor ✂ [s], paper ✋ [p] or quit [q]:");
            userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("q")) {
                System.out.println("Thanks for playing! Goodbye!");
                break;
            }

            if (!userChoice.equals("r") && !userChoice.equals("s") && !userChoice.equals("p")) {
                System.out.println("Invalid choice! Please enter [r], [s], [p], or [q] to quit.");
                continue;
            }

            String maxChoice = getMaxChoice();

            System.out.print("You did " + getChoiceName(userChoice) + " and Max did " + getChoiceName(maxChoice) + ".");

            String result = determineWinner(userChoice, maxChoice);

            if (result.equals("You win!")) {
                userScore++;
                System.out.println(getWinningMessage(userChoice, maxChoice) + " You win 1 point!");
            } else if (result.equals("Marvin wins!")) {
                maxScore++;
                System.out.println(getWinningMessage(maxChoice, userChoice) + " Max wins 1 point!");
            } else {
                System.out.println("You are equal! No points!");
            }
        }
    }

    private static String getMaxChoice() {
        Random rand = new Random();
        int choice = rand.nextInt(3);
        if (choice == 0) return "r";
        if (choice == 1) return "s";
        return "p";
    }

    private static String getChoiceName(String choice) {
        switch (choice) {
            case "r": return "rock ✊";
            case "s": return "scissor ✂";
            case "p": return "paper ✋";
            default: return "";
        }
    }

    private static String determineWinner(String userChoice, String maxChoice) {
        if (userChoice.equals(maxChoice)) {
            return "No one wins";
        }
        if ((userChoice.equals("r") && maxChoice.equals("s")) ||
                (userChoice.equals("s") && maxChoice.equals("p")) ||
                (userChoice.equals("p") && maxChoice.equals("r"))) {
            return "You win!";
        }
        return "Marvin wins!";
    }

    private static String getWinningMessage(String winnerChoice, String loserChoice) {
        if (winnerChoice.equals("r") && loserChoice.equals("s")) {
            return "Rock ✊ crushes scissors ✂,";
        } else if (winnerChoice.equals("s") && loserChoice.equals("p")) {
            return "Scissor ✂ cuts paper ✋,";
        } else if (winnerChoice.equals("p") && loserChoice.equals("r")) {
            return "Paper ✋ covers rock ✊,";
        }
        return "";
    }
}




