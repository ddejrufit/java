package com.kang.ocy132.main;

import java.text.SimpleDateFormat;
import java.util.Scanner;

//뭔가 입력을 받을 건데
// a/b/c/d/e/f/... << 띄어쓰기 없이 슬래시로 구분해서
// 1/2/a/5/b ->총합 : 8, 평균 : 2(정수 - int)
// 숫자라면 총랍을 구하고 + 평균을 구하고 + 출력
// 글자라면 그냥 넘기게

public class TextMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("입력 :");

		String b = k.next();
//		String b = "1/2/a/5/b/7/15";
//		String c = "1/2/3/4/5/6/7/8/9/10/11/12/13/14/15/16/17/18/19/20/21/22/23/24/25/26/27";

		String[] bAr = b.split("/");
//		String[] cAr = c.split("/");
		int d = 0; // 총합
		int f = 0;// 합한횟수
		for (int i = 0; i < bAr.length; i++) {

			for (int j = 0;; j++) {
				String[] c = new String[j] ;
				
				SimpleDateFormat sdf = new SimpleDateFormat();
				
				
				if (bAr[i].equals(c[j])) {

					d += (j + 1);
					f++;

				}

			}
		}
		System.out.println("합은 :" + d);
		System.out.println("평균은 :" + d / f);
	}

}
