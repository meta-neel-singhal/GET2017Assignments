/**
 * Interface to declare required promotion methods. 
 * 
 * @author Neel Singhal
 */
public interface Promotion {
	boolean isApplicable(double id);

	void getDiscount(Cart cart);
}
