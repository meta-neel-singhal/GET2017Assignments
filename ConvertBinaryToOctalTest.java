import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConvertBinaryToOctalTest {

	@Test
	public void evaluatesExpression1() {
		ConvertBinaryToOctal binToOct = new ConvertBinaryToOctal();
		int octal = binToOct.convertBinaryToOctal(1010010);
		assertEquals(122, octal);
	}

	@Test
	public void evaluatesExpression2() {
		ConvertBinaryToOctal binToOct = new ConvertBinaryToOctal();
		int octal = binToOct.convertBinaryToOctal(11010010);
		assertEquals(322, octal);
	}

	// This is a special case when a non binary number is given as input.

	@Test
	public void evaluatesExpression3() {
		ConvertBinaryToOctal binToOct = new ConvertBinaryToOctal();
		int octal = binToOct.convertBinaryToOctal(12340000);
		String errorMessage = null;
		if (octal == 8){
			errorMessage = "Please insert a binary value!!!";
		}
		assertEquals(errorMessage, "Please insert a binary value!!!");
	}
}
