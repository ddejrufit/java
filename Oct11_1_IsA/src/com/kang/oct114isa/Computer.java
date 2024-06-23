package com.kang.oct114isa;

public class Computer extends Product {
	String cpu;
	int ram;
	int hdd;
public Computer() {
	// TODO Auto-generated constructor stub
}

@Override
public void print() {
	// TODO Auto-generated method stub
	super.print();
	System.out.println(cpu);
	System.out.println(ram+"GB");
	System.out.println(hdd+"GB");
}

}
