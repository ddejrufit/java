package com.kang.oct131.frame;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 1 ~ 30 까지의 숫자가 랩덤하게 나오도록
// 숫자를 여러개 여러번 뽑을 떄 : 반복문
// array[]
// 글자를 표현하고 싶으면 : JLabel을 이용

public class NumberFrame extends JFrame {
	JPanel p = new JPanel();
	JLabel[] l = new JLabel[31];

	public NumberFrame() {
		add(p);
		setTitle("띠용띠용");
		setSize(500, 500);
		setVisible(true);
		setLayout(null);// 정렬 안하겠다
		p.setBackground(Color.black);
		Random r = new Random();
		int x = 0;
		int y = 0;
		for (int i = 0; i < 31; i++) {
			l[i] = new JLabel(Integer.toString(i));
			x = r.nextInt(500) + 1;
			y = r.nextInt(500) + 1;
			l[i].setForeground(Color.green);
			l[i].setLocation(x, y);
			l[i].setSize(50, 50);

			p.add(l[i]);

		}

	}
}
