package com.kang.oct102;

import java.util.Random;

public class Computer {
	int auto;
	String cpu;
	Random r = new Random();

	public int com() { // 0:가위 1:바위 2:보
		int auto = r.nextInt(3)+1;
		return auto;
		}
	

}
