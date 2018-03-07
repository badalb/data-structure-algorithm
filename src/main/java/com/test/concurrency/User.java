package com.test.concurrency;

public class User {

	private String fName;

	private String lName;

	private Double salary;

	private String userId;

	public User(String fName, String lName, Double salary, String userId) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
		this.userId = userId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
