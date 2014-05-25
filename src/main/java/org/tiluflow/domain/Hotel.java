package org.tiluflow.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.util.StringUtils;

@Entity
public class Hotel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5905989568610009521L;

	private String name;

	private String address;

	private String city;

	private String state;

	private String zip;
    @Column(precision = 6, scale = 2)
	public BigDecimal getPrice() {
		return price;
	}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	private String country;

	private BigDecimal price;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		 return ToStringBuilder.reflectionToString(this);
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



	public String getCity() {
		return city;
	}



	public String getState() {
		return state;
	}



	public String getZip() {
		return zip;
	}



	public String getCountry() {
		return country;
	}

    /**
     * Gets a builder which is used to create Person objects.
     * @param firstName The first name of the created user.
     * @param lastName  The last name of the created user.
     * @return  A new Builder instance.
     */
    public static Builder getBuilder(final String address, final String city, final String country, final String name,
    		final BigDecimal price, final String state, final String zip) {
        return new Builder(address, city, country, name, price, state, zip);
    }
    /**
     * A Builder class used to create new Person objects.
     */
    public static class Builder {
        Hotel built;

        /**
         * Creates a new Builder instance.
         * @param firstName The first name of the created Person object.
         * @param lastName  The last name of the created Person object.
         */
        Builder(final String address, final String city, final String country, final String name,
        		final BigDecimal price, final String state, final String zip) {
            built = new Hotel();
            built.address = address;
            built.city = city;
            built.country=country;
            built.name=name;
            built.price=price;
            built.state=state;
            built.zip= zip;
        }

        /**
         * Builds the new Person object.
         * @return  The created Person object.
         */
        public Hotel build() {
            return built;
        }
    }
	public void update(String address, String city, String country,
			BigDecimal price) {
		 	this.address = StringUtils.isEmpty(address)?this.address:address;
		 	this.city = StringUtils.isEmpty(city)?this.city:city;
		 	this.price=(price==null)?this.price:price;
		 	
		 	
	}

}
