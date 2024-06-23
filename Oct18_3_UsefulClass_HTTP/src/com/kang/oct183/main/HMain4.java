package com.kang.oct183.main;

import java.io.InputStream;

import com.kang.oct183.main.client.KangHttpClient;

public class HMain4 {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = KangHttpClient.download("https://post.naver.com/viewer/postView.naver?memberNo=8224696&volumeNo=36738546&isInf=true");
			String result = KangHttpClient.convert(is, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
