/**
 * 
 */
package com.novogold.bean;

/**
 * @author Mahesh
 *
 */
public class Crops {

	private int crops_id;
	private String crops_type;
	
	/**
	 * 
	 */
	public Crops() {
		// TODO Auto-generated constructor stub
	}

	public Crops(int crops_id, String crops_type) {
		super();
		this.crops_id = crops_id;
		this.crops_type = crops_type;
	}

	/**
	 * @return the crops_id
	 */
	public int getCrops_id() {
		return crops_id;
	}

	/**
	 * @param crops_id the crops_id to set
	 */
	public void setCrops_id(int crops_id) {
		this.crops_id = crops_id;
	}

	/**
	 * @return the crops_type
	 */
	public String getCrops_type() {
		return crops_type;
	}

	/**
	 * @param crops_type the crops_type to set
	 */
	public void setCrops_type(String crops_type) {
		this.crops_type = crops_type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Crops [crops_id=" + crops_id + ", crops_type=" + crops_type + "]";
	}

	
}
