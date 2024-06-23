package com.kang.oct172.main;

import java.io.File;

public class EncodingMain2 {
	public static void main(String[] args) {
		// 폴더 만들기 
		//C:\Users\sdedu\Desktop
		//Window : 경로에 대소문자 구별 안함
		//Linux : 경로에 대소문자 확실히 구별
		// 폴더를 만들고 싶은 위치의 경로
		File makeFolder = new File("C:/Users/sdedu/Desktop/prac");
		if (!makeFolder.exists()) { // 디렉토리에 해당하는 폴더가 없으면
			makeFolder.mkdir(); // mkdir() : make directory 경로만들기
			System.out.println("폴더 생성 완료");
			//	코드~~
		}else {
			System.out.println("폴더가 이미 있움");
		}
	}
}
