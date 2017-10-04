package com.metacube.shoppingcart.modal;

/**
 * The class Product.
 * 
 * @author Neel Singhal
 */
public class Product {
	private int id;
	private String name;
	private double price;
	private String img;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

  /**
   * Use to print Product in string format.
   *
   * @return String format of product
   */
    @Override
    public String toString() {
        return name + "\t\t"  + id + "\t\t" + price;
    }
}
