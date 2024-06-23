package com.kang.oct116gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Doctor implements ActionListener {
	private JTextField htf;
	private JTextField wtf;
	private JLabel rlb;

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(JTextField htf, JTextField wtf, JLabel rlb) {
		super();
		this.htf = htf;
		this.wtf = wtf;
		this.rlb = rlb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 키, 몸무게 TextField에서 입력받은 것을 Java 변수에 넣기
		// htf에 있는 text 받아서 double로 형변환 해서 double h 그릇에 넣겠다
		double h = Double.parseDouble(htf.getText());
		double w = Double.parseDouble(wtf.getText());
		h /= 100; // m로 계산 하기 때문에 m로 만들어 주기

		double bmi = w / (h * h);
		
		String result = "저체중";
		if (bmi>=40) {
			result ="고도비만";
		}else if (bmi>=35) {
			result="중등도비만";
		}else if (bmi>=30) {
			result = "경도비만";
		}else if (bmi>=25) {
			result ="과체중";
		}else if (bmi>=18.5) {
			result="정상";
		}
		//String에 형식 지정하고 싶을 때(syso -> System.out.printf)
		String finalResult=String.format("BMI = %.2f, 당신은 %s",bmi,result);
		
		//finalResult 결과를 rlb의 text로 세팅하겠다
		rlb.setText(finalResult);
	}
}
