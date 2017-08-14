package socialnetwork;

import helpers.Connection;
import java.util.Scanner;
import userdata.Graph;
import entity.Organization;
import entity.User;

/**
 * Responsible for sign up operations.
 * 
 * @author Neel Singhal
 */
public class SignUp {
	private static Scanner scan = new Scanner(System.in);;

	/**
	 * Call function according to the type user or organization.
	 * 
	 * @param graph         Graph class object
	 * @param connection    Connection class object
	 */
	public void signUp(Graph graph, Connection connection) {
		System.out.println("Enter Account Type - User/Organization");
		String type = scan.nextLine();
		switch (type.toLowerCase()) {
		case "user":
			addUser(type, graph, connection);
			break;
		case "organization":
			addOrganization(type, graph, connection);
			break;
		default:
			System.out.println("Enter correct Option");
		}
	}

	/**
	 * Add organization into the graph.
	 * 
	 * @param type          Organization type
	 * @param graph         Graph class object
	 * @param connection    Connection class object
	 */
	public void addOrganization(String type, Graph<Organization> graph,
			Connection connection) {
		System.out.println("Enter Organization Id:");
		String id = scan.nextLine();
		while (graph.isValidNodeId(id)) {
			System.out.println("This id is already exist in social network");
			id = scan.nextLine();
		}
		String name, password;
		String address;
		long contact;
		System.out.println("Enter your Name:");
		name = scan.nextLine();
		System.out.println("Password");
		password = scan.nextLine();
		System.out.println("Address");
		address = scan.nextLine();
		contact = getValidContact();
		graph.addNode(id, new Organization(id, name, password, contact, address, type));
		System.out.println("\n**********Welcome to the Social Network " + name + "**********\n");
		new SignIn().organizationLogin(graph, connection, id);

	}

	/**
	 * Add user into the graph.
	 * 
	 * @param type          Organization type
	 * @param graph         Graph class object
	 * @param connection    Connection class object
	 */
	public void addUser(String type, Graph<User> graph, Connection connection) {
		System.out.println("Enter User Id:");
		String name, password;
		int age;
		long contact;
		String id = scan.nextLine();
		// If node already exist in social network.
		while (graph.isValidNodeId(id)) {
			System.out.println("This id is already exist in social network");
			id = scan.nextLine();
		}
		System.out.println("Enter your Name:");
		name = scan.nextLine();
		System.out.println("Password");
		password = scan.nextLine();
		age = getValidAge();
		contact = getValidContact();
		graph.addNode(id, new User(id, name, password, contact, age, type));
		System.out.println("\n--------Welcome to the Social Network " + name + "---------\n");
		new SignIn().userLogin(graph, connection, id);
	}

	/**
	 * Get age until user enters it correctly.
	 * 
	 * @return age of the user.
	 */
	public int getValidAge() {
		System.out.println("Age");
		int age;
		while (!scan.hasNextInt() || (age = scan.nextInt()) > 200 || age < 10) {
			System.out.println("Enter Correct Age:");
			scan.nextLine();
		}
		
		return age;
	}

	/**
	 * Get contact number until user enters it correctly.
	 * 
	 * @return valid contact number
	 */
	public long getValidContact() {
		System.out.println("Contact Number");
		long contact;
		while (!scan.hasNextLong() || String.valueOf(contact = scan.nextLong()).length() != 10) {
			System.out.println("Enter 10 digit number:");
			scan.nextLine();
		}
		
		return contact;
	}
}
