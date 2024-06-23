package com.kang.oop02;

public class Tv {
	int allcha=100;
	int vol=10;
	boolean bollean= true;
	int cha;

	public void printInfo() {
		System.out.println("모든 채널 수 : "+allcha);
		System.out.println("현재 볼륨 : "+vol);
		System.out.println("온 오프 :"+bollean);
		System.out.println("현재 채널 : "+cha);
	}
}