package com.example.domain;

public class Engineer extends Employee implements RegularStaff{
	private String[] skills;
	private int skillcount=0;
	public Engineer(String name, String ssn, double salary,Branch branch) {
		super(name, ssn, salary,branch);
		this.skills = new String[5];
	}
	
	public double getBonous() {
		return this.getSalary()*calcPerMultiplier();
		
	}
	
	public void addSkill(String skills) {
		if(skillcount<5) {
			this.skills[skillcount] = skills;
			skillcount++;
		}
		else
			System.out.println("最多註冊5種技能,新增失敗!");
	}

	public void getSkills() {
		for(int i=0;i<5;i++) {
			System.out.print(skills[i]+" ");
		}
	}

	@Override
	public double getpay() {
		return (this.getSalary()+3000*skillcount);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		if(skillcount>0) {
			sb.append("技能:");
			for(int i=0;i<skillcount;i++) {
				sb.append(skills[i]+" ");
			}
			sb.append("\n");
		}			
		return sb.toString();
	}
}
