package com.kang.oct102;

import java.util.Scanner;

public class Me {
	String hand;
	String judge;
	int win=0;
	int draw=0;
	int stop=0;
	Scanner k = new Scanner(System.in);

	public String pick() {// 가위 바위 보 입력 받기\
		String hand = k.next();
	
		return hand;
	}
}
