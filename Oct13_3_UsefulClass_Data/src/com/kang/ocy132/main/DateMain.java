package com.kang.ocy132.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Date.java : 아~~~~~주 옛날에 1900년대에 만들어진 Class
//			Y2K에 관심이 없던 시절 (Year 200 - k(killo) = 1000)
//			현재 실정에는 맞지 않음
//			1900년대 당시에는 컴퓨터 용량이 적어서 연도 끝에 2자리만
//			1970년대 이전의 컴퓨터 : 속도가 느리고, 장치의 용량이 적었음
//			데이터 양을 아끼기 위해서 연도 처리를 4byte가  아닌 2byte로 할당
//			문제가 생김!!
//			1900년, 2000년 >> 끝에 두자리가 00으로 동일 >> 통일 >> 구분이 불가능
//			-> 컴퓨터 오작동의 가능성 ▲

// deprecated
//		세월이 흐르고, 컴퓨터도 발전 -> 옛날에 만든건 더이상 쓰지 못함!
//		프로그래밍 언어도 업데이트가 필요해짐
//		없애거나/ 기능을 수정할 계획이 생겨버림
//		현재 자바버전 OK~! / 다음 버전에 없어져도 놀래거나 불만갖지 말아라~

public class DateMain {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);// 현재 시간 날짜 출력
		// 연도
		System.out.println(now.getYear() + 1900);
		// 월
		System.out.println(now.getMonth() + 1);
		// 일
		System.out.println(now.getDate());
		// 요일
		String[] day = { "일", "월", "화", "수", "목", "금", "토" };
		System.out.println(day[now.getDay()] + "요일");
		System.out.println("================================");
		// 한글처리 / 날짜 / 시간 : 지속적으로 여러분들을 괴롭힐 것...!!

		// Date -형식지정-> String : format
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E a hh:mm", Locale.KOREAN);
		String s1 = sdf.format(now);
		System.out.println(s1);

		// 특정 시간, 날짜
		Date d2 = new Date(2023, 10, 12);

		// String -형식지정->Date;
		System.out.println("=============================");
		try {
			String s2 = "2023-10-12";
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
			Date d3 = sdf2.parse(s2);
			System.out.println(d3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("---------------------------------");
		// 10년전 크리스마스는 무슨 요일?
		try {
			String xmas = "2013.12.25";
			SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy.MM.dd");
			Date xmas2 = sdf3.parse(xmas);
//			System.out.println(xmas2);
			
			SimpleDateFormat sdf4 = new SimpleDateFormat("E");
			String xmas3 = sdf4.format(xmas2);
			System.out.println(xmas3+"요일");
			
//			System.out.println(day[xmas2.getDay()] + "요일");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
