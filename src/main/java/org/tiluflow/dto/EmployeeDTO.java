package org.tiluflow.dto;

public class EmployeeDTO {
	
	private final  String userName;
	private final String password;
	private final String name;
	private final String employeeCode;

	public EmployeeDTO(final String username, final  String password, final String name, 
			final String employeeCode) {
		this.userName=username;
		this.password=password;
		this.name=name;
		this.employeeCode=employeeCode;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [userName=" + userName + ", password=" + password
				+ ", name=" + name + ", employeeCode=" + employeeCode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employeeCode == null) ? 0 : employeeCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		if (employeeCode == null) {
			if (other.employeeCode != null)
				return false;
		} else if (!employeeCode.equals(other.employeeCode))
			return false;
		return true;
	}
	

}
