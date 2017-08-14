package socialnetwork;

import helpers.Connection;
import helpers.WriteToFile;
import java.util.Scanner;
import userdata.Graph;

/**
 * Main class responsible for driving all the methods
 * 
 * @author Neel Singhal
 */
public class SocialNetwork {
	private static Scanner scan;
	private static int choice;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		Connection connection = new Connection();
		Graph graph = new Graph();
		WriteToFile writeUpdatesToFile = new WriteToFile();
		boolean exit = false;
		do {
			System.out.println("1.Login\n2.SignUp\n3.Exit");
			System.out.print("Enter Your Choice : ");
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer Value:");
				scan.nextLine();
			}
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				new SignIn().signIn(graph, connection);
				break;
			case 2:
				new SignUp().signUp(graph, connection);
				break;
			case 3:
				writeUpdatesToFile.writeEntityDetailsToFile(graph, connection);
				writeUpdatesToFile.writeConnectionDetailsToFile(graph, connection);
				exit = true;
				break;
			default:
				System.out.println("Enter correct choice");
			}
		} while (!exit);
	}
}
