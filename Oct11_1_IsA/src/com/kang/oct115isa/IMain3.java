package com.kang.oct115isa;

public class IMain3 {
	public static void main(String[] args) {
		// 상속시켜줄만한 class 하나가 필요
		// 학생 1 : 홍길동,12세,강서초등학교,5학년		<<생성자 오버로딩 X
		Hong h = new Hong();
		h.name = "홍길동";
		h.years = 12;
		h.grup = "강서초등학교";
		h.level = "6학년";
		h.print();
		System.out.println("====================================");
		// 학생 2 : 칼리스타,13세, 강남초등학교 ,6학년	<<생성자 오버로딩 O
		Kalli k = new Kalli("칼리스타",13,"강남초등학교","6학년");
		k.print();
		System.out.println("====================================");
		// 군인 : 김군인 , 23살 ,백골부대 ,병장
		Kimsol kim = new Kimsol("김군인",23,"백골부대","병장");	
		kim.print();
	}
}
