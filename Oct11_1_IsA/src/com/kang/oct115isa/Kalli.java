package com.kang.oct115isa;

public class Kalli extends Person {
	String level;
	
public Kalli() {
	// TODO Auto-generated constructor stub
}


public Kalli(String name, int years, String grup, String level) {
	super(name, years, grup);
	this.level = level;
}


@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println(level);
	}




}
