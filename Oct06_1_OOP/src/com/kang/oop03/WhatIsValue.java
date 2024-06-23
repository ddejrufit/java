package com.kang.oop03;

public class WhatIsValue {
	// 기본형 - 정수
	byte byteF;
	short shortF;
	int intF;
	long longF;

	// 기본형 - 실수
	float floatF;
	double doubleF;

	// 기본형 - 논리, 문자열
	boolean booleanF;
	char charF;

	// 참조형
	String StringF;
	int[] arrayF;

	public void printInfo() {
		System.out.println("byte :" + byteF);
		System.out.println("short :" + shortF);
		System.out.println("int :" + intF);
		System.out.println("long : " + longF);
		System.out.println("float :" + floatF);
		System.out.println("double :" + doubleF);
		System.out.println("boolean : " + booleanF);
		System.out.println("char : " + charF);
		System.out.println("String" + StringF);
		System.out.println("array : " + arrayF);
	}
}
