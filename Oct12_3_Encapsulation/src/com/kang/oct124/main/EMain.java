package com.kang.oct124.main;

import javax.swing.JFrame;

import com.kang.oct124.coffee.Coffee;
import com.kang.oct124.human.Human;

public class EMain {
	public static void main(String[] args) {
		Human h = new Human();
//		h.name ="kang"; // 그냥 접근 하려고 하면 오류
//		Scanner k = new Scanner(System.in);
//		System.out.print("이름 >>");
//		String n = k.next();
//		System.out.print("나이 >> ");
//		int a = k.nextInt(); // 여기까진 입력받은거 변수에 담는 과정
//		h.setName(n); // n 변수에 담은 내용을 h객체의 name부분에 세팅
//		h.setAge(a);
		System.out.println("-----------------------------");
		h.printInfo();
		System.out.println(h.getName());
		System.out.println("---------------------------------");
		Coffee c = new Coffee();
		c.setName("아메리카노");
		c.setPrice(1500);
		c.printInfo();
		System.out.println("----------------------");
		Coffee c1 = new Coffee("카페라떼",2500);
		c1.printInfo();
		System.out.println("----------------------");
		JFrame j = new JFrame("ㅋㅋㅋ");
		j.setSize(300,500);
		System.out.println(j.getSize());// size 알고 싶으면
		//타이릍을 ㅎㅎㅎ로 수정
		j.setTitle("ㅎㅎㅎ");
//		j.show();//지금 버전에서 지원은 하나 앞으로 언제 사라질지 모르니 주의해라!
		j.setVisible(true);
	}
}
