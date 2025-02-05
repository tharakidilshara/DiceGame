import java.util.Random;
import java.util.Scanner;

class Dice {
    private final int sides;
    private final Random random;

    public Dice(int sides) {
        this.sides = sides;
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    }
}

public class DiceGame21 {
    private Dice dice;
    private int playerScore = 0;
    private int maxScore = 0;

    public DiceGame21(Dice dice) {
        this.dice = dice;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Dice Game 21!");
        System.out.println("You will play against Max. The closest to 21 wins.\n");

        boolean quit = false;

        while (!quit) {
            System.out.println("New Round!");
            int playerTotal = playerTurn(scanner);
            if (playerTotal > 21) {
                System.out.println("You went over 21! Max wins this round!");
                maxScore++;
            } else {
                int maxTotal = maxTurn();
                determineRoundWinner(playerTotal, maxTotal);
            }

            System.out.printf("Score: You %d - Max %d%n", playerScore, maxScore);

            System.out.println("Enter 'q' to quit or any key to play another round.");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                quit = true;
            }
        }

        System.out.printf("Final Score: You %d - Max %d%n", playerScore, maxScore);
        System.out.println("Thanks for playing Dice Game 21!");
    }

    private int playerTurn(Scanner scanner) {
        int total = 0;
        boolean continueRolling = true;

        System.out.println("Your turn:");
        while (continueRolling) {
            int roll = dice.roll();
            total += roll;
            System.out.printf("You rolled a %d. Total: %d%n", roll, total);

            if (total > 21) {
                break;
            }

            System.out.print("Do you want to roll again? (y/n) ");
            String input = scanner.nextLine();
            continueRolling = input.equalsIgnoreCase("y");
        }
        return total;
    }

    private int maxTurn() {
        int total = 0;
        System.out.println("\nMax's turn:");

        int rollCount = 0;
        while (total <= 17 && rollCount < 5) {
            int roll = dice.roll();
            total += roll;
            rollCount++;
            System.out.printf("Max rolled a %d. Total: %d%n", roll, total);
        }

        return total;
    }

    private void determineRoundWinner(int playerTotal, int maxTotal) {
        if (playerTotal > 21) {
            System.out.printf("You went over 21! Max wins this round! (Max: %d, You: %d)%n", maxTotal, playerTotal);
            maxScore++;
        } else if (maxTotal > 21) {
            System.out.printf("Max went over 21! You win this round! (Max: %d, You: %d)%n", maxTotal, playerTotal);
            playerScore++;
        } else if (playerTotal <= 21 && playerTotal > maxTotal) {
            System.out.printf("You win this round! (You: %d, Max: %d)%n", playerTotal, maxTotal);
            playerScore++;
        } else if (maxTotal <= 21 && playerTotal < maxTotal) {
            System.out.printf("Max wins this round! (Max: %d, You: %d)%n", maxTotal, playerTotal);
            maxScore++;
        } else {
            System.out.printf("It's a tie! Max wins the round! (Max: %d, You: %d)%n", maxTotal, playerTotal);
            maxScore++;
        }
    }
}

