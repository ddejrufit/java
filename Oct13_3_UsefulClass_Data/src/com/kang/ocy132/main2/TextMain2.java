package com.kang.ocy132.main2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TextMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("입력(a/b/c/d/...)>>");
		String s = k.next();
//		System.out.println(s);
		StringTokenizer st = new StringTokenizer(s, "/");

		int n = 0;
		int sum = 0;
		int count = 0;
		while (st.hasMoreTokens()) {

			try {
				n = Integer.parseInt(st.nextToken());
				count++;
				sum += n;

			} catch (Exception e) {
//			e.printStackTrace();
//			NumberFormatException();
				// 글자를 숫자로 바꿀려고 할 때 생기는 Exception
			}

		}
		System.out.println(sum);
		System.out.println((double) sum / count);
	}

}
