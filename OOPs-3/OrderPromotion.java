import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Checks if any order promotion is applicable on the purchased order
 * and gets the discount on the basis of the applicable order promotion.
 * 
 * @author Neel Singhal
 */
public class OrderPromotion implements Promotion {
	private List<String> orderPromoList;
	private HashMap<Double, Double> discountList = new HashMap<Double, Double>();
	private HashMap<Double, String> discountType = new HashMap<Double, String>();

	public HashMap<Double, Double> getDiscountList() {
		return discountList;
	}

	public HashMap<Double, String> getDiscountType() {
		return discountType;
	}

	public OrderPromotion() {
		initializeOrderPromoList();
	}

	/**
	 * Initializes values of the discountList and the discountType hash maps.
	 */
	public void initializeOrderPromoList() {
		orderPromoList = new FileHandling().read(Constants.ORDER_PROMOTION_PATH);
		String[] details;
		for (String str : orderPromoList) {
			details = str.split(",");
			discountList.put(Double.parseDouble(details[2]), Double.parseDouble(details[1]));
			discountType.put(Double.parseDouble(details[2]), details[0]);
		}
	}


	/**
	 * Checks if any order promotion is applicable on the order.
	 * 
	 * @param totalAmount    Amount on which an order promotion is to be checked.
	 * @return true if an order promotion is applicable otherwise false.
	 */
	public boolean isApplicable(double totalAmount) {
		double[] thresholdArray = new double[discountList.size()];
		int index = 0;
		for (double amount : discountList.keySet()) {
			thresholdArray[index] = amount;
			index++;
		}
		Arrays.sort(thresholdArray);
		if (totalAmount >= thresholdArray[0]) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gets the discount amount based on the applicable order promotion, if any.
	 * 
	 * @param cart    Contains details about the cart. 
	 */
	public void getDiscount(Cart cart) {
		double totalAmount = cart.getTotalAmount() - cart.getTotalProductLevelDiscount();
		if(isApplicable(totalAmount)){
			double[] thresholdArray = new double[discountList.size()];
			int index = 0;
			for (double amount : discountList.keySet()) {
				thresholdArray[index] = amount;
				index++;
			}
			Arrays.sort(thresholdArray);
			double maxDiscount = 0.0;
			int count = 0;
			while(count < thresholdArray.length) {
				if(totalAmount < thresholdArray[count]) {
					break;
				}
				else {
					if("OrderFixedAmountPromotion".equals(discountType.get(thresholdArray[count])))	{
						if(maxDiscount < discountList.get(thresholdArray[count])){
							maxDiscount = discountList.get(thresholdArray[count]);
						}
					}
					else {
						if(maxDiscount < discountList.get(thresholdArray[count]) * totalAmount / 100) {
							maxDiscount = discountList.get(thresholdArray[count]) * totalAmount / 100;
						}
					}
					count++;
				}
			}
			cart.setOrderLevelDiscount(maxDiscount);
		}
		else {
			cart.setOrderLevelDiscount(0);
		}
	}

	/**
	 * Overridden toString method to display contents in a following pattern.
	 * 
	 * @return result string of desired pattern.
	 */
	@Override
	public String toString() {
		String result = "";
		String[] promoDetails;
		for (String promo : orderPromoList) {
			promoDetails = promo.split(",");
			if("OrderFixedAmountPromotion".equals(promoDetails[0])) {
				result += "Get Rs. " + promoDetails[1] + "  discount on order above - Rs. " 
						+ promoDetails[2] + "\n";
			}else {
				result += "Get " + promoDetails[1] + "%  discount on order above - Rs. " 
						+ promoDetails[2] + "\n";
			}
		}

		return result;
	}
}
