package com.kang.oct111hasa;

public class Restaurant {
	String name;
	String location;
	String num;
	People oner;

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	

	public Restaurant(String name, String location, String num, People oner ) {
		super();
		this.name = name;
		this.location = location;
		this.num = num;
		this.oner = oner;
		
	}



	public void printInfo() {
		System.out.println(name);
		System.out.println(location);
		System.out.println(num);
		
	
	}
}
