package com.novogold.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int user_id;
	private String user_name;
	private String password;
	private double latitude;
	private double longitude;
	
	public User() {
		super();
	}
	
	public User(String user_name, String password) {
		super();
		this.user_name = user_name;
		this.password = password;
	}

	public User(int user_id, String user_name, String password) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
	}
	
	
	/**
	 * @param user_id
	 * @param user_name
	 * @param password
	 * @param latitude
	 * @param longitude
	 */
	public User(int user_id, String user_name, String password, double latitude, double longitude) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUser_id() {
		return user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public String getPassword() {
		return password;
	}
	
	
	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}
	
	
	
	
}
