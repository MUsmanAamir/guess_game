
import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        int numberToGuess = generateRandomNumber();
        int numberOfTries = 0;
        Scanner input = new Scanner(System.in);
        int guess;
        boolean win = false;
        boolean playAgain = true;

        while (playAgain) 
        {
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("Try to guess it in as few attempts as possible.");

            while (!win) 
            {
                System.out.print("Guess a number between 1 and 100:");
                guess = input.nextInt();
                numberOfTries++;

                if (guess == numberToGuess) 
                {
                    win = true;
                    System.out.println("Congratulations! You guessed the number in " + numberOfTries + " tries.");
                } 
                else if (guess < numberToGuess) 
                {

                    System.out.println("Your guess is too low. Try again!");
                } 
                else 
                {
                    System.out.println("Your guess is too high. Try again!");
                }
            }

            System.out.println("Do you want to play again? (yes/no)");
            String response = input.next();

            if (response.equalsIgnoreCase("yes")) 
            {
                numberToGuess = generateRandomNumber();
                numberOfTries = 0;
                win = false;
            } 
            else
            {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }
            input.close();
        }

    }

    private static int generateRandomNumber() 
    {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }
}