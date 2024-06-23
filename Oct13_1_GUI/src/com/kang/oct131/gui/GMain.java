package com.kang.oct131.gui;

import com.kang.oct131.frame.MakerFrame;
import com.kang.oct131.frame.NumberFrame;

// Java GUI 프로그램(Graphic User Interface)
// AWT, Swing, JavaFX

// AWT: java 초창기에 나온 GUI 라이브러리
//		운영체제 (OS)에 따라서 모양이 모두 달랐기 때문에, 종류가 상당히 제한적이었음

// Swing : AWT 다음으로 나온 라이브러리
//			윈도우 프로그램 - 자바로 X : 느림, 더 최적화 된 C언어 라인이 있음!!
//			윈도우 프로그램 잘 안만듬 - 웹/앱 쪽으로 넘어가는 추세
//			결론 : 별로! 디자인도 별로!
//			 * Android App 개발에 관심이 있다면 구조 이해에 도움이 됨

// JavaFX : Swing의 느림 점을 보안한 라이브러리
//			다양한 기능도 추가 + 따로 외관 꾸미기도 가능!
//			여전히 웹/ 앱쪽에서 구현하면 되기 때문에 그닥...

public class GMain {
	public static void main(String[] args) {
//		MakerFrame m = new MakerFrame();
		NumberFrame n = new NumberFrame();
	}
}
