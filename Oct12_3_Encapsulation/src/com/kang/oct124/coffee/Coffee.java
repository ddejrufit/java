package com.kang.oct124.coffee;

public class Coffee {
	// 캡슐화 시켜서 이름, 가격
	private String name;
	private int price;
	// 기본생성자(constructor)
	public Coffee() {
		// TODO Auto-generated constructor stub
	}
	//생성자 오버로딩(constructor overloading)
	public Coffee(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	// getters/setters/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	// 정보출력	
	public void printInfo() {
		System.out.println(name);
		System.out.println(price);
	}
}
