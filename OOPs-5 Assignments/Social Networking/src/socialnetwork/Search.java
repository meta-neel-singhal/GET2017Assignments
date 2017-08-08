package socialnetwork;

import java.util.Scanner;
import java.util.Set;
import entity.Entity;
import userdata.Graph;

/**
 * Search entity from the social network.
 * 
 * @author Neel Singhal
 */
public class Search {
	private static Scanner scan;

	/**
	 * Search entity by using name
	 * 
	 * @param graph     Graph class object
	 * @param userId    Entity ID
	 */
	public void search(Graph<Entity> graph, String userId) {
		scan = new Scanner(System.in);
		boolean searchresult = false;
		System.out.println("Enter name : ");
		String name = scan.nextLine();
		Set<String> entityIds = graph.getNodesId();
		for (String id : entityIds) {
			/*
			 *  Skips current user name and check if the input substring matches with
			 *   any string (name) in any Node.
			 */ 
			if (!graph.getNodeById(id).equals(graph.getNodeById(userId))
					&& graph.getNodeById(id).getName().contains(name)) {
				System.out.println("User id - " + id + " \t Name : " + graph.getNodeById(id).getName());
				searchresult = true;
			}
		}
		if (!searchresult) {
			System.out.println("No result found..!!!");
		}
	}
}
