package socialnetwork;

import java.util.List;
import java.util.Scanner;

import helpers.Connection;
import entity.Entity;
import userdata.Graph;

/**
 * Suggest other friends to any of the user's friend.
 * 
 * @author Neel Singhal
 */
public class SuggestFriend {
	private static Scanner scan;

	/**
	 * Suggest friends to the connection.
	 * 
	 * @param graph         Graph class object.
	 * @param connection    Connection class object.
	 * @param userId        Current user Id.
	 */
	public void suggestFriend(Graph<Entity> graph, Connection connection,
			String userId) {
		scan = new Scanner(System.in);
		System.out.println("Enter friend Id  who do you want to suggest friends");
		String friendId = scan.nextLine();
		// Check if user enter his own Id.
		if (graph.getNodeById(userId).equals(graph.getNodeById(friendId))) {
			System.out.println("Its your Id");
		}
		// check if entered id is valid or not.
		else if (graph.isValidNodeId(friendId)) {
			List<String> friendsConnection = connection.getConnectionList(friendId);
			if (friendsConnection == null || !friendsConnection.contains(userId)) {
				System.out.println("**********You have to become "
						+ graph.getNodeById(friendId).getName()
						+ "'s friend to suggest friend**********\n");
			} 
			else {
				for (String id : connection.getConnectionList(userId)) {
					if (!friendsConnection.contains(id) && !friendId.equals(id)) {
						System.out.println("user id- " + id + "\t Name: "
								+ graph.getNodeById(id).getName());
					}
				}
			}
		} 
		else {
			System.out.println("**********Enter Valid Friend Id**********\n");
		}
	}
}
