package com.novogold.bean;

public class Products {

	private int product_id;
	private String product_name;
	/**
	 * 
	 */
	public Products() {
		super();
	}
	/**
	 * @param product_id
	 * @param product_name
	 */
	public Products(int product_id, String product_name) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
	}
	/**
	 * @return the product_id
	 */
	public int getProduct_id() {
		return product_id;
	}
	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}
	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", product_name=" + product_name + "]";
	}
	
	
}
