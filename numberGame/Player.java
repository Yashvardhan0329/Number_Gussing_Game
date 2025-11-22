package numberGame;


public class Player {
  
	    private String name;
	    private int wins;
	    private int roundsPlayed;
	
	    public Player(String name) {
	        this.name = name;
	        this.wins = 0;
	        this.roundsPlayed = 0;
	    }
	
	    public String getName() {
	        return name;
	    }
	
	    public int getWins() {
	        return wins;
	    }
	
	    public void incrementWins() {
	        wins++;
	    }
	
	    public void incrementRoundsPlayed() {
	        roundsPlayed++;
	    }
	
	    public void displayStats() {
	        System.out.println("=== Game Statistics ===");
	        System.out.println("Player: " + name);
	        System.out.println("Rounds Played: " + roundsPlayed);
	        System.out.println("Rounds Won: " + wins);
	        if (roundsPlayed > 0) {
	            double winRate = (double) wins / roundsPlayed * 100;
	            System.out.printf("Win Rate: %.2f%%\n", winRate);
	        }
	    }
	}

	