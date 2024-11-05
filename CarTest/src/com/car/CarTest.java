package com.car;
import java.util.*;

public class CarTest {
	static Set Brands = new TreeSet();
	static List Garage = new LinkedList();
	
	public static void PrintData() {
		System.out.println("銷售品牌:"+Brands);
		System.out.println("現有車輛:"+Garage);
	}
	public static void main(String args[]) {	
		Scanner sc = new Scanner(System.in);
		
		while (Garage.size() < 5) {
			System.out.print("輸入汽車品牌:");
			String buy = sc.nextLine();
			if(!Brands.contains(buy)) {
				System.out.println("新增品牌:"+buy);
				Brands.add(buy);
			}
			else
				System.out.println("現有品牌:"+buy);
			Garage.add(buy);			
		}
		PrintData();
		
		System.out.print("輸入欲購買品牌:");
		String sell = sc.nextLine();
		
		while(!sell.equalsIgnoreCase("Quit") || Garage.isEmpty()) {			
			if(Brands.contains(sell)) {
				int index = Garage.indexOf(sell);
				Garage.remove(index);
				System.out.println(sell+"已售出");
				if(!Garage.contains(sell))
					Brands.remove(sell);
			}
			else 
				System.out.println(sell+"沒有銷售");
			System.out.print("輸入欲購買品牌:");
			sell = sc.nextLine();
		}
		PrintData();
	}
	
}