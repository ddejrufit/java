package com.kang.oct202.student;

public class Student {
private String name;
private int	k;
private int y;
private int s;
public Student() {
	// TODO Auto-generated constructor stub
}
public Student(String name, int k, int y, int s) {
	super();
	this.name = name;
	this.k = k;
	this.y = y;
	this.s = s;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getK() {
	return k;
}
public void setK(int k) {
	this.k = k;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public int getS() {
	return s;
}
public void setS(int s) {
	this.s = s;
}
public void printInfo() {
	System.out.println(name);
	System.out.println(k);
	System.out.println(y);
	System.out.println(s);
}
}
