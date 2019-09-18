import java.util.Random;
import java.util.Scanner;
import java.io.PrintStream;


/**
 * @author Alex Rauenzahn
 * @version 2019-09-18
 */
public class Pig {

  public static void main(String[] args) {
    System.out.println("Welcome to Pig, the two-player dice rolling game");

    final Scanner scanner = new Scanner(System.in);
    final Random random = new Random();

    final Player player1 = new Player(1, random, scanner,
        System.out);/**Creating player 1. I used the 'final' keyword due to the fact that they will not be changing any of their characteristics throughout the duration of the game. This applies to player 2 as well. Random to randomize the number, scanner for the input from the users/players, and print out the result.
     */
    final Player player2 = new Player(2, random, scanner, System.out);

    /**
     * This loop will allow the players to continue to play until one of them has won the game. The takeTurn() allows each player, getting their name, and states who won. Then, outputs the score of each respective player.
     */
    while (true) {
      if (player1.takeTurn()) {
        System.out.println(player1.getName() + " wins!");
        outputScore(player1, player2);
        break;
      }
      if (player2.takeTurn()) {
        System.out.println(player2.getName() + " wins!");
        outputScore(player2, player1);
        break;

      }
    }
    System.out.println(
        player1.getName() + " versus" + player2.getName() + ":" + player1.getScore() + " - "
            + player2.getScore());
  }

  /**
   * This method outputs the score of each player, who is the winner and who is the loser of the
   * game.
   *
   * @param winner The winner of the game.
   * @param loser The loser of the game.
   */
  private static void outputScore(final Player winner, Player loser) {
    System.out.println(
        winner.getName() + " wins by " + (winner.getScore() - loser.getScore()) + " points!");
  }

  /**
   * This class is built for each player. Utilizing the 'final' keyword on Random, name, scanner,
   * and output ensures that nothing can or will be changed.
   */
  private static class Player {

    private final Random random;
    private final String name;
    private final Scanner scanner;
    private final PrintStream output;
    private int score;

    private Player(final int id, final Random random, final Scanner scanner,
        final PrintStream output) {
      this.name = "Player " + id;
      this.random = random;
      this.scanner = scanner;
      this.output = output;
    }

    /**
     * The takeTurn() allows each player the opportunity to take a turn, if they choose to. If not,
     * it will revert to the other player's turn.
     */
    boolean takeTurn() {
      this.output.println(this.name + "'s turn to roll");
      this.output.println("Would you like to play this turn? (Yes/No)");
      if (this.answer().equals("No")) {
        this.output.println(this.name + " skipped their turn.");
        return false;
      }
      int currentTurnScore = 0;
      do {
        final int roll = this.random.nextInt(6) + 1;
        this.output.println(this.name + " rolled a " + roll);
        currentTurnScore += roll;

        if (roll == 1) {
          currentTurnScore = 0;
          break;
        }
        this.output.println(this.name + "'s score this turn is " + currentTurnScore);

      } while (((this.score + currentTurnScore) < 100) && this.continueRolling());

      this.score += currentTurnScore;
      this.output.println(this.name + " ended their turn with " + this.score + " points.");

      return (this.score >= 100);
    }

    /*
    Made some of these methods package private, to ensure there wouldn't be any confusion.
     */
    String getName() {
      return this.name;
    }

    int getScore() {
      return this.score;
    }

    private String answer() {
      return this.scanner.nextLine().replaceAll(" ", "").toUpperCase();
    }

    private boolean continueRolling() {
      this.output.println("Do you want to roll more? (Y/N)");
      String continueRolling = this.answer();

      while (!(continueRolling.equals("Y")) && !(continueRolling.equals("N"))) {
        this.output.println("Please enter only Y/N:");
        continueRolling = this.answer();
      }

      return continueRolling.equals("Y");
    }
  }
}

