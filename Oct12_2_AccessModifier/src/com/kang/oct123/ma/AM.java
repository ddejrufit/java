 package com.kang.oct123.ma;

public class AM {
	//Access Modifier(접근제어자)
	//		속성 + method 등이 어디까지 접근이 가능한지 조절
	//		종류 : prblic / protected / (default) / private
				//접근범위
	public int a;		// 접근 제한 없
	protected int b;	//같은 패키지 안 or 다른 패키지의 하위클래스
	int c;				//(default) 같은 패키지 내
	private int d;		// 클래스 내부에서만 가능 / 외부로는 사용 불가
}
