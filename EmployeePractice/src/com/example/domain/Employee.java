package com.example.domain;

import java.text.NumberFormat;

public abstract class Employee {
	
	private static int nextId = 101;
	private int empId;
	private String name;
	private String ssn;
	private double salary;
	private Branch branch;
	protected NumberFormat formatter = NumberFormat.getInstance();
	
	public Employee(String name,String ssn,double salary,Branch branch) {		
		this.empId = nextId++;
		this.name = name;
		this.ssn = ssn;
		this.salary = salary;		
		this.branch = branch;
	}
	
	public abstract double getpay();
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (empId != other.empId) {
			return false;
		}
		if (ssn == null) {
			if (other.ssn != null) {
				return false;
			}
		} else if (!ssn.equals(other.ssn)) {
			return false;
		}
		return true;
	}



	public void setName(String name)
	{
		if(name.length()==0 || name.equals(" "))
			System.out.println("名字不能為空值");
		else
		{
			this.name = name;
		}
	}
	
	public void raiseSalary(int num)
	{
		if(num<0)
			System.out.println("加薪不能為負值");
		else
			this.salary += num;
	}
	
	public int getEmpId()
	{
		return(empId);
	}
	
	public String getName()
	{
		return(name);
	}
	
	public String getSsn()
	{
		return(ssn);
	}
	
	public double getSalary()
	{
		return(salary);
	}
	
	public Branch getBranch() {
		return branch;
	}

	@Override
	public String toString() {
		return "-----員工資訊-----\n" + 
				"編號: " + empId +
				"\n姓名: " + name +
				"\n身分證字號: " + ssn 
				+ "\n月薪: " +this.branch.getCurrency()+formatter.format(salary) +"\n";
	}

}
