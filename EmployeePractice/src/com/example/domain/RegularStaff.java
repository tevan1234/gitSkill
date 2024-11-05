package com.example.domain;
import java.util.Random;

public interface RegularStaff {
	public String []gifts = {"汽車","機車","機票","餐卷","優惠卷","禮卷","銘謝惠顧"};
	public static String getLuckyDraw() {
		int index = new Random().nextInt(gifts.length);
		return gifts[index];
	}
	public default double calcPerMultiplier() {
		return (int)(Math.random()*5+1)*0.5;
	}
	public double getBonous();
}
