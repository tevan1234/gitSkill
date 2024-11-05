package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
	
	@GetMapping("/hi")
	@ResponseBody		//將方法返回值回傳
	public String sayHi() {
		return "Hi";
	}
	
	@GetMapping("/yes")
	@ResponseBody		
	public String SayYes(){
		return "Yes";
	}
	
	@GetMapping("/today")
	//@ResponseBody		
	public String today(){
		return "today";  // 預設透過 application.properties 裡面的 jsp 配置去找 today.jsp
	}
}
