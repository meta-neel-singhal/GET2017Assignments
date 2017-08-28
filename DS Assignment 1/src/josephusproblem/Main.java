package josephusproblem;

import java.util.Scanner;

/**
 * The Main Class to iinitialize the game.
 * 
 * @author Neel Singhal
 */
public class Main {

    /**
     * The main method.
     *
     * @param args    the arguments
     */
    public static void main(String[] args) {
        Josephus game = new Josephus();
        Scanner scan = new Scanner(System.in);
        int countNo;
        int noOfPeople;
        System.out.println("Enter the no. of people to play : ");
        noOfPeople = scan.nextInt();
        // Set the number of people to play te game.
        game.setNumOfPeople(noOfPeople + 1);
        game.addPeople();
        game.display();
        countNo = 1 + (int)(Math.random() * (noOfPeople + 2));
        game.setCountNum(countNo);
        game.execute();
    }
}