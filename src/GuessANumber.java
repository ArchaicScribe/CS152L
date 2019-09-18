import java.util.Random;
import java.util.Scanner;

/**
 * @author Alex Rauenzahn
 * @version 2019-09-06
 */
public class GuessANumber {

  public static void main(String[] args) {
    System.out.println("Hello, welcome to my number game.");
    System.out.println("Please choose a number:");

    Scanner scanner = new Scanner(System.in);//Maximum number of guesses the player will have, as well as their highest number.
    int maxNum;
    maxNum = scanner.nextInt();

    Random random = new Random();
    int number = random.nextInt(maxNum);
    int attempts = 1;
    Scanner input = new Scanner(System.in);
    int guess;
    boolean win = false;

    while(win == false){ //This while loop will return false until win == true.

      System.out.println("Guess a number between 1 and " + maxNum);
      guess = input.nextInt();
      attempts++;//Increasing the allotted attempts by incrementing by 1.
      if(guess == number){
        win = true; //Since the player guessed the number correctly, then loop will end here. If not, it will go to the else if below.
      }
      else if(guess < number){
        System.out.println("Your guess is too low, please try again.");
      }
      else if (guess > number){
        System.out.println("Your guess is too high, please try again.");
      }
    }
    System.out.println("You have won!");
    System.out.println("Your number of attempts was " + attempts + " attempts");
  }

}
