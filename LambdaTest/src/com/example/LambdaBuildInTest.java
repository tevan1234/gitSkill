package com.example;

import java.util.List;
import java.util.function.*;

public class LambdaBuildInTest {

    public static void main(String[] args) {
        List<Person> personList = Person.createList();
        
        // 使用 Lambda Expression 定義以Function 函式介面,傳回稱謂(姓名前加上Ms./Mr.)
        System.out.println("=====成員稱謂=====");
        Function<Person, String> nameformatter = p -> (p.getGender() == Gender.MALE ? "Mr. " : "Ms. ")+ p.getLastName();
        
        for(Person p:personList)
        	System.out.println(nameformatter.apply(p));
        
        
        
        // 使用 Lambda Expression 定義Predicate 函式介面,篩選列印30歲以下的Person資訊
        System.out.println("=====30歲以下成員=====");
        Predicate<Person> youngMember = p -> p.getAge()<=30;
        for(Person p:personList) {
        	if(youngMember.test(p))
        		System.out.println(p);
        }
        
        // 使用 Lambda Expression 定義以Comsumer 函式介面以FirstName(age)格式來列印Person資訊           
        System.out.println("=====自訂列印=====");
        Consumer<Person> printer = p -> System.out.printf("%s(%d)%n", p.getFirstName(),p.getAge());
        
        for(Person p:personList) {
        	printer.accept(p);
        }
        
        
    }
    
}
