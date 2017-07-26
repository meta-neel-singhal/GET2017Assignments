import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Neel Singhal
 */
public class ProductPromotion implements Promotion {
	private List<String> productPromo;
	private  HashMap<Integer, Double> discountAmount = new HashMap<Integer, Double>();
	private  HashMap<Integer, String> discountType = new HashMap<Integer, String>();

	public List<String> getProductPromo() {
		return productPromo;
	}

	public void setProductPromo(List<String> productPromo) {
		this.productPromo = productPromo;
	}

	public HashMap<Integer, Double> getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(HashMap<Integer, Double> discountAmount) {
		this.discountAmount = discountAmount;
	}

	public HashMap<Integer, String> getDiscountType() {
		return discountType;
	}	

	public void setDiscountType(HashMap<Integer, String> discountType) {
		this.discountType = discountType;
	}

	public ProductPromotion() {
		initProductPromo();
	}

	/**
	 * 
	 */
	public void initProductPromo() {
		productPromo = new FileHandling().read(Constants.PRODUCT_PROMOTION_PATH);
		String[] details;
		String promotionType;
		Double discount;
		String[] discountProductId;
		for (String str : productPromo) {
			details = str.split("\\,");
			promotionType = details[0];
			discount = Double.parseDouble(details[1]);
			discountProductId = details[2].split("\\;");
			for (int index = 0; index < discountProductId.length; index++) {
				discountAmount.put(Integer.parseInt(discountProductId[index]), discount);
				discountType.put(Integer.parseInt(discountProductId[index]), promotionType);
			}
		}
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean isApplicable(double id) {

		return discountAmount.containsKey((int)id);
	}

	/**
	 * @param cart
	 */
	public void getDiscount(Cart cart) {
		double discountPercentage = 0.0;
		double discountOffer = 0;
		for (CartProducts product : cart.getCartItems()) {
			int productId = product.getProductId();
			if (isApplicable(productId)) {
				if ("ProductFixedAmountPromotion".equals(discountType.get(productId))) {
					product.setDiscount(discountAmount.get(productId));

				} else {
					discountPercentage = discountAmount.get(productId);
					discountOffer = product.getProductPrice() * (discountPercentage) / 100;
					product.setDiscount(discountOffer);
				}
			} else {
				product.setDiscount(0);
			}
		}

	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		String result = "";
		String[] promoDetails;
		for (String promo : productPromo) {
			promoDetails = promo.split(",");
			if("ProductFixedAmountPromotion".equals(promoDetails[0])){
				result += "Get Rs. " + promoDetails[1] + " discount on these Products : " + promoDetails[2] + "\n";}
			else{
				result += "Get " + promoDetails[1] + "% discount on these Product : " + promoDetails[2] + "\n";
			}
		}

		return result;
	}
}

