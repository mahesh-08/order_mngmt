/**
 * 
 */
package com.novogold.bean;

import javax.persistence.Entity;

/**
 * @author Mahesh
 *
 */

public class Packages {
	private int kg50;
	private  int kg20;
	private int kg10;
	private int kg5;
	private int kg1;
	
	public Packages(){
		
	}

	/**
	 * @param kg50
	 * @param kg20
	 * @param kg10
	 * @param kg5
	 * @param kg1
	 */
	public Packages(int kg50, int kg20, int kg10, int kg5, int kg1) {
		super();
		this.kg50 = kg50;
		this.kg20 = kg20;
		this.kg10 = kg10;
		this.kg5 = kg5;
		this.kg1 = kg1;
	}

	/**
	 * @return the kg50
	 */
	public int getKg50() {
		return kg50;
	}

	/**
	 * @param kg50 the kg50 to set
	 */
	public void setKg50(int kg50) {
		this.kg50 = kg50;
	}

	/**
	 * @return the kg20
	 */
	public int getKg20() {
		return kg20;
	}

	/**
	 * @param kg20 the kg20 to set
	 */
	public void setKg20(int kg20) {
		this.kg20 = kg20;
	}

	/**
	 * @return the kg10
	 */
	public int getKg10() {
		return kg10;
	}

	/**
	 * @param kg10 the kg10 to set
	 */
	public void setKg10(int kg10) {
		this.kg10 = kg10;
	}

	/**
	 * @return the kg5
	 */
	public int getKg5() {
		return kg5;
	}

	/**
	 * @param kg5 the kg5 to set
	 */
	public void setKg5(int kg5) {
		this.kg5 = kg5;
	}

	/**
	 * @return the kg1
	 */
	public int getKg1() {
		return kg1;
	}

	/**
	 * @param kg1 the kg1 to set
	 */
	public void setKg1(int kg1) {
		this.kg1 = kg1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Packages [kg50=" + kg50 + ", kg20=" + kg20 + ", kg10=" + kg10 + ", kg5=" + kg5 + ", kg1=" + kg1 + "]";
	}
	
}
