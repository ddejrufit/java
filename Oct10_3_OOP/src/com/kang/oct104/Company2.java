package com.kang.oct104;

public class Company2 {
String name;
String location;
int employee;

public Company2() {
	// TODO Auto-generated constructor stub
}

public Company2(String name, String location, int employee) {
	super();
	this.name = name;
	this.location = location;
	this.employee = employee;
}
public void printInfo() {
	System.out.println(name);
	System.out.println(location);
	System.out.println(employee);
}
}
