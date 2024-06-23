package com.kang.oct103;

// OOP : Has a, Is a
//객체간의 관계
//		A has a B : 사람 has a 해드폰
//		A is a B : 개 is a 동물

public class OMain1 {
	public static void main(String[] args) {
		// 이름 : 청포도맛사탕, 맛 : 청포도맛 -Candy
		// 객체 만들 때 constructor overloading
		// 그 정보가 모두 보이게
		Candy c = new Candy("청포도맛사탕", "청포도맛");
		c.printInfo();
		System.out.println("================");
		// 청포도맛 사탕은 (name)lotte에서 만들었다 /(location)평택 / (employee)100명
		Company co = new Company("lotte", "평택", 100);
		co.printInfo();
		// 청포도맛 사탕을 롯데에서 만들었다

		c.brand = co;// Candy has a Company
		//청포도 맛이 나는 청포도맛사탕을 만든 제조사 정보 출력
		c.brand.printInfo();
	}
}
