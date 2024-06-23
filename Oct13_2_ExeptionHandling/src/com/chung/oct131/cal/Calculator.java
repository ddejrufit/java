package com.chung.oct131.cal;

import java.util.Scanner;

public class Calculator {
//	1. 여기에서 끝장을 보자
	public static int divide(int price, int weight) {
		try {
			int d = price / weight;
			return d;
		} catch (Exception e) {
		System.out.println("으엑");
		return -9999;
		}finally {
			System.out.println("ㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
		}
	}
		
	
	
	
	
	// 2.미루기
	//		divide2를 호출할 쪽에서 해결해라(main가 알아서 excaption handling해라)
	private static int divide2(int price, int weight) throws { /*Arithmetic*/Exception{
		int d = price / weight;
		return d;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//int price;
//int weight;
//public Calculator() {
//	// TODO Auto-generated constructor stub
//}
//public Calculator(int price, int weight) {
//	super();
//	this.price = price;
//	this.weight = weight;
//}
//Scanner k = new Scanner(System.in);
//public void putin() {
//	System.out.print("가격 :");
//	price = k.nextInt();
//	System.out.print("무게:");
//	weight = k.nextInt();
//}
//	public void result(int a, int b) {
//		int c = price / weight ;  
//		System.out.printf("g당 가격은 %d원/g \r\n",c);
//	}
//
//
//	
//
//public void printInfo() {
//	System.out.println(price+"원");
//	System.out.println(weight+"g");
//}
}
