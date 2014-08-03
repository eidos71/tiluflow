package org.tiluflow.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * 
 * @author eidos71
 *
 */
@Entity
@DiscriminatorValue("EMP")
public class Employee extends User{


	private static final long serialVersionUID = 4140971070178109187L;
	
	private String employeeCode;
 
	/**
	 * 
	 */
	public Employee() {
		
	}
	/**
	 * 
	 * @param username
	 * @param password
	 * @param name
	 * @param employeeCode
	 */
	public  Employee(String username, String password, String name, String employeeCode) {
		this.setEmployeeCode(employeeCode);
    	this.setUsername(username); 
    	this.setPassword(password);
    	this.setName(name);
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public Employee(String employeeCode) {
		super();
		this.employeeCode = employeeCode;
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param name
	 * @param employeeCode
	 * @return
	 */
    public static Builder getBuilder(final String username, final String password, final String name, final  String employeeCode) {
        return new Builder(username, password, name, employeeCode);
    }
	/**
     * A Builder class used to create new Person objects.
     */
    public static class Builder {
        Employee built;

        /**
         * Creates a new Builder instance.
         * @param firstName The first name of the created Person object.
         * @param lastName  The last name of the created Person object.
         */
        Builder(final String username, final String password, final String name, final  String employeeCode) {
            built = new Employee();
            built.setEmployeeCode(employeeCode);
            built.setUsername(username); 
            built.setPassword(password);
            built.setName(name);

        }

        /**
         * Builds the new Person object.
         * @return  The created Person object.
         */
        public Employee build() {
            return built;
        }
    }

}
