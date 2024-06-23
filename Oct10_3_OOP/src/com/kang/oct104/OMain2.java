package com.kang.oct104;

public class OMain2 {
	public static void main(String[] args) {
//		// Pen : 아름 , 색
//		// 정보 출력
//		Pen p = new Pen("모나미", "검정색");
//		p.printInfo();
//
//		//////////////////////////////
//		// company: 회사이름,지역,직원수
//		// 정보출력
//		Company c = new Company("모나미","충북",30);
//		c.printInfo();
//		
//		p.brand = c;
//		
//		p.brand.printInfo();
		//////////////////////////////
		// cpu가 i7-1234, RAM 16GB, HDD 500GB인 [lg컴퓨터]의 제조사 정보 출력
		// 제조사 정보까지 생성자 오버로딩에
		//
		Company2 co = new Company2("lg전자", "서울", 500);
		Spac s = new Spac("i7-1234", 16, 500,co);
		s.printInfo();
		co.printInfo();
		s.brand = co;
		s.brand.printInfo();
	}
}
