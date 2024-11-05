package com.example;

public class MyStringAnalyzer implements StringAnalyzer {
	@Override
	public boolean analyze(String target, String searchStr) {
		return target.contains(searchStr);
	}

}
