import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of games to play: ");
        int games = sc.nextInt();
        
        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;
        
        for (int i = 1; i <= games; i++) {
            System.out.println("\nGame " + i);
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String playerChoice = sc.next().toLowerCase();
            
            String computerChoice = getComputerChoice();
            System.out.println("Computer chose: " + computerChoice);
            
            String result = findWinner(playerChoice, computerChoice);
            System.out.println("Result: " + result);
            
            if (result.equals("Player wins")) {
                playerWins++;
            } else if (result.equals("Computer wins")) {
                computerWins++;
            } else {
                draws++;
            }
        }
        
        displayResults(playerWins, computerWins, draws, games);
        
        sc.close();
    }
    
    public static String getComputerChoice() {
        int random = (int)(Math.random() * 3);
        switch (random) {
            case 0: return "rock";
            case 1: return "paper";
            default: return "scissors";
        }
    }
    
    public static String findWinner(String player, String computer) {
        if (player.equals(computer)) {
            return "Draw";
        }
        
        if ((player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("paper") && computer.equals("rock")) ||
            (player.equals("scissors") && computer.equals("paper"))) {
            return "Player wins";
        } else {
            return "Computer wins";
        }
    }
    
    public static void displayResults(int playerWins, int computerWins, int draws, int totalGames) {
        System.out.println("\n----- Game Statistics -----");
        System.out.println("Total games: " + totalGames);
        System.out.println("Player wins: " + playerWins + " (" + (playerWins * 100.0 / totalGames) + "%)");
        System.out.println("Computer wins: " + computerWins + " (" + (computerWins * 100.0 / totalGames) + "%)");
        System.out.println("Draws: " + draws + " (" + (draws * 100.0 / totalGames) + "%)");
        System.out.println("-------------------------");
    }
}