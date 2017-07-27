package junittests;
import promotions.*;
import shoppingterminal.*;
import cart.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrderPromoTest {
	OrderPromotion orderPromo;
	Cart cart;
	Store store;
	ProductPromotion productPromo;

	@Before
	public void setUpObject() {
		store = new Store();
		cart = new Cart();
		orderPromo = new OrderPromotion();
		productPromo = new ProductPromotion();
	}

	// Positive case.
	@Test
	public void orderPromoTest1() {
		boolean actual = orderPromo.isApplicable(1900);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	// Negative case.
	@Test
	public void orderPromoTest2() {
		boolean actual = orderPromo.isApplicable(100);
		boolean expected = true;
		assertFalse(expected == actual);
	}
}
