/**
 * 
 */
package com.novogold.bean;

import java.util.List;

/**
 * @author Mahesh
 *
 */
public class OrderObject {

	
	private int user_id;
	private int dealer_id;
	List<Order> order;
	/**
	 * 
	 */
	public OrderObject() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param user_id
	 * @param dealer_id
	 * @param order
	 */
	public OrderObject(int user_id, int dealer_id, List<Order> order) {
		super();
		this.user_id = user_id;
		this.dealer_id = dealer_id;
		this.order = order;
	}
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	 * @return the order
	 */
	public List<Order> getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderObject [user_id=" + user_id + ", dealer_id=" + dealer_id + ", order=" + order + "]";
	}

	
	
	
}
