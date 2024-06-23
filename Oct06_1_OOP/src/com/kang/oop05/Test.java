package com.kang.oop05;

public class Test {
	// 월
	int month;
	// 일
	int day;
	// 시
	int time;
	// 과목명
	String project;
	// 걸리는 시간
	int spend;

	// hateTest() -> 으아아아악!!
	public void hateTest() {
		System.out.println("으아아아악");
	}

	// printInfo() -> 시험 관련 모든 정보 출력
	public void printInfo() {
		System.out.println("월 :" + month+"월");
		System.out.println("일 : " + day+"일");
		System.out.println("시 : " + time+"시");
		System.out.println("과목명 :" + project);
		System.out.println("소모 시간 :" + spend+"분");
	}
}
