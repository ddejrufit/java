package com.kang.oct101;

//생성자(Constructor)
//		객체가 만들어질 때 뭔가 해야하는 작업이 필요할 때
//		생성자를 만들지 않으면 -> Java compiler가 알아서 만들어버림
//		return이 아예 없는, method명과 class명이 같은 method

public class Shoes {
	//신발 이름, 신발 사이즈, 신발 가격, 생산자(static)
	String name;
	int size;
	int prize;
	static String maker ="NIKE";
	
	
	//생성자(ctrl + space + enter)
	public Shoes() {
		System.out.println("신발 입고 됨");
	}

// 생성자 오버로딩(빈공간 우클릭 -> Source -> Generate Constructor Using Fields))
	// 단축키 설정 : 이클립스 상단 Window -> Preferences -> General -> Keys -> Generate Constructor Using Fields 검색 -> 클릭후 Binding 에서 Ctrl+shift + a ->apply
	public Shoes(String name, int size, int prize) {
		super();
		this.name = name;
		this.size = size;
		this.prize = prize;
	}
	
	public void amooguna(String name) {
		// 멤버변수명, 파라미터 or 지역변수가 같으면?
		
		//this. : 무조건 멤버변수 (속성, 필드)
		//그렇지않으면,가장 가까이 있는 것
		System.out.println(name);// 가까이 있는 것 = 파라미터
		System.out.println(this.name);//this.신발이름, 파라미터 구분
	}
	
	//오버로딩(overloading) : method 명이 같고 parameter가 다른 것
	//파라미터에 따라 main에서 불러올 때 실행 되는 method가 달라짐
	public void test() {
		System.out.println("test");
	}
	public void test(int a) {
		System.out.println("test overloading");
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(size);
		System.out.println(prize);
		System.out.println(maker);
	}
	
	// 신발가게에 재고가 있든 없든 변하지 않는 것
	public static void printMakerInfo() {
		System.out.println(maker);
		
	}
	
}
