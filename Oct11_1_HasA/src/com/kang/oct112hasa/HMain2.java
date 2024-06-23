package com.kang.oct112hasa;

//WORA(Write Once, Run Anywhere)
//		한번 작성하면 어디서든지 동작한다

// Systme(OS)											soldesk
//		windows												홍길동
//		linux												김길동
//	시스템들이 콘솔창을 같이										그 학생들은 모두 tv를 같이(공유)

// syso => 어떤 system이던지 간에 콘솔창을 가리킴


public class HMain2 {
	public static void main(String[] args) {
		// tv객체 : tv이름 : widevu, tv가격: 1000000 >> 정보 출력
		TV t = new TV("widevu",1000000);
		//Soldesk에서 사용하는 TV 전체 정보 출력
		
	Soldeskstu.tv.printInfo();
	System.out.println("------------------");
		// Soldesk 라이브러리 용
	Soldeskstu.tv.printOn();
	}
}
