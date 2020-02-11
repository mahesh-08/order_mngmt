/**
 * 
 */
package com.novogold.bean;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Mahesh
 *
 */

public class Order {

	private int crop_id;
	private int product_id;
	@Autowired
	private Packages packages;
	/**
	 * 
	 */
	public Order() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param crop_id
	 * @param product_id
	 * @param packages
	 */
	public Order(int crop_id, int product_id, Packages packages) {
		super();
		this.crop_id = crop_id;
		this.product_id = product_id;
		this.packages = packages;
	}
	/**
	 * @return the crop_id
	 */
	public int getCrop_id() {
		return crop_id;
	}
	/**
	 * @param crop_id the crop_id to set
	 */
	public void setCrop_id(int crop_id) {
		this.crop_id = crop_id;
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
	 * @return the packages
	 */
	public Packages getpackages() {
		return packages;
	}
	/**
	 * @param packages the packages to set
	 */
	public void setpackages(Packages packages) {
		this.packages = packages;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [crop_id=" + crop_id + ", product_id=" + product_id + ", packages=" + packages + "]";
	}
	
	
	

}
