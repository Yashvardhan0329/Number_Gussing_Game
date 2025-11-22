package numberGame;

import java.util.Scanner;

// Main Game Controller
public class NumberGame {
    private Player player;
    private GameSettings settings;
    private Scanner scanner;

    public NumberGame() {
        this.scanner = new Scanner(System.in);
        this.settings = new GameSettings(10, 1, 100);
        this.player = new Player("Player");
    }

    public void start() {
        displayWelcome();
        
        boolean playAgain = true;
        while (playAgain) {
            playRound();
            playAgain = askPlayAgain();
        }
        
        displayGameOver();
        scanner.close();
    }

    private void displayWelcome() {
        System.out.println("Hi! Welcome to the Number Game :-)");
        System.out.println(player.getName() + "! You have " + settings.getMaxChances() + 
                         " chances to win each round. Let's see how you play.");
    }

    private void playRound() {
        Round round = new Round(settings);
        boolean won = false;

        for (int i = 0; i < settings.getMaxChances(); i++) {
            System.out.println("\nChance " + (i + 1) + ": Enter your guess:");
            int guess = scanner.nextInt();
            
            GuessResult result = round.makeGuess(guess);
            
            if (result == GuessResult.CORRECT) {
                won = true;
                player.incrementWins();
                System.out.println("You won it!");
                break;
            } else if (result == GuessResult.TOO_HIGH) {
                System.out.println("Your guess is too high.");
            } else {
                System.out.println("Your guess is too low.");
            }
        }

        if (!won) {
            System.out.println("Sorry, you lost all your chances. The number was " + 
                             round.getTargetNumber() + ".");
        }
        
        player.incrementRoundsPlayed();
    }

    private boolean askPlayAgain() {
        System.out.println("\nDo you want to play again? (yes/no)");
        String response = scanner.next();
        return response.equalsIgnoreCase("yes");
    }

    private void displayGameOver() {
        System.out.println("\nThanks for playing! Hope you enjoyed the game :-)");
        player.displayStats();
    }
}
