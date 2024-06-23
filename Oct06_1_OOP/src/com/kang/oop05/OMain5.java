package com.kang.oop05;

// RAM의 저장공간
// ? 
//		?
//	stack
//		변수를 만들 때마다 아래에서 부터 차곡 차곡 쌓임
//		프로그램 종료 시 다 정리
//	heap
//		컴퓨터가 지 맘대로 적당한 곳에서 알아서 만듬
//		자동으로 정리가 되지는 않음(Java는 자동정리가 가능)

// ** Garbage Collection(GC - 자동 메모리 관리)
//		heap영역 자동 정리 시스템
//		발동되는 시기 : 그 번지에 더 이상 접근방법이 없는 경우 GC 발동
public class OMain5 {
	public static void main(String[] args) {
		Test t = new Test();

		t.month = 10;
		t.day = 6;
		t.time = 2;
		t.project = "프로그래밍언어활용";
		t.spend = 120;

		t.hateTest();
		t.printInfo();
		System.out.println(t);
		Test t2 = t; // t2에 t를 복사
		System.out.println(t2);// t와 번지값 동일
		t = null;
		System.out.println(t);// 아무 번지값도 가리키지 않음, t는 아무것도 아님
//		t.printInfo();//error
		System.out.println(t2);// 복사된 t2 번지값 살아있음
		t2 = null;
		// 35번 줄에서 (main기준) 가져온 test class 사라짐
		// 객체가 필요없어져서 null처리로 잘라버리면
		System.out.println(t2);// GC발동
	}

}
