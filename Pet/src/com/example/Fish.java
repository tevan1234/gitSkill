package com.example;

public class Fish extends Animal implements Pet{

	public Fish() {
		super(0);
	}
	
	public void play() {
		System.out.println("餵牠飼料");
	}
	
	@Override
	public void eat() {
		System.out.println("大魚吃小魚");
	}

	@Override
	public void walk() {
		System.out.println("魚沒有腳,只會游泳");
	}

	
}
