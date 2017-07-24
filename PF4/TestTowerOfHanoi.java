import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class TestTowerOfHanoi {

	TowerOfHanoi towerOfHanoiObject = new TowerOfHanoi();

	// Positive Test Case 1.
	@Test
	public void towerOfHanoiTest1() {
		List<String> movementsOfDisks = towerOfHanoiObject.towerOfHanoiUtil("A", "B", "C", 1);
		List<String> actualMovement = Arrays.asList("Move Disk 1 from A to B");
		// Compares expected and actual movements of disks.
		assertThat(movementsOfDisks, is(actualMovement));
	}

	// Positive Test Case 2.
	@Test
	public void towerOfHanoiTest2() {
		List<String> movementsOfDisks = towerOfHanoiObject.towerOfHanoiUtil("A", "B", "C", 2);
		List<String> actualMovement = Arrays.asList("Move Disk 2 from A to C", 
				"Move Disk 1 from A to B", "Move Disk 2 from C to B");
		// Compares expected and actual movements of disks.
		assertThat(movementsOfDisks, is(actualMovement));
	}

	// Positive Test Case 3.
	@Test
	public void towerOfHanoiTest3() {
		List<String> movementsOfDisks = towerOfHanoiObject.towerOfHanoiUtil("A", "B", "C", 3);
		List<String> actualMovement = Arrays.asList("Move Disk 3 from A to B", "Move Disk 2 from A to C",
				"Move Disk 3 from B to C", "Move Disk 1 from A to B", "Move Disk 3 from C to A", 
				"Move Disk 2 from C to B", "Move Disk 3 from A to B");
		// Compares expected and actual movements of disks.
		assertThat(movementsOfDisks, is(actualMovement));
	}

	// Negative Test Case 1.
	@Test
	public void towerOfHanoiTest4() {
		List<String> movementsOfDisks = towerOfHanoiObject.towerOfHanoiUtil("A", "B", "C", 1);
		List<String> actualMovement = Arrays.asList("Move Disk 1 from B to A");
		// Compares expected and actual movements of disks.
		assertThat(movementsOfDisks, not(actualMovement));
	}

	// Negative Test Case 2.
	@Test
	public void towerOfHanoiTest5() {
		List<String> movementsOfDisks = towerOfHanoiObject.towerOfHanoiUtil("A", "B", "C", 2);
		List<String> actualMovement = Arrays.asList("Move Disk 2 from A to C");
		// Compares expected and actual movements of disks.
		assertThat(movementsOfDisks, not(actualMovement));
	}

	// Negative Test Case 3.
	@Test
	public void towerOfHanoiTest6() {
		List<String> movementsOfDisks = towerOfHanoiObject.towerOfHanoiUtil("A", "B", "C", 3);
		List<String> actualMovement = Arrays.asList("Move Disk 3 from A to B", "Move Disk 2 from A to C",
				"Move Disk 3 from B to C", "Move Disk 1 from A to B", "Move Disk 3 from C to A", 
				"Move Disk 2 from C to B");
		// Compares expected and actual movements of disks.
		assertThat(movementsOfDisks, not(actualMovement));
	}
}
