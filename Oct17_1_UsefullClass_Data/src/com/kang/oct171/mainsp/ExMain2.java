package com.kang.oct171.mainsp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ExMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("이름/생년월일(yyyy.MM.dd)/국어/수학/영어 입력하세요:");
		String s = k.next();

		StringTokenizer sData = new StringTokenizer(s, "/");

		try {
			// 이름
			String name = sData.nextToken();
			System.out.println(" 이름 > " + name);

			// 생일(나이) - SimpleDateFormat
			String bd = sData.nextToken(); // 1998.08.17
//		String -> Date : parse
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

			Date birthday = sdf.parse(bd);

			SimpleDateFormat sdf0 = new SimpleDateFormat("E");
			String birthdatStr = sdf0.format(birthday);
			System.out.println(" 생일 > " + birthdatStr + "요일");

			// 현재 연도 뽑기
			Date now = new Date();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
			String nowYr = sdf1.format(now);// 현재년도
			String birthdayYr = sdf1.format(birthday);// 생년

			int ny = Integer.parseInt(nowYr);
			int by = Integer.parseInt(birthdayYr);
			int age = ny - by + 1;
			System.out.println(" 나이 > " + age);

			int kor = Integer.parseInt(sData.nextToken());
			int math = Integer.parseInt(sData.nextToken());
			int eng = Integer.parseInt(sData.nextToken());

			System.out.println(" 국어 > " + kor);
			System.out.println(" 수학 > " + math);
			System.out.println(" 영어 > " + eng);

			int sum = kor + math + eng;
			System.out.println(" 총점 > " + sum);

			double avg = (double) sum / 3;
			System.out.println(" 평균 > " + avg);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
