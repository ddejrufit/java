package com.kang.oct111hasa;

public class HMain1 {
	public static void main(String[] args) {
		// 사람객체: 이름,성별,전화번호 >> 정보 출력되게
		People p = new People("kang", "male", "010.9954.7876");	
		Restaurant r = new Restaurant("김밥천국", "구리시", "031.XXX.XXXX", p);
		Menu m = new Menu("돼지국밥",6000,r);
		Menu m1 = new Menu("컵라면",950,r);
	
		r.printInfo();
		
		System.out.println("=================================");
		// 위 객체가 가지고 있는 식당
		// 식당 이름,지역,식당전화번호,위객체의 식당>> 정보출력되게
		// 돼지국밥 6000원
		// 컵라면  950원
		m1.printInfo();
		System.out.println("=================================");
		m.printInfo();
		System.out.println("=================================");
		// 국밥을 담은 그릇(Dish), 3000원 짜리
		Dish d = new Dish("다이소 명품 직화 뚝배기",3000,m);
		d.printInfo();
		System.out.println("=================================");
		//(Market)시장 이름, 시장주소, 그릇을 구매한 사장
		Market ma = new Market("다이소","역주변에 있음","김밥천국 직원",d);
		ma.printinfo();
		System.out.println("=================================");
		//(Merchant)상인 이름 ,시장에서 그릇을 판매한 상인
		Merchant me = new Merchant("인간 문화제 도자기 명인 김춘자씨",ma);
		me.printInfo();
		System.out.println("=================================");
		//상인이 일하는 시장의 주소만 출력
		System.out.println(me.employee.adress);
		System.out.println("=================================");
		//상인이 일하는 시장의 전체정보 출력
		me.employee.printinfo();
		System.out.println("=================================");
		// 상인이 일하는 시장에서 산 접시의 전체정보
		me.employee.thing.printInfo();
		System.out.println("=================================");
		//상인이 일하는 시장에서 산 접시의 가격
		System.out.println(me.employee.thing.price);
		System.out.println("=================================");
		//상인이 일하는 시장에서 산 접시에 담긴 메뉴 전체 정보
		me.employee.thing.putin.printInfo();
		System.out.println("=================================");
		//상인이 일하는 시장에서 산 접시에 담긴 메뉴 이름
		System.out.println(me.employee.thing.putin.name);
		System.out.println("=================================");
		//상인이 일하는 시장에서 산 접시에 담긴 메뉴를 판 식당 연락처
		System.out.println(me.employee.thing.putin.where.num);
		System.out.println("=================================");
		//상인이 일하는 시장에서 산 접시에 담긴 메뉴를 판 식당 주인 연락처
		System.out.println(me.employee.thing.putin.where.oner.num);
		System.out.println("=================================");
		//컵라면을 판 식당 주인의 이름
		System.out.println(m1.where.oner.name);
		
	}
}
