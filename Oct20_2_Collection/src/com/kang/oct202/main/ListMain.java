package com.kang.oct202.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

//	ArrayList
//		 요소를 index로 사용하는 것이 배열과 유사
//		저장되는 데이터의 수에 따라 크기가 자동적으로 변경
//		요소가 가득 차게 되면 ArrayList가 알아서 동적으로 크기 증가시키고 반대도 마찬가지
//		비추) 자료형 섞어서 데이터 넣는거 가능!
//		추천) 자료형 묶어서

// 자료형 통일
//		<> - generic2
//			ㄴ 자료형을 고정하는 역할
//			ㄴ 클래스명<자료형의 객체형>

public class ListMain {
	public static void main(String[] args) {
		ArrayList test = new ArrayList();
		test.add("금요일");
		test.add(20);
		test.add(10.20);
		test.add(true);
		for (Object object : test) {// 자료형이 통일 되지 않아서 Object
			System.out.println(object);
		}
		System.out.println("==========================================");
		ArrayList<String> fruits = new ArrayList<String>();
		fruits.add("파인애플");
//		fruits.add(1); // error! String만 넣을 수 있음!

		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(new Integer(100));
		al.add(50);// Auto - Boxing

		System.out.println(al.get(0));// 해당 인덱스의 값
		System.out.println(al.size());
		System.out.println("=========================");
		for (int i = 0; i < al.size(); i++) {
			System.out.println(i);

		}
		System.out.println("=========================");
		al.add(30);
		al.add(1, 90);// 1번 자리에 90 넣기
		al.set(2, 0);// 2번 자리에 0으로 바꾸기
		al.remove(0);
		for (Integer i : al) {
			System.out.println(i);
		}
		System.out.println("=========================");
		al.add(84);
		al.add(2179);
		al.add(300);
		al.add(35);
		for (Integer i : al) {
			System.out.println(i);
			
		}
		System.out.println("=========================");
		// 정렬기능
		Comparator<Integer> c = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				
//				return o1.compareTo(o2); // 오름차순
				return o2.compareTo(o1);// 내림차순
			}
		};
		al.sort(c);
		for (Integer ii : al) {
			System.out.println(ii);
		}
	}

}
