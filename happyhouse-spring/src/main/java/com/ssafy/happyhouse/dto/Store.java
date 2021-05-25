package com.ssafy.happyhouse.dto;

public class Store {
	private String business_name;
	private String small_classify_name;
	private String roadnames_address;
	private float lat;
	private float lng;

	
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getSmall_classify_name() {
		return small_classify_name;
	}
	public void setSmall_classify_name(String small_classify_name) {
		this.small_classify_name = small_classify_name;
	}
	public String getRoadnames_address() {
		return roadnames_address;
	}
	public void setRoadnames_address(String roadnames_address) {
		this.roadnames_address = roadnames_address;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLng() {
		return lng;
	}
	public void setLng(float lng) {
		this.lng = lng;
	}
	@Override
	public String toString() {
		return "Store [business_name=" + business_name + ", small_classify_name=" + small_classify_name
				+ ", roadnames_address=" + roadnames_address + ", lat=" + lat + ", lng=" + lng + "]";
	}
	
	
	
}
