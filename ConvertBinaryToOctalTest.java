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
	
	@Test
	 public void evaluatesExpression3() {
	   ConvertBinaryToOctal binToOct = new ConvertBinaryToOctal();
	   int octal = binToOct.convertBinaryToOctal(12340000);
	   assertEquals(0, octal);
	 }
}
