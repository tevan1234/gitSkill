package com.example.domain;
import java.util.ArrayList;

public class Manager extends Employee implements RegularStaff{
	private String deptName;
	private double baseBonous = 100000;
	protected ArrayList employees;
	
	public Manager(String name, String ssn, double salary,String deptname,Branch branch) {
		super(name, ssn, salary,branch);
		this.deptName = deptname;
		
		employees = new ArrayList();
	}

	public double getBonous() {
		return baseBonous*calcPerMultiplier();
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public boolean addEmployee(Employee emp) {
		if(employees.contains(emp)) {
			return false;
		}			
		else {
			employees.add(emp);
			return true;
		}			
	}
	
	public boolean removeEmployee(Employee emp) {
		if(employees.contains(emp)) {
			employees.remove(emp);
			return true;
		}
		else
			return false;
	}
	
	public void printStaffDetails()
	{
		if(!employees.isEmpty())
			System.out.printf("%s管理員工:",this.getName());		
		for(Object obj:employees)
		{
			if(obj instanceof Employee) {
				Employee emp = (Employee)obj;
				System.out.print(String.format("%s(%d)", emp.getName(),emp.getEmpId()));
			}						
		}
		System.out.println();
	}
	
	public String getStaffDetails() {
		StringBuilder sb = new StringBuilder();
		if(!employees.isEmpty())
			sb.append(String.format(this.getName()+"管理員工:"));		
		for(Object obj:employees)
		{
			if(obj instanceof Employee) {
				Employee emp = (Employee)obj;
				sb.append(String.format("%s(%d) ",emp.getName(),emp.getEmpId()));
			}						
		}
		sb.append("\n");
		return sb.toString();
	}
	
	@Override
	public double getpay() {
		return (this.getSalary()+employees.size()*2000);
	}
	
	@Override
	public String toString() {
		
		return super.toString()+"部門:"+deptName+"\n"+this.getStaffDetails();
	}		
}
