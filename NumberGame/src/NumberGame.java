import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    static Scanner sc = new Scanner(System.in);

    static int maxAttempt = 5;

    static int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    static int calculateScore(int attempt,int maxAttempt){
        return maxAttempt-attempt+1;
    }

    static int playRound() {
                     // new round start
        int secretNo = generateRandomNumber();   // generate only once
        int attempt = 0;

        while (attempt < maxAttempt) {

            System.out.print("Guess the Number(1-100) : ");
            int guessNo = sc.nextInt();

            attempt++;

            if (guessNo == secretNo) {
                System.out.println("Congratulations! Correct Guess");
                int score = calculateScore(attempt,maxAttempt);
                System.out.println("Score : "+score);
                return score;
            }
            else if (guessNo < secretNo) {
                System.out.println("Too Low! Try Again");
            }
            else {
                System.out.println("Too High! Try Again");
            }

            System.out.println("Attempts Left: " + (maxAttempt - attempt));
        }

        System.out.println("You Lost!");
        System.out.println("The Correct Number Was : "+secretNo);
        return 0;
    }

    static void showSummary(int totalRounds, int totalWins, int totalScore) {

        System.out.println("\n===== GAME SUMMARY =====");
        System.out.println("Rounds Played : " + totalRounds);
        System.out.println("Rounds Won    : " + totalWins);
        System.out.println("Total Score   : " + totalScore);
    }

    public static void main(String[] args) {
        int totalRounds= 0;
        int totalWins= 0;
        int totalScore= 0;

        String choice;

        do{
            totalRounds++;
            int roundScore = playRound();
            totalScore += roundScore;

            if(roundScore>0){
                totalWins++;
            }
            System.out.print("\nDo you want to play again (Y/N): ");
            choice = sc.next();

        }while (choice.equalsIgnoreCase("Y"));

        showSummary(totalRounds,totalWins,totalScore);

        sc.close();

    }
}
