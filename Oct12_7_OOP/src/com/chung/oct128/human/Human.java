package com.chung.oct128.human;

import com.chung.mar281.avengers.Avengers;

public class Human {
 private String name;
private Avengers hero;
public Human() {
	// TODO Auto-generated constructor stub
}

public Human(String name) {
	super();
	this.name = name;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public void pick(Avengers s) {
	hero =s;
	System.out.println("두두등장");
}

public void helpAAAAAA() {
	hero.attack();
}
	
}
