package com.kang.oct111hasa;

public class Merchant {
	String name;
	Market employee;
	
	public Merchant() {
		// TODO Auto-generated constructor stub
	}

	public Merchant(String name, Market employee) {
		super();
		this.name = name;
		this.employee = employee;
	}
	
	public void printInfo() {
		System.out.println("그릇 판매자:"+name);
	
	}

}
