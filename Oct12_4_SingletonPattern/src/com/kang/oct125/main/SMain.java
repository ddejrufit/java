package com.kang.oct125.main;

import com.kang.oct125.person.Myself;

//pattern progaramming - software design pattern
//		패턴프로그래밍 - 소트웨어 디자인 패턴
//			싱글턴패턴 (singleton pattern)
//				: class가 최초에 한번만 메모리 할당을 하고(static),
//					그 메모리에 객체를 만들어 사용하는 디자인 패턴
//					생성자가 여러번 호출되더라도 실제 생성된 객체는 하나
//					최초의 생성 이후에 호출된 생성자는 
//					최초의 생성자가 생성한 객체를 ㄹ기턴

//	한번의 객체 생성으로 재사용이 가능 >> 메모리 낭비를 방지

// Spring : singleton pattern 편하게 사용하기 위해
// DataBase Connection Pool
public class SMain {
	public static void main(String[] args) {
//		Calendar c = Calendar.getInstance();// new Calendat가 아님!!
//		System.out.println(c.getTimeZone());

//		Myself ms = new Myself(); // private로 잠가놔서 새 객체 못만듬
		Myself ms = Myself.getMyself(); // Myself에서 만든 객체 꺼내오기
		System.out.println(ms);// 번지값 : Myself@2a139a55
		ms.printInfo();
		ms.setName("chan");
		ms.printInfo();
		System.out.println("-------------------");
		Myself ms1 = Myself.getMyself();
		System.out.println(ms1);// Myself@2a139a55
		ms1.printInfo(); // 복사(copy)의 개념
	}

}
