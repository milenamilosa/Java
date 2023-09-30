import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                    // scanner class
        int max_number = 20;                                    // defines the range for guessing
        int number = 1 + (int) (max_number * Math.random());    // generates random number
        int trials = 5;                                         // given trials
        int i, guess;                                           // trial counter and user input variable
        for (i = 0; i < trials; i++) {                          // iterate over trials
            System.out.println("Guess the number between 1 and " + max_number + "!");
            guess = sc.nextInt();                               // takes input to compare
            if (guess >= 1 && guess <= max_number) {
                if (guess > number &&  i != trials - 1) {       // important that count < trials
                    System.out.println("Number is too biggie");
                } else if (guess < number && i != trials - 1) {
                    System.out.println("Number is too shmol");
                } else if (guess == number) {
                    System.out.println("Congrats, you are a smartass!");
                    break;                                      // stops the game in case of correct answer
                }
            }
            else{
                System.out.println("Game over! Learn how to read the rules, silly!\nPress PLAY to replay)");
                break;
            }
        }
        if (i == trials) {                                      //for the wrong final guess there is a special case
            System.out.println("Oupsie, deadend! The number you had to guess was " + number);
        }
        }
    }
