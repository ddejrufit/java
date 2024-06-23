package com.kang.oct101;

public class OMain1 {
	public static void main(String[] args) {
		Shoes s = new Shoes();
		s.name="삼선슬리퍼";
		s.size = 240;
		s.prize =5000;
		s.printInfo();
		System.out.println("------------------");
		Shoes s1 = new Shoes("asdf",280,12000);
		s1.printInfo();
		s.test();
		s.test(111);
	}
}
