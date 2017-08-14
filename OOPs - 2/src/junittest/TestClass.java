package junittest;

import surveymaterial.Answers;
import surveymaterial.Questions;
import helper.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestClass {
	Answers answer = new Answers();
	Questions question = new Questions();
	FileManager fileOperations = new FileManager();

	// Positive test case.
	@Test
	public void answersTestCase1() {
		answer.setAnswer("Neel");
		answer.setAnswer("Singhal");
		String actual = answer.getAnswer();
		String expected = "NeelSinghal";
		assertEquals(expected, actual);
	}

	// Positive test case.
	@Test
	public void singleSelectQuestionsTestCase1() {
		boolean actual = question.isValidOption("1/2/3/4/5", "1");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	// Positive test case.
	@Test
	public void multiSelectQuestionsTestCase1() {
		boolean actual = question.isValidOption(
				"Service Quality/Communication/Delivery Process",
				"Service Quality,Communication");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	// Positive test case.
	@Test
	public void fileManagerTestCase1() {
		String[][] actual = fileOperations.read(Constants.QUESTION_PATH);
		String[][] expected = {{ "Q1. Enter your Name-", "Text" },
				{ "Q2. Enter your Contact No-", "Number" },
				{ "Q3. Overall Rating of Service-", "Single Select","1/2/3/4/5" },
				{ "Q4. Area of improvement ?", "Multi Select","Service Quality/Communication/Delivery Process" },
				{ "Q5. Feedback ?", "Text" }};
		assertArrayEquals(expected, actual);
	}

	// Positive test case.
	@Test
	public void countLinesTestCase1() {
		int actual = fileOperations.countLines(Constants.QUESTION_PATH);
		int expected = 5;
		assertEquals(expected, actual);
	}

	// Negative test case.
		@Test
		public void answersTestCase2() {
			answer.setAnswer("Neel");
			answer.setAnswer("Singhal");
			String actual = answer.getAnswer();
			String expected = "Neel";
			assertFalse(expected == actual);
		}

		// Negative test case.
		@Test
		public void singleSelectQuestionsTestCase2() {
			boolean actual = question.isValidOption("1/2/3/4/5", "8");
			boolean expected = true;
			assertFalse(expected == actual);
		}

		// Negative test case.
		@Test
		public void multiSelectQuestionsTestCase2() {
			boolean actual = question.isValidOption(
					"Service Quality/Communication/Delivery Process",
					"Service Quality,Communication");
			boolean expected = false;
			assertFalse(expected == actual);
		}

		// Negative test case.
		@Test
		public void fileManagerTestCase2() {
			String[][] actual = fileOperations.read(Constants.QUESTION_PATH);
			String[][] expected = {{ "Q1. Enter your Name-", "Text" },
					{ "Q2. Enter your Contact No-", "Number" },
					{ "Q3. Overall Rating of Service-", "Single Select","1/2/3/4/5" },
					{ "Q4. Area of improvement ?", "Multi Select","Service Quality/Communication/Delivery Process" }};
			assertFalse(expected == actual);
		}

		// Negative test case.
		@Test
		public void countLinesTestCase2() {
			int actual = fileOperations.countLines(Constants.QUESTION_PATH);
			int expected = 0;
			assertFalse(expected == actual);
		}
}
