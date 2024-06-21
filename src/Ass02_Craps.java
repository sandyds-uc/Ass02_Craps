import java.util.Random;
import java.util.Scanner;

public class Ass02_Craps // new class for Craps game
{
    public static void main(String[] args) // main()
    {
        // Declare & initialize variables
        Scanner in = new Scanner(System.in); // import Scanner class
        Random rnd = new Random(); // import Random CLass
        int die1 = 0; // die roll 1
        int die2 = 1; // dice roll 2
        int dieSum = 2;
        int wins = 0; // number of wins
        int losses = 0; // number of losses
        int point = 0; // the point
        boolean firstThrow = true; // for the first throw since rules are different
        boolean endGame = false; // ends the game when true
        String userName = ""; // userName
        String continueYN = "Y"; // continue or not
        String stallButton = ""; // so that everything doesn't run continuous

        System.out.println("\nWelcome to Craps!"); // output welcome message
        System.out.print("\nEnter your name: "); // prompt for userName
        userName = in.nextLine(); // input userName

        do { // loop to continue unless user quits
            while (!endGame) // loop to keep rolling until win or loss
            {
                System.out.print("\nPress enter to roll the dice: "); // prompt to roll
                stallButton = in.nextLine(); // prevent from auto rolling
                die1 = rnd.nextInt(6) + 1; // die 1 roll
                die2 = rnd.nextInt(6) + 1; // die 2 roll
                dieSum = die1 + die2; // score
                System.out.println("\nDie1 Die2 DieSum"); // header to display the roll results
                System.out.println("----------------"); // divider for visual affect
                System.out.printf("%3d %4d %5d\n", die1, die2, dieSum); // roll results
                if (firstThrow) // if it's the first roll
                {
                    switch (dieSum) // switch statement for first roll
                    {
                        case 7: // if rolls 7
                        case 11: // if rolls 11
                            System.out.println("\n" + userName + " rolled a " + dieSum + ". " + userName + " rolled a natural and wins!"); // output winning roll
                            endGame = true; // end game
                            wins++; // add to win tally
                            break; // end
                        case 2: // if rolls 2
                        case 3: // if rolls 3
                        case 12: // if rolls 12
                            System.out.println("\n" + userName + " rolled a " + dieSum + ". " + userName + " crapped out and lost."); // output losing roll
                            endGame = true; // end game
                            losses++; // add to loss tally
                            break; // end
                        default: // all other rolls
                            point = dieSum; // make point the sum of the dice
                            System.out.println("\nThe point is: " + point + ". " + userName + " is trying for point."); // output the point
                            firstThrow = false; // let program know it is no longer the first throw
                    }
                }
                else // for throws after the first roll
                {
                    if (dieSum == point) // if rolls the point
                    {
                        endGame = true; // end the game
                        System.out.println("\n" + userName + " made the point and wins the game!"); // output user won by rolling the point
                        wins++; // add to wins
                    }
                    else if (dieSum == 7) // if rolls a 7
                    {
                        endGame = true; // end the game
                        System.out.println("\n" + userName + " rolled a 7 and losses the game."); // output that user lost by rolling a 7
                        losses++; // add to loss total
                    }
                    else // for any other rolls after the first roll
                    {
                        point = dieSum; // change the point
                        System.out.println("\nThe new point is: " + point); // output the new point
                    }
                }
            }
            System.out.println(userName + "'s record is " + wins + " wins and " + losses + " losses."); // output overall record
            System.out.print("\nPress enter to play again, Q to quit: "); // prompt to play again
            continueYN = in.nextLine(); // user input to play again
            endGame = false; // turn endgame off to play again if anything but q is input in the line above this one
        } while (!continueYN.equalsIgnoreCase("Q")); // end game if user inputs a q

        if (wins > losses) // if user won more than lost
        {
            System.out.println("\n" + userName + " had more wins than losses!"); // output above .500 record
            System.out.println("Winner Winner Chicken Dinner!"); // output celebratory statement
        }
        else // if user lost more than won
        {
            System.out.println("\n" + userName + " failed to win the majority of the games played."); // output below .500 record
            System.out.println("It stinks to stink. Better luck next time."); // output loser statement
        }
    }
}