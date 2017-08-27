package josephusproblem;

/**
 * Contains method to set up the Josephus problem.
 * 
 * @author Neel Singhal
 */
public class Josephus {
	private int noOfPeople;
	private int countNo;
	private Node head;
	private Node tail;
	CircularList list;

	public Josephus() {
		list = new CircularList();
		this.noOfPeople = 0;
		this.countNo = 0;
	}

	public void setNumOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public int getNumOfPeople() {
		return noOfPeople;
	}

	public void setCountNum(int countNo) {
		this.countNo = countNo;
	}

	public int getCountNum() {
		return countNo;
	}

	/**
	 * Adds people in the list.
	 */
	public void addPeople() {
		for (int count = 1; count < noOfPeople; count++) {
			list.insert(count);
		}
	}

	/**
	 * Obtain the next move of the game.
	 */
	public void move() {
		for (int count = 0; count < countNo; count++) {
			tail = head;
			head = head.getNext();
		}
		System.out.println("Person out : " + head.getData());
	}

	/**
	 * Execute the game.
	 */
	public void execute() {
		tail = null;
		head = list.getFirst();
		// Checks if number of people is not equal to 1.
		while (noOfPeople != 2) {
			move();
			list.delete(head.getData());
			tail = tail.getNext();
			head = head.getNext();
			noOfPeople--;
			display();
		}
	}

	/**
	 * Display the remaining players.
	 */
	public void display() {
		System.out.print("Remaining : ");
		list.displayList();
	}
}