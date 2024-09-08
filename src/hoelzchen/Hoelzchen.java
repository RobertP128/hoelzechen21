package hoelzchen;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


/**
 * The Main class to play 21 Hoelzchen<br>
 * Automatically the stdin and stdout are taken as input and output<br>
 * invoking the run method wil start the game
 */
public class Hoelzchen {

    private Scanner scanner;
    private Player currentPlayer;

    public Hoelzchen() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        do {
            currentPlayer = Player.Two;

            int remaining = 21;
            int input = 0;
            printStatus(remaining);
            while (remaining > 0) {
                swapPlayer();

                do {
                    input = readInput();
                } while (!validateIntput(input, remaining));
                remaining -= input;
                printStatus(remaining);
            }
            printWinner();


        } while (requestAnotherGame());
        System.out.println("Auf Wiedersehen!!");
    }

    private void swapPlayer() {
        currentPlayer = (currentPlayer == Player.One) ? Player.Two : Player.One;
    }

    private int readInput() {
        System.out.print("hoelzchen.Player " + currentPlayer + ", wieviele Hölzchen wollen Sie nehmen?");
        int nextInt=0;
        try {
            nextInt=scanner.nextInt();
        }catch (InputMismatchException e){
            scanner.next();
            nextInt=-1;
        }
        return nextInt;
    }

    /**
     * Checks if an input is valid with respect to the remaining hoelzchen.Hoelzchen,
     * @param input The numbe of hoelzchen.Hoelzchen youwant to take
     * @param remaining The number of remaining hoelzchen.Hoelzchen on the table
     * @return boolean true if the action is possible, false if there was a problem
     */
    protected boolean validateIntput(int input, int remaining) {
        if (input != 1 && input != 2 && input != 3) {
            System.out.println("Wrong input");
            return false;
        }
        if (input > remaining) {
            System.out.println("too much selected");
            return false;
        }
        System.out.println("OK");
        return true;
    }

    private void printStatus(int remaining) {
        System.out.println("Es verbleiben noch " + remaining + " Hölzchen");
    }

    private void printWinner() {
        System.out.println("The winner is: hoelzchen.Player " + currentPlayer);
    }

    private boolean requestAnotherGame() {
        boolean validChoice = false;
        char choice = ' ';
        do {
            System.out.print("Play again(Y/N)");
            var choiceStr = scanner.next();
            choice = choiceStr.toUpperCase(Locale.ROOT).charAt(0);
        }
        while (choice != 'Y' && choice != 'N');
        return choice == 'Y';
    }


}
