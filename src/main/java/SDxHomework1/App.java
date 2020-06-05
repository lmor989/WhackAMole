package SDxHomework1;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        // creating game object
        WhackAMole newGame = new WhackAMole(50, 10);

        // for user inputs
        Scanner scnObj = new Scanner(System.in);
        int xCoord;
        int yCoord;

        // placing moles at random locations in game
        for (int i = 0; i < 10; i++) {
            int randomN = (int)(Math.random() * 10);
            int randomN2 = (int)(Math.random() * 10);
            newGame.place(randomN, randomN2);
        }
        
        // game logic
        for (int i = newGame.attemptsLeft; i > 0; i--) {
            System.out.println("You have " + newGame.attemptsLeft + " attempts to get all the moles");
            System.out.println("Enter X Coordinate");
            xCoord = scnObj.nextInt();
            System.out.println("Enter Y Coordinate");
            yCoord = scnObj.nextInt();
            
            if (xCoord == -1 && yCoord == -1) {
                System.out.println("You have given up");
                i = 0;
                newGame.printGrid();
            } else {
                System.out.println("You have chosen to whack coordinates: " + xCoord + ", " + yCoord );
                newGame.whack(xCoord, yCoord);
                newGame.printGridToUser();
                if (newGame.molesLeft == 0) {
                    System.out.println("You've won!");
                    i = 0;
                }
            }
        }
    }
}
