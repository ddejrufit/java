package com.kang.oct127.factorypattern;

import com.kang.oct127.register.Academy;
import com.kang.oct127.register.Student;

//학원에서 학생을 상담한 후 해당 커리큘럼 대기자로 등록하려고 함
// 학생의 정보 : 이름 / 나이
// 등록한 순서대로 번호 부여하고 싶은데 어떻게 해야할까?

//갱체가 필요없음 : static method기반
//객체가 있기는 해야함
//		하나 : Singleton pattern
//		여러개 :
//			- 대량생간, 자동화된 : Factory pattern
//			- 나머지 : 지금껏 우리가 했던 걸로~

public class FMain {
	public static void main(String[] args) {
		Academy ac = new Academy(); // academy객체 하나 만들어 두기

		Student s1 = ac.comsult("홍길동", 13);
		s1.printInfo();
		System.out.println("----------------------");
		Student s2 = ac.comsult("김길동", 20);
		s2.printInfo();
		System.out.println("---------------------");
		Student s3 = ac.comsult("박길동", 18);
		s3.printInfo();

	}
}
