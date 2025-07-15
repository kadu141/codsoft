import java.util.Scanner;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 7;
        int round = 1;
        int totalScore = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n🔁 Round " + round);
            System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess;

               
                if (!scanner.hasNextInt()) {
                    System.out.println("❌ Please enter a valid number.");
                    scanner.next(); 
                    continue;
                }

                guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("✅ Correct! You've guessed the number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1); 
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("📉 Too low!");
                } else {
                    System.out.println("📈 Too high!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("❗ You've used all your attempts. The number was: " + numberToGuess);
            }

            
            System.out.print("🔁 Do you want to play another round? (yes/no): ");
            String answer = scanner.next();

            if (!answer.equalsIgnoreCase("yes")) {
                playAgain = false;
                System.out.println("\n🎮 Game Over!");
                System.out.println("📊 Rounds Played: " + round);
                System.out.println("⭐ Final Score: " + totalScore);
            } else {
                round++;
            }
        }

        scanner.close();
    }
}
