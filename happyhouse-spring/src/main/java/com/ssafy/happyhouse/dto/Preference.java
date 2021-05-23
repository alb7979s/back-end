package com.ssafy.happyhouse.dto;

import java.util.Arrays;

public class Preference {
	private String type;
	private String city;	
	private String gugun;
	private String dong;
	private String floor_high;
	private String[] facilities;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getFloor_high() {
		return floor_high;
	}
	public void setFloor_high(String floor_high) {
		this.floor_high = floor_high;
	}
	public String[] getFacilities() {
		return facilities;
	}
	public void setFacilities(String[] facilities) {
		this.facilities = facilities;
	}
	@Override
	public String toString() {
		return "Preference [type=" + type + ", city=" + city + ", gugun=" + gugun + ", dong=" + dong + ", floor_high="
				+ floor_high + ", facilities=" + Arrays.toString(facilities) + "]";
	} 
	
}
