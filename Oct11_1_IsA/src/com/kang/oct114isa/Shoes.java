package com.kang.oct114isa;

public class Shoes extends Product{
	// 상속 관계가 성립
	//Product에 있는 멤버변수 (필드,속성,...)가 상속됨
	int size;//Shoes class에서 확장시킨 부분
	
	public Shoes() {
		// TODO Auto-generated constructor stub
	}
	
	//Product 쪽에 있는 method 명 + 자동완성
@Override// 물려받은 method 기능 확장하기
public void print() {
	// TODO Auto-generated method stub
	super.print();//기존(상속해준 class의 기능)+
	System.out.println(size);//상속 빋은 class의 기능 추가
}
	
	
	
	
}
