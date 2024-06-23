package com.kang.oct202.main;

import java.util.HashSet;

// Set계열
//		가변사이즈
//		중복데이터 자동 삭제
//			ㄴ 같은 객체 여러번 들어가면 하나만 남ㄱ;ㅁ
//		순서가 랜덤
// 		HashSet,TresSet, ...
// 			-> 실전에서는 그닥 유용하지 않음

public class SetMain {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("ㅁㅁ");
		hs.add("ㅎㅎ");
		hs.add("ㄹㄹ");
		hs.add("ㅁㅁ");
		hs.add("ㄹㄹ");
		hs.add("ㅎㅎ");
		
		System.out.println(hs);
		System.out.println(hs.size());
		
		for (String ss : hs) {
			System.out.println(ss);
		}
	}
}
