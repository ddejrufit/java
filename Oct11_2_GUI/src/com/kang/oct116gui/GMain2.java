package com.kang.oct116gui;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

// 실행하기 전에 ctrl + f11 누르기 전에 이클립스 전체화면

//해상도 : 1920 * 1080

public class GMain2 {
	public static void main(String[] args) {
		try {
			Robot r = new Robot();
			
			r.mouseMove(1900, 0);
			Thread.sleep(500);
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			r.keyPress(KeyEvent.VK_ENTER);//ctrl + s
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
