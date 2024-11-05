package com.example.domain;

public class Admin extends Employee{
	private int hours;
	public Admin(String name,String ssn,double salary,Branch branch) {
		super(name,ssn,salary,branch);
		this.hours = 160;
	}
	
	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public double getpay(){
		return(this.getSalary()*hours/160);		
	}
}
