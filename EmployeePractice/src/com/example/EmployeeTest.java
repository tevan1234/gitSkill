package com.example;

import com.example.domain.*;

public class EmployeeTest {
	public static void main(String args[])
	{
		Employee[] emps = new Employee[5];
		emps[0] = new Admin("Alex","A132456789",50000,Branch.Taipei);		
		emps[1] = new Admin("Amy","A111111111",38000,Branch.London);
		emps[2] = new Manager("Tony","A222222222",60000,"TW Sales",Branch.Paris);
		emps[3] = new Engineer("Tom","A333333333",500000,Branch.Tokyo);
		emps[4] = new Director("Kevin","A444444444",80000,"Global Sales",100000,Branch.Paris);
		
		System.out.println("設定本月工時:Alex(160Hr),Amy(150Hr)");
		((Admin)emps[0]).setHours(160);
		((Admin)emps[1]).setHours(150);
								
		System.out.println(emps[3].getName()+"學會技能:java,Android");
		if(emps[3] instanceof Engineer) {
			Engineer eng = (Engineer)emps[3];
			eng.addSkill("java");
			eng.addSkill("Android");
		}
		
		System.out.println("部門分配------");
		if(emps[2] instanceof Manager) {
			Manager m = (Manager)emps[2];
			m.addEmployee(emps[0]);
			m.addEmployee(emps[1]);
			m.addEmployee(emps[3]);
		}
		((Manager)emps[4]).addEmployee(emps[2]);
		
		for(int i=0 ;i < emps.length ;i++)
		{
			//emps[i].display();	
			System.out.print(emps[i]);
			System.out.println("本月實領薪資:"+emps[i].getpay());
			if(emps[i] instanceof RegularStaff) {
				System.out.println("尾牙抽獎結果:"+RegularStaff.getLuckyDraw());
				System.out.println("年終獎金:"+((RegularStaff)emps[i]).getBonous());
			}
				
			
		}
		
		
		
		/*Engineer 為多型類別，父類別無addSkill方法
		emp4.addSkill("java");
		emp4.addSkill("Android");
		*/
	}
}
