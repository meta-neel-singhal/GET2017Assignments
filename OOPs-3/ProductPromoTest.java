import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class ProductPromoTest {
	ProductPromotion productPromo;
	@Before
	public void setUpObject(){
		productPromo = new ProductPromotion();
	}

	//Positive case.
	@Test
	public void productPromoTest1() {
		boolean actual = productPromo.isApplicable(1001);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	//Negative case.
	@Test
	public void productPromoTest2() {
		boolean actual = productPromo.isApplicable(4011);
		boolean expected = true;
		assertFalse(expected == actual);
	}
}
