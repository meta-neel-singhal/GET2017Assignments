import java.util.ArrayList;
import java.util.List;

/**
 * Generates the movements required to move N number of disks
 * from source tower to destination tower using an auxiliary tower.
 * 
 * @author Neel Singhal
 */
public class TowerOfHanoi {
	int currentDisk;
	List<String> list = new ArrayList<String>();

	/**
	 * Tower of Hanoi works in three parts. These are: 
	 * 1. Move (n-1) disks from source to auxiliary tower. 
	 * 2. Move last disk from source to destination tower.
	 * 3. Move (n-1) disks from auxiliary to destination tower.
	 * 
	 * @param source               tower initially consisting of disks.
	 * @param destination          tower finally consisting of disks.
	 * @param auxiliary            tower used for movement of disks from source to destination.
	 * @param totalNumberOfDisk    total number of disks to be moved from source to destination.
	 * @return list containing the information the movement of the disks from source o destination.
	 */
	public List<String> towerOfHanoi(String source, String destination, String auxiliary, int totalNumberOfDisk) {
		if (totalNumberOfDisk == 1) {
			list.add("Move Disk " +  (currentDisk - totalNumberOfDisk + 1) + " from " + source + " to " + destination);
		}
		else {
			towerOfHanoi(source, auxiliary, destination, totalNumberOfDisk - 1);
			list.add("Move Disk " +  (currentDisk - totalNumberOfDisk + 1) + " from " + source + " to " + destination);
			towerOfHanoi(auxiliary, destination, source, totalNumberOfDisk - 1);
		}

		return list;
	}

	/**
	 * Utility function to set value of global variable currentDisk so as to
	 * check the disk number which is to be moved.
	 * 
	 * @param source               tower initially consisting of disks.
	 * @param destination          tower finally consisting of disks.
	 * @param auxiliary            tower used for movement of disks from source to destination.
	 * @param totalNumberOfDisk    total number of disks to be moved from source to destination.
	 * @return list received from the towerOfHanoi function.
	 */
	public List<String> towerOfHanoiUtil(String source, String destination, String auxiliary, int totalNumberOfDisk) {
		currentDisk = totalNumberOfDisk;

		return towerOfHanoi(source, destination, auxiliary, totalNumberOfDisk);
	}
}