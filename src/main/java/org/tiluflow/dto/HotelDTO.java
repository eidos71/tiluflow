package org.tiluflow.dto;

import java.math.BigDecimal;




import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

public class HotelDTO {

	private Integer id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String address;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	@NotEmpty
	private String zip;
	@NotEmpty
	private String country;
	@NotEmpty
	private BigDecimal price;
	
	public  HotelDTO() 
	{
		
	}
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
