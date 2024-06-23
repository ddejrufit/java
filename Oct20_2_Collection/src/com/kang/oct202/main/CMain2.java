package com.kang.oct202.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.kang.oct202.student.Student;

public class CMain2 {
	public static void main(String[] args) {
		// com.kang.oct202.student
		// 학생(Student) 객체 : 이름/국어/영어/수학+속성들 출력하는 기능
		Scanner k = new Scanner(System.in);
		System.out.println("번호 > ");
		int no = k.nextInt();
		
		// 1.[]		: X(그냥탈락)
		// 2.List	: O	
	
		// 3.Set	:O(순서개념X
		
		// 4.Map	:X (순서개념 X)
ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("이길동",	70, 80, 90));//0
		students.add(new Student("홍길동",	80, 80, 90));//1
		students.add(new Student("김길동",	90, 80, 90));//2
		students.add(new Student("박길동",	60, 80, 90));//3
		
		//해당 번호 학생의 전체 정보가 출력되게
		students.get(no-1).printInfo();
		System.out.println("---------------------------------------");
		// 해당 번호 학생의 특정 정보가 출력되게 -> 영어
		System.out.println(students.get(no-1).getY());
		System.out.println("영어점수 : " + students.get(no-1).getY()+"점");
		System.out.println("-------------------------");
		//전체 학생의 전체 정보
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i));// 번지값
			students.get(i).printInfo();//전체정보
		}
	}
}
