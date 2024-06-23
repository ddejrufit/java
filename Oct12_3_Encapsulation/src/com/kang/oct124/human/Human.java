package com.kang.oct124.human;

// Encapsulation(캡슐화)
// 		member variable(멤버변수) 외부에서 직접 접근 못하게
//		private 걸어 두는 작업
//		멤버변수에 접근할 수 있는 통로를 따로 만들고 그 통로에 안전장치

public class Human {
	private String name;
	private int age;

	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// public : 외부에서 직접 접근이 가능
	// getters and setters : ctrl + shift + z
	// 메소드 명이 get으로 시작하는 건: 받아오는거
	// 메소드 명이 set으로 시작하는 건 : 세팅하는 거
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0) {
			age *= -1;
		}
		this.age = age;
	}

	public void printInfo() {
		System.out.println(name);
		System.out.println(age);

	}

}
