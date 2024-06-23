package com.kang.oop04;

//라이블러리용 class(API: Application Program Interface)
//				: 다른 class에서 이용할 목적
// 프로그램에서 실행되는 class가 여러개, 단 하나(실행용 class)를 제외한 나머지는
// 모두 라이브러리용 class

public class Student {
	// 필드(Field) : 객체의 데이터가 저장되는 곳
	// 		변수와 상당히 비슷한 모양새로 생겼지만 변수는 아님!!
	//		1. 변수 : 생성자, 메소드 안에서만 사용이 되고.
	//				생성자, 메소드 실행이 종료되면 함께 자동으로 종료
	//		2. 필드 : 생성자, 메소드 전체에서 사용이 가능
	//				객체가 소멸되지 않는 한 객체와 함께 공존
	
	// 초기값이 지정되지 않은 필드는 객체 생성시 자동으로 기본 초기값 지정
	int studentID;
	String studentName;
	String studentAddress;
	
	//method(메소드) : 객체의 동작에 해당하는 실행블록
	//		해당 메소드 호출 시, 모든 코드 일괄적 실행!
	// 		객체간의 데이터 전달 수단
	public void showStudentInfo() {
		System.out.println(studentName+"-"+studentAddress);
	}
	public void printInfo() {
		System.out.println(studentID);
		System.out.println(studentName);
		System.out.println(studentAddress);
		
	}
	
}
