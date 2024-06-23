package com.kang.oct171.main;

// Wraooer Class(래퍼 클래스) - 포장객체
// Integer, Double, Long ,Void ,Boolean, ...
// 기본 자료형을 객체로 다루기 위해 사용하는 class
// Java의 기본형은 값을 가지는 객체 생성이 가능
// 기본형의 값을 내부에 두고 그 위를 포장하는 방식

//	Boxing : 기본형 -> 래퍼클래스
// UnBoxing : 래퍼클래스 -> 기본형

// 문자열 > 숫자 : Integer , Double class들의 static 함수
// 숫자 > 문자열 : Integer.toString, Double.toString

// 1. 객체나 클래스가 제공하는 method 사용할 때
// 2. 클래스가 제공하는 상수를 사용(MIN_VALUE, MAX_VALUE, ...)
//★☆★☆ 3. (v) 숫자 <-> 문자로 형변환 할 때 ★☆★☆

//		기본타입				래퍼클래스
//				 -▶박싱
//				 ◀-언박싱
//		int					Integer
//		double				Double

public class WMain1 {
	public static void main(String[] args) {
		int a = 10;
		double aa = (double) a;
		System.out.println(aa);
		
		//Integer 객체를 생성 -> 정수값 넣기 -> int 형으로 return
		String s ="100";
		Integer s1 = new Integer(s);
		System.out.println(s1.getClass());// class java.lang.Integer
		// .intVAlue() : Integer 객체에서 int 형 값을 뽑아내는 method
		s1.intValue();// Integer -> int
		System.out.println(s1);
		System.out.println(s1.TYPE);// 자료형 보기
		
		// 기본형 -> 객체형 : boxing
		double d = 123.456;
		Double dd = new Double(d);
		
		// 위 과정을 자동으로 해줌 : auto-boxing
		Integer g = 10;
		
		//객체형 -> 기본형 : undoxing
		Boolean b = new Boolean(true);
		boolean bb = b.booleanValue();
		
		//위 과정을 자동으로 해줌 : auto-unboxing
		int gg =g;
		
		int max = Integer.MAX_VALUE;
		System.out.println(max);
		
		int min = Integer.MIN_VALUE;
		System.out.println(min);
		
		byte mm = Byte.MAX_VALUE;
		System.out.println(mm);
		
		// int 자료형 값을 -> String (문자열)으로
		int a1 = 123;
		String a11= Integer.toString(a1);
		System.out.println(a11); // "123"

		String a12 = Integer.toString(123);
		
		// int 자료형 값을 -> 2진수 형태로(String)
		String num = Integer.toBinaryString(a);
		System.out.println(num);
		
		//String -> 기본형(다이렉트로는 힘들고, 객체형을 거쳐야)
		//String -> 객체형 -> 기본형
		String k = "635.12";
		Double k2 = Double.parseDouble(k);
		double k3 = k2.doubleValue();
		
		
		// 약식형
		String kk = "123";
		int kk2 = Integer.parseInt(kk);
		
		
	}
}
