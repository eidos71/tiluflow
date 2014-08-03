package org.tiluflow.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author eidos71
 *
 */
@Entity
@DiscriminatorValue("CUST")
public class Customer  extends User  {
	  /**
	 * 
	 */
	private static final long serialVersionUID = -7684752528445465036L;

	private String customerCode;
	    
	    public Customer(){
	    	
	    }
	 
		public Customer(String username, String password, String name, String customerCode)  {
	    	this.setName(username); 
	    	this.setPassword(password);
	    	this.setName(name);
	    	this.customerCode=customerCode;
	        }
	    
	@Override
		public String toString() {
			return "User [username=" + this.getUsername()+ ", name=" + this.getName() + "]";
		}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}




}
