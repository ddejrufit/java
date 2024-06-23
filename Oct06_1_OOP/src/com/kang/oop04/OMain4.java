package com.kang.oop04;

// 실행용 class : ctrl + f11이 이루어짐
//		프로그램 실행을 위한 main() method를 제공하는 역할

public class OMain4 {
	// 실행을 위한 코드
	public static void main(String[] args) {
		// 객체 하나 꺼내기
		Student s = new Student();
		//객체에 값 할당하기
		s.studentName = "강찬우";
		s.studentAddress="구리시";
		System.out.println("s가 Student 객체를 참조");
		s.showStudentInfo();
		s.printInfo();
		System.out.println("-------------------------------------");
		//위에 것과는 완전히 독립된 서로 다른 객체
		Student s2 =new Student();
		s2.studentName ="홍길동";
		s2.studentAddress="강남구";
		System.out.println("s2가 student 객체를 참조");
		s2.showStudentInfo();
		s2.printInfo();
		System.out.println(s);
		System.out.println(s2);
	}

}
