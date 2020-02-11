package com.novogold.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Region {
	@Id
	private int region_id;
	private String region_name;
	
	
	public Region() {
		super();
	}


	public Region(int region_id, String region_name) {
		super();
		this.region_id = region_id;
		this.region_name = region_name;
	}


	public int getRegion_id() {
		return region_id;
	}


	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}


	public String getRegion_name() {
		return region_name;
	}


	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}


	@Override
	public String toString() {
		return "Region [region_id=" + region_id + ", region_name=" + region_name + "]";
	}
	
	
}
