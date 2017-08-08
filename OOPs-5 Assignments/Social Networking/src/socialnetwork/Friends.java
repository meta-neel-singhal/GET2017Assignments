package socialnetwork;

import java.util.Scanner;
import helpers.Connection;
import entity.Entity;
import userdata.Graph;

/**
 * Have all the function relation to the friends or connection
 * 
 * @author Neel Singhal
 */
public class Friends {
	private static Scanner scan = new Scanner(System.in);

	/**
	 * Display all the option related to Connection and call their function
	 * 
	 * @param graph         Graph class object
	 * @param connection    Connection class object
	 * @param userId        Entity ID (User ID or Organization ID)
	 */
	public void friends(Graph<Entity> graph, Connection connection,
			String userId) {
		boolean back = false;
		int choice;
		do {
			System.out.println("1.Add Connection\n2.Display Connections\n3.Remove Connection\n4.Back");
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer Value:");
				scan.nextLine();
			}
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				addFriend(connection, graph, userId);
				break;
			case 2:
				display(connection, graph, userId);
				break;
			case 3:
				removeFriend(connection, graph, userId);
				break;
			case 4:
				back = true;
				break;
			default:
				System.out.println("Enter correct choice\n");
			}
		} while (!back);
	}

	/**
	 * remove friend from the connection list by using friend id
	 * 
	 * @param graph         Graph class object
	 * @param connection    Connection class object
	 * @param userId        Entity ID (User ID or Organization ID)
	 */
	public void removeFriend(Connection connection, Graph<Entity> graph,
			String userId) {
		System.out.println("Enter friend Id :");
		String entityId = scan.next();
		// Check entity id is valid or not.
		if (graph.isValidNodeId(entityId)) {
			/*
			 * If connectionList of current user is not empty and connection id
			 * is present in list.
			 */
			if (connection.getConnectionList(userId) != null
					&& connection.isEntityIdPresentInList(userId, entityId)) {
				connection.removeConnection(userId, entityId);
				System.out.println(graph.getNodeById(entityId).getName()
						+ " removed from your friend list\n");
			} 
			else {
				System.out.println(graph.getNodeById(entityId).getName()
						+ " is not in your friend list\n");
			}
		} 
		else {
			System.out.println("Incorrect Id\n");
		}
	}

	/**
	 * display all the friends from connection list
	 * 
	 * @param graph         Graph class object
	 * @param connection    Connection class object
	 * @param userId        Entity ID (User ID or Organization ID)
	 */
	public void display(Connection connection, Graph<Entity> graph,
			String userId) {
		/*
		 * If connectionList of current user is empty or connectionList of
		 * current user is empty
		 */
		if (connection.getConnectionList(userId) == null
				|| connection.getConnectionList(userId).size() == 0) {
			System.out.println("You have no friends.");
		} 
		else {
			for (String friends : connection.getConnectionList(userId)) {
				System.out.println("\nFriends Id:" + friends + "  Name :"
						+ graph.getNodeById(friends).getName());
			}
		}
		System.out.println();
	}

	/**
	 * Add friend to connection list
	 * 
	 * @param graph         Graph class object
	 * @param connection    Connection class object
	 * @param userId        Entity ID (User ID or Organization ID)
	 */
	public void addFriend(Connection connection, Graph<Entity> graph,
			String userId) {
		System.out.println("Enter Entity Id ");
		String entityId = scan.next();
		// Implementation of hash code and equals method.
		// If current user enter his Id.
		if (graph.getNodeById(userId).equals(graph.getNodeById(entityId))) {
			System.out.println("**********Its your Id**********\n");
		}
		// Check entity id is valid or not
		else if (graph.isValidNodeId(entityId)) {
			// If connectionList of current user is null.
			if (connection.getConnectionList(userId) == null) {
				connection.addConnection(userId, entityId);
				connection.addConnection(entityId, userId);
				System.out.println("**********You are now connect with "
						+ graph.getNodeById(entityId).getName() + "**********\n");
			}
			// if entity id is already present in connection list
			else if (connection.isEntityIdPresentInList(userId, entityId)) {
				System.out.println("**********You are already connected with "
								+ graph.getNodeById(entityId).getName()	+ "**********\n");
			}
		} 
		else {
			System.out.println("**********No person exist in social Network of id : "
							+ entityId + "**********\n");
		}
	}
}
