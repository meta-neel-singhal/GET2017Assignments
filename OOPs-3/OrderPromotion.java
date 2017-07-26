import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 
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
	 * 
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
	 * @param totalAmount
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
	 * @param cart
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
	 * 
	 */
	@Override
	public String toString() {
		String result = "";
		String[] promoDetails;
		for (String promo : orderPromoList) {
			promoDetails = promo.split(",");
			if("OrderFixedAmountPromotion".equals(promoDetails[0])) {
				result += "Get Rs. " + promoDetails[1] + "  discount on order above - Rs. " + promoDetails[2] + "\n";
			}else {
				result += "Get " + promoDetails[1] + "%  discount on order above - Rs. " + promoDetails[2] + "\n";
			}
		}

		return result;
	}
}
