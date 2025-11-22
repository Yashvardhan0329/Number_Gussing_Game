package numberGame;

 public class Round {
    private int targetNumber;
    private GameSettings settings;
    private int guessCount;

    public Round(GameSettings settings) {
        this.settings = settings;
        this.targetNumber = generateRandomNumber(settings.getMinRange(), settings.getMaxRange());
        this.guessCount = 0;
    }

    public GuessResult makeGuess(int guess) {
        guessCount++;
        
        if (guess == targetNumber) {
            return GuessResult.CORRECT;
        } else if (guess > targetNumber) {
            return GuessResult.TOO_HIGH;
        } else {
            return GuessResult.TOO_LOW;
        }
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public int getGuessCount() {
        return guessCount;
    }

    private int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
