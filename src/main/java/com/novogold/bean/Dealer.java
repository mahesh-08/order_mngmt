package com.novogold.bean;

public class Dealer {

	
	private int dealer_id;
	private String dealer_name;
	private int region_id;
	private String address;
	
	
	
	
	public Dealer() {
		super();
	}
	public Dealer(int dealer_id, String dealer_name, int region_id, String address) {
		super();
		this.dealer_id = dealer_id;
		this.setDealer_name(dealer_name);
		this.setRegion_id(region_id);
		this.setAddress(address);
	}
	public int getDealer_id() {
		return dealer_id;
	}
	public void setDealer_id(int dealer_id) {
		this.dealer_id = dealer_id;
	}
	public String getDealer_name() {
		return dealer_name;
	}
	public void setDealer_name(String dealer_name) {
		this.dealer_name = dealer_name;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dealer [dealer_id=" + dealer_id + ", dealer_name=" + dealer_name + ", region_id=" + region_id
				+ ", address=" + address + "]";
	}
	
	
	
}
