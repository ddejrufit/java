package com.chung.oct131.eh;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.chung.oct131.cal.Calculator;

// java : 에러처리가 강제

public class EMain3 {
	public static void main(String[] args) {
		// C:\Users\sdedu\Desktop\sdfdsf.txt
		// txt파일을 받아와서 뭔가 할건데
		// 만약에 txt파일을 지웠거나 없는 파일이라면?
		FileReader fr;
		try {
			fr = new FileReader("C:\\Users\\sdedu\\Desktop\\sdfdsf.txt");
			System.out.println(fr.read());
		} catch (Exception e) {

//			e.printStackTrace();
		}

		// 가격 / 무게(g)를 입력받아서 (정수로)
		// g당 가격이 얼마인지 구해서 main에서 출력
		// 계산하는 부분(기능적인 부분): Calculator 라는 class팡리 따로 만들어서
		Scanner k = new Scanner(System.in);
		System.out.println("가격 : ");
		int price = k.nextInt();
		System.out.println("무게 : ");
		int weight = k.nextInt();
		System.out.println("==========================");
		int z = Calculator.divide(price,weight);
		System.out.println("g당 가격 :");
		try {	
			int z2 = Calculator.divide2(price,weight);
			System.out.println("g당 가격 : " + z2);
		
			
		} catch (Exception e) {
			System.out.println("ㅇㄱㅁㄴ ㅠㅠ");
			e.printStackTrace();
		}
		//main 이외의 메소드에서 try-catch를 하는 건 월권행위
		// try-catch는 main메소드에서만(나중에 예외는 있음!)
		// throws : 이걸 더 많이 사용! - main이외의 메소드에서 예외처리 필요할 때
	

//		Calculator c = new Calculator();
//		c.putin();
//		c.result(0, 0);
//		c.printInfo();

	}

}
