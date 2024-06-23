package com.kang.oct115isa;

public class Kimsol extends Person {
	String level;
	
	
	





	public Kimsol(String name, int years, String grup, String level) {
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
