package com.chung.oct131.eh;

import java.util.Scanner;

public class EMain {

	// 프로그램 실행 -> 콘솔창에 빨간 글씨로 ~~~ 나오는 거 -> 에러/버그/오류/알림/경고문?

	// error
	// 한국어 - 번역 -> 영어
	// 사과 apple
	// 바나나 banana
	// 뀔오 ????
	// Java문법에 맞지 않게 써서 컴파일 자체가 불가능한 상태
	// 개발자 잘못!
	// 완성본 자체가 나오지 않음
	// warning
	// 지저분한 코드
	// 개발자 잘못!
	// 컴파일 자체는 가능!-> 완성본은 나옴 (실행하는데 문제 X)
	// 다만, 이클립스가 잔소리함
	// ex) Scanner k <<
	// exception
	// 프로그램은 100% 완성
	// 실행할 때 뭔가 외부적인 요인에 의해서 작동이 제대로 되지 않는 상황
	// 개발자 잘못은 아님
	// 개발자 입장 -> 상황 예측 후 대책은 세워 놓는 것이 좋다~
	public static void main(String[] args) {
		// x, y 정수값 입력받아서
		Scanner k = new Scanner(System.in);
		System.out.print("x :");
		int x = k.nextInt();
		System.out.print("y :");
		int y = k.nextInt();
		// 사칙연산 출력
		System.out.println(x + y);
		System.out.println(x - y);
		System.out.println(x * y);
//		System.out.println(x / y);

		// if y값에 0을 넣는 사용자가 있다면 -> Excaption 발생
		// 이 EXception을 처리할 수 있는 방법
//		try {
//			
//		} catch (예외유형명 변수명) {
//			try 쪽을 실행하다가 해당 유형의 예외가 발생하면 이 부분 실행
//			만약, 예외없이 정상적으로 실행됐을 경우, catch부분은 건너뛰고
//			그 아래 코드를 실행
//		}catch (Exception e) {
//			...
//		}finally {
//			정상적으로 프로그램이 실행이 됐던지.
//			예외가터졌던지 상관없이 무조건 실행
//			return보다 우선되어 실행!
//		}
//		** 예) catch가 두개 있는데, 두가지 문제가 동시에 터진 경우?
//				-> 먼저 나온 catch의 내용만 출력
//				Java 입장에서는 첫번째 예외가 터졌을 때
//				즉시 실행중지 후 해당 예외처리 부분으로 넘어가기 때문!

//		try {
//			int d= x/ y;
//			System.out.println(d);
//			int[] ar = {1,2,3};
//			System.out.println(ar[x]);
//		} catch (ArithmeticException ae) {
//			System.out.println("0으로 못나눔");
//		}catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("배열 인덱스 범위 넘었잖아");
//		}

		try {
			int d = x / y;
			System.out.println(d);
			int[] ar = { 1, 2, 3 };
			System.out.println(ar[x]);
		} catch (Exception e) {// 모~든 exception 을 다 잡아줌
			System.out.println("404 eroor");
			e.printStackTrace();// 상황 출력(개발자용)
		} finally {
			System.out.println("에러가 나도 안나도 나오는 부분");
		}

	}

}
