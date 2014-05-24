package org.tiluflow.domain;

import javax.persistence.Column;
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
@Table(name = "Customer")
public class User    {
	  /**
	 * 
	 */
	private static final long serialVersionUID = -7684752528445465036L;

	private String username;

	    private String password;

	    private String name;
	    
	    public User(){
	    	
	    }
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private Integer id;

	    public Integer getId() {
	      return id;
	    }    
	    public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public User(String username, String password, String name) {
	    	this.username = username;
	    	this.password = password;
	    	this.name = name;
	        }
	    
	    
	@Override
		public String toString() {
			return "User [username=" + username + ", name=" + name + "]";
		}




}
