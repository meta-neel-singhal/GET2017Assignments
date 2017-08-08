package userdata;

import java.util.HashMap;
import java.util.Set;

/**
 * Interface to declare methods for nodes.
 * 
 * @author Neel Singhal
 **/
public interface Node<E> {

	/**
	 * Add Node into hashMap.
	 * 
	 * @param id    Node Id.
	 * @param obj
	 */
	public void addNode(String id, E obj);

	/**
	 * Remove node from hashMap.
	 * 
	 * @param id    nodeId.
	 */
	public void removeNodeById(String id);

	/**
	 * Get Node by using Id.
	 * 
	 * @param id    nodeId.
	 * @return node
	 */
	public E getNodeById(String id);

	/**
	 * To get full hashMap of nodes.
	 * 
	 * @return whole hashMap of nodes
	 */
	public HashMap<String, E> getNodeHashMap();

	/**
	 * Check node is valid or not.
	 * 
	 * @param id    nodeId.
	 * @return if id is valid then return true else false.
	 */
	public boolean isValidNodeId(String id);

	/**
	 * To get id of nodes.
	 * 
	 * @return set of nodes Id
	 */
	public Set<String> getNodesId();
}
