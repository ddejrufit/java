package com.kang.oct180.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriteMain {
	public static void main(String[] args) {
		//System.in : 콘솔창-> 프로그램(InputStram)
		//Scanner : InputStream을 편하게 사용하기 위해 서폿트!
		// ㄴJDK 1.5부터 지원하는 기능
		Scanner k = new Scanner(System.in);
		System.out.println("입력 > ");
	   String cmt = k.nextLine();// enter 전까지 글이 전부 담김
	   // System.out : 프로그램 -> 콘솔창(PrintStream)
	   System.out.println("-------------------------------");
//	   FileWriter
	   // 	프로그램_> 파일(OutputStraemWriter의 개조형)
	   // 	파일이 없으면 만들어주기도 함(폴더는 안만들어줌)
	   //	Linux 경로 >> c:/Users/sdedu/desktop/oct.txt
	   //	Window 경로>> c:\\Users\\sdedu\\desktop\\oct.txt \\
	   //	Window 원래 경 로>> c:/Users/sdedu/desktop
	   
	   //	\로 경로 설정할때 \\로 사용하는 이유 :이스케이프 문자와 겹쳐서
	   //	Java의 \ : \t, \r, \n ....


	   BufferedWriter bw = null;
	   //	권한, 폴더명에 오타가, ...-> 예외처리
	  
	   try {
		   //	()안에 지정된파일이 이미 존재하면 덮어쓰기 떄문에
		   //	기존에 있던 내용이 사라지게 됨
		   //	기존의 내용에 덧붙이고 싶은 거라면(data를 추가 하고 싶다면)
		   // 	두번째 파라미터 값으로 true 를 주면 됨
		   
		   //	Encoding방식 지정x -> ANSI로 인코딩(American National Standard Institute)
		 FileWriter fw = new FileWriter("c:/Users/sdedu/desktop/oct1.txt",true);
		 
		 //	1 byte 씩 입출력 하기 보다는
		 //	'buffer'를 이용해서 한번에 여러바이트를 입출력하는 것이 효율적!
		 //			=> 대부분의 입출력 작없에서 사용
		 //	buffer : HDD와 CPU 사이에서 사용되는 임시 저장공간
	 //	버퍼링 : data를 버퍼로 저장하는 동작 => 실행성능 향상 시킬 수 있음~!
		 bw = new BufferedWriter(fw);
		 bw.write(cmt + "\r\n");
		 bw.flush(); // buffer의 용량이 다 차지 않더라도 강제적으로 내보내기
		 			// 모든 데이터 다 보내기
	} catch (Exception e) {
		e.printStackTrace();
	}
	   try {
		bw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	   
	}
}
