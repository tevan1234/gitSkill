package com.example;

public class Cat extends Animal implements Pet{

	private String name;
	
	public Cat() {
		super(4);
	}

	public Cat(String name) {
		super(4);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void play() {
		if(name!=null && name.length()!=0)
			System.out.printf("使用逗貓棒與%s玩耍%n",name);
		else
			System.out.printf("使用逗貓棒與牠玩耍%n");
	}

	@Override
	public void eat() {
		if(name!=null && name.length()!=0)
			System.out.println(name+"最喜歡吃魚");
		else
			System.out.println("貓最喜歡吃魚");			
	}

}
