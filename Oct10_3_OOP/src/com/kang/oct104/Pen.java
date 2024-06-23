package com.kang.oct104;

public class Pen {
	String name;
	String color;
	Company brand;
	public Pen() {

		// TODO Auto-generated constructor stub
	}

	public Pen(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	public void printInfo() {
		System.out.println(name);
		System.out.println(color);
	}
}
