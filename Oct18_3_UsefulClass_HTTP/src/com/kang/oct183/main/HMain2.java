package com.kang.oct183.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

// Java애 HTTP통신이 생겼음!! -> HMain1에서 했던 jar파일 필요 없어졌음!!

// http or https

public class HMain2 {
	public static void main(String[] args) {
		
		try {
			String addr = "https://www.naver.com";
			URL u = new URL(addr);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			
			// 외부에있는 것을 프로그램으로 가지고 오는 : input
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			String line = null;
			while ((line = br.readLine())!=null) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
