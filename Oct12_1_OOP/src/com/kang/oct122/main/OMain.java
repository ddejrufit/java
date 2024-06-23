package com.kang.oct122.main;

import java.util.Random;

import com.kang.oct121.scanner.Scanner;

public class OMain {
	public static void main(String[] args) {
		//패키지가 생략 가능한 경우
		//		java 기본패키지 (java 내장 class일 경우 -> java.ㅕ샤ㅣ.~~)
		//		java.lang 소속
		Random r = new Random();
		// 같은 패키지 소속(main이 있는 곳과 같은 패키지 안에 있다면)생략가능
		Cat c = new Cat();
		//		다른 패키지에 있어도 import했다면
		//		** Main 클래스에서는 이 scanner만 (패키지 생략 후 )사용하겠다
		//		둘 중 하나만 패키지 생략 가능
		Scanner mine = new Scanner();
		java.util.Scanner k = new java.util.Scanner(System.in);
	}
}
