package com.kang.oop01;

//function(함수) 	: class 밖에서 만드는 것 <<Java에는 없음
//method(메소드)	: class 안에서 만드는 것

//라이브러리용 class - 객체를 찍어내는 틀, 도장같이
public class Transportation {
	// 속성(field, member variable, attribute)
	//		객체의 데이터가 저장되는 곳
	//		예) 에어컨 : 풍향, 풍속, 온도
	String type; // 어떤걸 타고 왔는지
	String number; //노선번호
	int fee;	//교통요금
	boolean seat; //좌석여부
	String station; // 하차 역

	
	
	
	
	

	// 동작(method)
	//		액션, 프로그램 상 필요한 기능, 객체의 동작에 해당하는 실행블록
	//		예) 끄다,켜다
	public void go() { //static이 없는 method
		System.out.println("칙칙폭폭");
	}
	
	public void printInfo() {
		System.out.println("내가 타고 온 대중교통 : " + type);
		// this : 자기자신(객체로 꺼냈을 때 해당하는)을 가리킴 << 생략가능
		System.out.println(number);
		System.out.println(fee);
		System.out.println(seat);
		System.out.println(station);
	}
}
