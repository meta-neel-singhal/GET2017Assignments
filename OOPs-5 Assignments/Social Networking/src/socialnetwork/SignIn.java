package socialnetwork;

import helpers.Connection;

import java.util.Scanner;

import userdata.Graph;
import entity.Entity;

/**
 * Responsible for sign in operations of user and organization.
 * 
 * @author Neel Singhal
 */
public class SignIn {
	private static int choice;
	private static boolean logout;
	private static Scanner scan = new Scanner(System.in);

	/**
	 * Get type of user and call function according to the type
	 * 
	 * @param graph         Graph class object
	 * @param connection    Connection class object
	 */
	public void signIn(Graph<Entity> graph, Connection connection) {
		scan = new Scanner(System.in);
		System.out.println("Enter your id : ");
		String enityId = scan.nextLine();
		// Check for valid Id.
		while (!graph.isValidNodeId(enityId)) {
			System.out.println("Enter correct Id : ");
			enityId = scan.nextLine();
		}
		System.out.println("Enter password");
		String password = scan.nextLine();
		// Check for correct password.
		while (!graph.getNodeById(enityId).getPassword().equals(password)) {
			System.out.println("Enter correct password ");
			password = scan.nextLine();
		}
		// Successfully sign in.
		System.out.println("**********Welcome to the Social Network "
				+ ((Entity) graph.getNodeById(enityId)).getName() + "**********\n");
		if (("User").equalsIgnoreCase(((Entity) graph.getNodeById(enityId)).getType())) {
			userLogin(graph, connection, enityId);
		} 
		else {
			organizationLogin(graph, connection, enityId);
		}
	}

	/**
	 * Display all Option related to when organization sign in social network
	 * and call their function
	 * 
	 * @param graph             Graph class object
	 * @param connection        Connection class object
	 * @param organizationId    Id of Organization
	 */
	public void organizationLogin(Graph graph, Connection connection,
			String organizationId) {
		logout = false;
		do {
			System.out.println("1.Edit Profile\n2.Post\n3.Followers\n4.Logout");
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer Value:");
				scan.nextLine();
			}
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				logout = new EditProfile().editOrganizationProfile(graph, organizationId);
				break;
			case 2:
				new Posts().posts(graph, organizationId);
				break;
			case 3:
				new Friends().friends(graph, connection, organizationId);
				break;
			case 4:
				System.out.println("Are you sure : Y/N");
				if (scan.next().equalsIgnoreCase("Y")) {
					logout = true;
				}
				break;
			}
		} while (!logout);
	}

	/**
	 * Display all option related to when organization sign in social network
	 * and call their function according to choice entered
	 * 
	 * @param graph             Graph class object
	 * @param connection        Connection class object
	 * @param organizationId    Id of Organization
	 */
	public void userLogin(Graph graph, Connection connection, String userId) {
		logout = false;
		do {
			System.out
					.println("1.Edit Profile\n2.Post\n3.Friends\n4.Search\n5.Suggest Friends\n6.Logout");
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer Value:");
				scan.nextLine();
			}
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				logout = new EditProfile().editUserProfile(graph, userId);
				break;
			case 2:
				new Posts().posts(graph, userId);
				break;
			case 3:
				new Friends().friends(graph, connection, userId);
				break;
			case 4:
				new Search().search(graph, userId);
				break;
			case 5:
				new SuggestFriend().suggestFriend(graph, connection, userId);
				break;
			case 6:
				System.out.println("Are you sure : Y/N");
				if (scan.next().equalsIgnoreCase("Y")) {
					logout = true;
				}
				break;
			default:
				System.out.println("Enter Correct Choice : ");
			}
		} while (!logout);
	}
}
