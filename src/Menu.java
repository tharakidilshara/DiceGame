import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu () {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        String choice;
        printMenu();
        do {
            choice = getChoice();
            switch (choice) {
                case "1":
                    Avatar.print();
                    break;
                case "2":
                    Today.print();
                    break;
                case "3":
                    printMenuForChoice3();
                    choice = getChoice();
                    switch (choice.toLowerCase()){
                        case "3a":
                            RockScissorPaper game = new RockScissorPaper();
                            game.play();
                            break;
                        case "3b":
                            Dice die = new Dice(6);
                            DiceGame21 diceGame = new DiceGame21(die);
                            diceGame.play();
                            break;
                    }
                case "m":
                    printMenu();
                    break;
                case "q":
                case "Q":
                    break;
                default:
                    System.err.println("Bad menu choice, use 'm' to get the menu.");
            }
        } while (!(choice.equals("Q") || choice.equals("q")));
    }

    public void printMenu() {
        String menuText = """
             -----------------
            | 1) Print my avatar
            | 2) Print today date/time
            | 3) Menu choice 3
            | m) Print menu
            | qQ) Quit
             -----------------""";

        System.out.println(menuText);
    }

    private void printMenuForChoice3() {
        String menuText = """  
            Menu choice 3
                | 3A) Rock, scissor, paper
                | 3B) Dice game 21""";

        System.out.println(menuText);
    }

    public String getChoice(){
        System.out.print("Enter your choice: ");
        return scanner.nextLine();
    }
}
