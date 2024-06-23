package com.kang.oct111hasa;

public class Dish {
String name;
int price;
Menu putin;

public Dish() {
	// TODO Auto-generated constructor stub
}







public Dish(String name, int price, Menu putin) {
	super();
	this.name = name;
	this.price = price;
	this.putin = putin;
}







public void printInfo() {
	System.out.println("품명:"+name);
	System.out.println(price+"원");

}
}
