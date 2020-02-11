package com.novogold.bean;

public class DealerOrderDetails {

	private int dealer_id;
	private String dealer_name;
	private int item_quantity;
	private int total_weight;
	
	public DealerOrderDetails() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dealer_id
	 * @param dealer_name
	 * @param item_quantity
	 * @param total_weight
	 */
	public DealerOrderDetails(int dealer_id, String dealer_name, int item_quantity, int total_weight) {
		super();
		this.dealer_id = dealer_id;
		this.dealer_name = dealer_name;
		this.item_quantity = item_quantity;
		this.total_weight = total_weight;
	}

	/**
	 * @return the dealer_id
	 */
	public int getDealer_id() {
		return dealer_id;
	}

	/**
	 * @param dealer_id the dealer_id to set
	 */
	public void setDealer_id(int dealer_id) {
		this.dealer_id = dealer_id;
	}

	/**
	 * @return the dealer_name
	 */
	public String getDealer_name() {
		return dealer_name;
	}

	/**
	 * @param dealer_name the dealer_name to set
	 */
	public void setDealer_name(String dealer_name) {
		this.dealer_name = dealer_name;
	}

	/**
	 * @return the item_quantity
	 */
	public int getItem_quantity() {
		return item_quantity;
	}

	/**
	 * @param item_quantity the item_quantity to set
	 */
	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}

	/**
	 * @return the total_weight
	 */
	public int getTotal_weight() {
		return total_weight;
	}

	/**
	 * @param total_weight the total_weight to set
	 */
	public void setTotal_weight(int total_weight) {
		this.total_weight = total_weight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DealerOrderDetails [dealer_id=" + dealer_id + ", dealer_name=" + dealer_name + ", item_quantity="
				+ item_quantity + ", total_weight=" + total_weight + "]";
	}
	

}
