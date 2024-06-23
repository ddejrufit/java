package com.kang.oct103;

public class Candy {
	String name;
	String flavor;
	//사탕의 제조사 속성
	Company brand;
	public Candy() {
		// TODO Auto-generated constructor stub
	}
	
	public Candy(String name, String flavor) {
		super();
		this.name = name;
		this.flavor = flavor;
	}

	public void printInfo() {
		System.out.println("============================");
		System.out.println("사탕 이름 : " + name);
		System.out.println("사탕 맛 : " + flavor);
		System.out.println("============================");
	}
}
