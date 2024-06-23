package com.kang.oct113isa;
//아무것도 상속받지 않으면 extends Object가 생략된 것과 같음
//Animal is a  Object(java 객체)
public class Animal {
	//속성(sort,age)
String sort;
int age;


public Animal() {
	// TODO Auto-generated constructor stub
}

public Animal(String sort, int age) {
	super(); // 모든 라이브러리용 클래스는 object를 상속 받는 중이다
	this.sort = sort;
	this.age = age;
}
public void printInfo() {
	System.out.println(sort);
	System.out.println(age);
}


}
