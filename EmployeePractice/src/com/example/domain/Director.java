package com.example.domain;

public class Director extends Manager implements RegularStaff{
	private double budget;
	private double baseBonous = 500000;
	public Director(String name, String ssn, double salary, String deptname,double budget,Branch branch) {
		super(name, ssn, salary, deptname,branch);
		this.budget = budget;
		// TODO Auto-generated constructor stub
	}
	public double getBudget() {
		return budget;
	}
	
	public double getBonous(){
		return baseBonous*calcPerMultiplier();
	}
	
	@Override
	public String toString() {
		return super.toString()+"管理預算:"+this.formatter.format(budget)+"\n";
	}
	
	@Override
	public double getpay() {
		return (this.getSalary()+employees.size()*10000);
	}

}
