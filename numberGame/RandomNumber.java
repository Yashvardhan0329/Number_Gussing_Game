package numberGame;

// Game settings configuration
class GameSettings {
    private int maxChances;
    private int minRange;
    private int maxRange;

    public GameSettings(int maxChances, int minRange, int maxRange) {
        this.maxChances = maxChances;
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    public int getMaxChances() {
        return maxChances;
    }

    public int getMinRange() {
        return minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }
}


enum GuessResult {
    CORRECT,
    TOO_HIGH,
    TOO_LOW
}