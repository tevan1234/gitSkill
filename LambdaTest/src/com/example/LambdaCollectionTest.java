package com.example;

import java.util.*;

public class LambdaCollectionTest {

    public static void main(String[] args) {
        List<Person> personList = Person.createList();
        
        // 使用 Lambda Expression 定義以LastName來升冪排序  
        Collections.sort(personList,(p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
        /*Collections.sort(personList, new Comparator<Person>() {
        	public int compare(Person o1,Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
        });*/
    
        // 使用 Lambda Expression 定義以Age來降冪排序         
        Collections.sort(personList, (p1,p2) -> p2.getAge()-p1.getAge());
        
        // 使用 Lambda Expression 定義移除所有女性成員        
        //personList.removeIf(p -> p.getGender() == Gender.FEMALE);
        
        // 使用 Lambda Expression 定義移除年齡小於35成員     
        personList.removeIf(p -> p.getAge()<35);
        for(Person p:personList) {
        	System.out.print(p);
        }
    }
}