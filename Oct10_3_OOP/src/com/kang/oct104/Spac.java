package com.kang.oct104;

public class Spac {
String cpu;
int ram;
int hdd;
Company2 brand;
public Spac() {
	// TODO Auto-generated constructor stub
}





public Spac(String cpu, int ram, int hdd, Company2 brand) {
	super();
	this.cpu = cpu;
	this.ram = ram;
	this.hdd = hdd;
	this.brand = brand;
}





public void printInfo() {
	System.out.println(cpu);
	System.out.println(ram);
	System.out.println(hdd);
	brand.printInfo();
}

}
