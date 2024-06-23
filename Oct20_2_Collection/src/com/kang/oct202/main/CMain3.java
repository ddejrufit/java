package com.kang.oct202.main;

import java.util.HashMap;
import java.util.Scanner;

import com.kang.oct202.student.Student;

public class CMain3 {
	public static void main(String[] args) {
	//학생의 이름을 입력했을 때
	// 그 학생의 전체정보 출력 하고 싶음
	
	// Map계열 vs List계열
		
			Scanner	k = new Scanner(System.in);
			System.out.print("이름 > ");
			String name=k.next();
			
			
			
			HashMap<String, Student>hm = new HashMap<String,Student>();
			hm.put("홍길동",new Student("홍길동",	80, 80, 90));
			hm.put("이길동",new Student("이길동",	70, 80, 90));
			hm.put("김길동",new Student("김길동",	90, 80, 90));
			hm.put("박길동",new Student("박길동",	60, 80, 90));
			
			hm.get(name).printInfo();
		}  
}
