package com.kang.oct311mbd.main;

import java.util.ArrayList;

// 규칙을 정해서 한번씩 실행 -> 실행파일(.jar -> .bat)

// controller용
public class GetAirController {
	public static void main(String[] args) {
		ArrayList<Air> airs = AirDAO.getAir();
		for (Air a : airs) {
			// ArrayList에 담긴 값들(각각의 포장된 Javabean 내용)을
			// 하나씩 뜯어서 DB에 insert 하는 과정
			AirDAO.writeAir(a);
			
			// 이부분에서 writeAir 메소드 실행!
		
//			System.out.println(a);// javabean 주소값이 나옴
//			System.out.println(a.getSa_no()); // javabean에 넣지 않은 값 = 초기값
//			System.out.println(a.getSa_msrdt());// javabean에 넣지 않은 값 = 초기값
//			System.out.println(a.getSa_msrste_nm());
//			System.out.println(a.getSa_pm10());
//			System.out.println(a.getSa_pm25());
//			System.out.println(a.getSa_o3());
//			System.out.println(a.getSaa_idex_nm());
//			System.out.println("-------------------------");
		}
		System.out.println("insert 완료");
	}
}
