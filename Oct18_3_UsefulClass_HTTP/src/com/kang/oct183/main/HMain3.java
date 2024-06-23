package com.kang.oct183.main;

import java.io.InputStream;

import com.kang.oct183.main.client.KangHttpClient;

// Jar파일 만드는 법
//	Jar파일로 만들 파일을 클릭 -> 우클릭 -> EXport
//		jar file -> Browse클릭 -> jar파일 파일명 입력 -> 저장
//		-> finish
public class HMain3 {
	public static void main(String[] args) {
		try {
			String addr = "https://post.naver.com/viewer/postView.naver?memberNo=8224696&volumeNo=36738546&isInf=true";
					InputStream is = KangHttpClient.download(addr);
					
					String result = KangHttpClient.convert(is, "UTF-8");
					System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
