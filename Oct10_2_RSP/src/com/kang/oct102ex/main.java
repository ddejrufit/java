package com.kang.oct102ex;

public class main {
	public static void main(String[] args) {
		Me m = new Me();
		Computer c =new Computer();
		Judge j = new Judge();
		j.gameStart(m, c);
	}
}
