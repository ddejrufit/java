package com.kang.oct112hasa;

public class TV {
String name;
int price;


public TV() {
	// TODO Auto-generated constructor stub
}


public TV(String name, int price) {
	super();
	this.name = name;
	this.price = price;
}

public void printOn() {
	System.out.println("띠리링");
}

public void printInfo() {
	System.out.println(name);
	System.out.println(price+"원");
}
}
