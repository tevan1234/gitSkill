package com.example;

import java.io.*;
import java.io.FileReader;

public class ExceptionMain {
	public static void main(String[] args) {
		try{
			System.out.println("Reading From file:"+args[0]);
		}
		catch(ArrayIndexOutOfBoundsException ex){
			System.out.println("未輸入讀取檔名，程式結束!");
			System.exit(0);
		}
		
		try (BufferedReader b = new BufferedReader(new FileReader(args[0]))){
			
			String s = null;
			while((s = b.readLine()) != null) {
				System.out.println(s);
			}
		}
		catch(FileNotFoundException ex) {
			System.out.println("檔名錯誤!");
		}
		catch(IOException ex) {
			System.out.println("檔名讀取失敗!");
		}		
	}
}
