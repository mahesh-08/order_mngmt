/**
 * 
 */
package com.novogold.bean;

/**
 * @author Mahesh
 *
 */
public class Sale {

	private int day;
	private int week;
	private int oneMonth;
	private int fourMonth;
	private int year;
	/**
	 * 
	 */
	public Sale() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param day
	 * @param week
	 * @param oneMonth
	 * @param fourMonth
	 * @param year
	 */
	public Sale(int day, int week, int oneMonth, int fourMonth, int year) {
		super();
		this.day = day;
		this.week = week;
		this.oneMonth = oneMonth;
		this.fourMonth = fourMonth;
		this.year = year;
	}
	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}
	/**
	 * @return the week
	 */
	public int getWeek() {
		return week;
	}
	/**
	 * @param week the week to set
	 */
	public void setWeek(int week) {
		this.week = week;
	}
	/**
	 * @return the oneMonth
	 */
	public int getOneMonth() {
		return oneMonth;
	}
	/**
	 * @param oneMonth the oneMonth to set
	 */
	public void setOneMonth(int oneMonth) {
		this.oneMonth = oneMonth;
	}
	/**
	 * @return the fourMonth
	 */
	public int getFourMonth() {
		return fourMonth;
	}
	/**
	 * @param fourMonth the fourMonth to set
	 */
	public void setFourMonth(int fourMonth) {
		this.fourMonth = fourMonth;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sale [day=" + day + ", week=" + week + ", oneMonth=" + oneMonth + ", fourMonth=" + fourMonth + ", year="
				+ year + "]";
	}
	
	

}
