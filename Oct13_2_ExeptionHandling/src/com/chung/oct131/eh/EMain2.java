package com.chung.oct131.eh;

public class EMain2 {
	public static void main(String[] args) {
		// Exception의 종류 (빈번히 발생하는?)

		// 1. ArithmeticException : 0으로 나눴을때
		// 2. ArrayIndexOutOfBoundsException : 배열의 index범위를 넘었을 때
		// 3.NullPointerException : 객체 참조가 없는 상황
//		String s = null;
//		System.out.println(s.length());
		// 4.NumberFormatException
		// 문자열(String) -> 숫자(int, double)로 바꾸는 상황에서
		// 변환할 수 없는 문자가 있으면 발생
//		String s = "a12345";
//		int i = Integer.parseInt(s);
//		System.out.println(i + 20);
	}

}
