package com.kang.oct115isa;

public class Person {
	String name;
	int years;
	String grup;
	
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, int years, String grup) {
		super();
		this.name = name;
		this.years = years;
		this.grup = grup;
		
	}
	
	public void print() {
		System.out.println(name);
		System.out.println(years);
		System.out.println(grup);
		
	}

}
