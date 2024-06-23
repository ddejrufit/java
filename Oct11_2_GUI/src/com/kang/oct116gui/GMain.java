package com.kang.oct116gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// GUI Programming

public class GMain {
	public static void main(String[] args) {
		// JFrame 객체 가져오기
		JFrame j = new JFrame("BMI Test");
		// 격자형태 - grid layout ( 3행 2열 )
		GridLayout g = new GridLayout(3, 2, 1, 1);
		j.setLayout(g);// Jfame 객체에 g얹기

		// 키 라고 쓰인 label을 JFrame에 넣기
		JLabel hLabel = new JLabel("키");
		j.add(hLabel);
		//키를 적을 JTextField를 JFrame에 넣기
		JTextField hjtf = new JTextField();
		j.add(hjtf);
		
		JLabel wLabel = new JLabel("몸무게");
		j.add(wLabel);
		JTextField wjtf = new JTextField();
		j.add(wjtf);
		
		// 결과
		JLabel resultLabel = new JLabel("결과");
		j.add(resultLabel);
		
		//확인 button
		JButton btn = new JButton("확인");
		j.add(btn);

		j.setSize(350, 350);
		j.setVisible(true);

	}
}
