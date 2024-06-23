package com.kang.oct102ex;

import java.util.Random;

public class Computer {
	Random brain;

	public Computer() {
		brain = new Random();
	}
	
	public int fire() {
//		int a = brain.nextInt(3)+1;
//		return a;	
		return brain.nextInt(3)+1;
	}
}
