package com.kang.oct113isa;

// 객체간의 관계
//		A is a B : Cat is a Animal

public class IMain1 {
	public static void main(String[] args) {
		// 동물(Animal)객체 -> 속성: sort, age 정보출력 method
		Cat c = new Cat();
		c.printInfo(); // 상속받은 Animal의 속성들이 들어와 있다
		System.out.println("==========================");
		//Dog class
		Dog d = new Dog();
	}
}
