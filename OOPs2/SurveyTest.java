import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SurveyTest {

	Question object = new Question();

	// Positive Test Case
	@Test
	public void surveyTest1() {
		String[][] actual = object.readFile(Constants.FILE_PATH);

		String[][] expected = {
				{ "Q2. Overall Rating of service ?", "(Type) Single Select",
				" Options - (1/2/3/4/5)" },
				{ "Q1. Area of improvement ? ", "(Type) Multi Select",
				"Options - (1.Service Quality/2.Communication/3.Delivery Process)" },
				{ "Q4. Feedback ? ", "(Type)Text" },
				{ "Q3. Contact No. ? ", "(Type) Number" },
				{ "Q5. Name ? ", "(Type)Text" } };
		Assert.assertArrayEquals(expected, actual);
	}

	// Give either correct input for test case to pass or wrong input for it to fail.
	@Test
	public void checkSingleTypeTest() {
		int actual = object.checkSingleType();
		Assert.assertEquals(2, actual);
	}

	// Give either correct input for test case to pass or wrong input for it to fail.
	@Test
	public void checkMultiTypeTest() {
		String actual = object.checkMultiType();
		Assert.assertEquals("Communication", actual);
	}

	// Give either correct input for test case to pass or wrong input for it to fail.
	@Test
	public void checkTextTypeTest() {
		String actual = object.checkTextType();
		Assert.assertEquals("hey", actual);
	}

	// Give either correct input for test case to pass or wrong input for it to fail.
	@Test
	public void checkNumberTypeTest() {
		long actual = object.checkNumberType();
		Assert.assertEquals(1234567890, actual);
	}

	// Negative Test Case
	@Test
	public void surveyTest2() {
		String[][] actual = object.readFile(Constants.FILE_PATH);

		String[][] expected = {
				{ "Q2. Overall Rating of service ?", "(Type) Single Select",
				" Options - (1/2/3/4/5)" },
				{ "Q2. Overall Rating of service ?", "(Type) Single Select",
				" Options - (1/2/3/4/5)" },
				{ "Q2. Overall Rating of service ?", "(Type) Single Select",
				" Options - (1/2/3/4/5)" } };
		Assert.assertFalse(expected == actual);
	}
}
