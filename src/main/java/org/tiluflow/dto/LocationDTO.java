package org.tiluflow.dto;

public class LocationDTO {
	private Integer longitude;
	private Integer latitude;
	private String name;
	public Integer getLongitude() {
		return longitude;
	}
	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}
	public Integer getLatitude() {
		return latitude;
	}
	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	LocationDTO(Integer latitude, Integer longitude, String name){
		this.latitude=latitude;
		this.longitude=longitude;
		this.name=name;
	}
}
