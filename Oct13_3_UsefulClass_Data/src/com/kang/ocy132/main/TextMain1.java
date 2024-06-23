package com.kang.ocy132.main;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class TextMain1 {
	// 버전
	// 1.8.3
	// 앞자리 : major버전(1)
	// 뒷자리 : mior버전(8.3)
	// 뒷자리로 갈 수록 더 minor한 버전
	// 버전 업 (1.8.3 -> 1.8.4) : 살짝 수정
	// 버전 업 (1.8.3 -> 1.9.0) : 변화에 어느 정도 느낌이 오는 정도
	// 버전 업 (1.8.3 -> 2.0.0) : 새로운 프로그램

	// 네트워크를 통해서 데이터를 받아오면 : 글자형태
	// 네트워크를 통해서 데이터를 줄 때 : 글자형태
	// + 한글처리 까다로워질 수 있음!
	public static void main(String[] args) {
		String s = "으아아아악"; // 정식 X,약식 O!
		String s1 = new String("쫌만 참으면 토일월 3일 쉰다!!");

		// s1의 글자가 총 몇개?
		System.out.println(s1.length());

		// s1에서 두번째에 있는 글자 출력
		// charAt(숫자) : 특정 위치에 있는 글자를 뽑아낼 때
		System.out.println(s1.charAt(3));

		// s1이 '쫌'이라는 단어로 시작하는지
		// startsWith(단어) : 시작하는 단어가 맞는지 확인할 때
		System.out.println(s1.startsWith("쫌"));
		// s1에 '너무; 라는 단어가 있는지
		// contains(단어) : 찾는 글자가 있는지
		System.out.println(s1.contains("너무"));

		// s1에 '3'을 '삼'으로 바꿔서 출력
		// replace(원래글자 , 바뀔글자) : 특정 글자를 다른 글자로 바꿀 때
		System.out.println(s1.replace('3', '삼'));

		// s1에 5 ~ 10번째까지 글자만 출력
		// substring(이상, 미만) : 원하는 위치의 글자들을 뽑을 때
		System.out.println(s1.substring(5, 11));
		System.out.println("=====================");

		// String객체를 생성하는데 형식을 잡아서
		String s33 = new DecimalFormat("##.###").format(123.456789);
		System.out.println(s33);
		String s3 = String.format("무게 : %.2fkg", 123.456789);
		System.out.println(s3);
		System.out.println("=====================");

		// s1 글자를 추가
		s1 = s1 + "메리크리스마스!";
		System.out.println(s1);
		System.out.println("=====================");

		// String 대량으로 추가
		StringBuffer sb = new StringBuffer(s1);
		sb.append("앞으로 일은 적게하고");
		sb.append("돈은 많이 벌게 해주세요");
		sb.append("ㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
		sb.append("근데 3일동안 뭐하실건가요?");
		System.out.println(sb);

		// StringBuffer를 String으로 하고 싶을떄
		String s4 = sb.toString();
		System.out.println(s4);
		System.out.println("=====================");

		// String 분리
		String s5 = "홍길동,김길동,박길동,이길동,최길동,정길동";

		// 1. Split
		String[] s5Ar = s5.split(",");
		System.out.println(s5Ar[3]);
		
		// 2. StringTokenizer
		StringTokenizer st = new StringTokenizer(s5,",");//순서대로
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		// 속도적인 면 : StringTokenizer
		// data 속에 변수가 많다 : Split
		

	}
}
