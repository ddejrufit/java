package com.kang.oct131.frame;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//JFrame : swing에서 윈도우 자체를 나타내는 class
//	ㄴJPanel(보조프레임), JButton(버튼), JLabel(라벨), JTextField(글자입력), ... 
// Latout:
//		flowLayout - 가운데 정렬
//		BorderLayout - Frame 형식
//		GribLayout - 격자형태
//		setLocation, setBounds - 위치 임의 지정

public class MakerFrame extends JFrame {
	JPanel pl;

	public MakerFrame() {
		// TODO Auto-generated constructor stub
		setSize(500, 500);// frame size
		setTitle("GUI 연습");// frame title
		pl = new JPanel();// 패널 하나 생성
		pl.setLayout(new FlowLayout());// 가운데 정렬 하겠다~
		for (int i = 1; i < 10; i++) {
			pl.add(new JButton("버튼" + i));// pl 안에 button 넣은 상태
		}
		add(pl);//JPanel을 JFrame에 넣기
		setVisible(true);//JFrame 보이게 하기
	}

}
