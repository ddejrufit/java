package com.kang.oct111hasa;

public class People {
	String name;
	String sex;
	String num;

	public People() {
		// TODO Auto-generated constructor stub
	}

	public People(String name, String sex, String num) {
		super();
		this.name = name;
		this.sex = sex;
		this.num = num;

	}

	public void printInfo() {
		System.out.println(name);
		System.out.println(sex);
		System.out.println(num);

	}

}
