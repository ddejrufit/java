package com.kang.oct114isa;

public class Laptop extends Product {
	double weight;
	int battery;
	
	
 @Override
public void print() {
	// TODO Auto-generated method stub
	super.print();
	System.out.println(weight+"kg");
	System.out.println(battery+"%");
}

}
