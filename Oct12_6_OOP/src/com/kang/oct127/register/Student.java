package com.kang.oct127.register;

// Java - JSP Model 2 - EJB(Enterprise Java Bean)
//		어렵다, 무겁다, ...
// Winter
//		-> Spring

// Java : 커피이름

// 라이브러리용 클래스 이름 :
// 1. JavaBean, 2. POJO(Plain Old Java Object)
// 3. DTO(Data Temporary Object),DTO(Data Transfer Object)

public class Student {
	private int num;
	private String name;
	private int age;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int num, String name, int age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
	}
	public void printInfo() {
		System.out.println(num);
		System.out.println(name);
		System.out.println(age);
	}

}
