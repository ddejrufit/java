package com.kang.oct183.main.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

// 모든 (method명, class명, 변수명) 코드 동일하게 작

public class KangHttpClient {
	// 서버에 요청해서 다운받기
	public static InputStream download(String address) throws IOException {
		URL u = new URL(address);
		if (address.startsWith("https")) {
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			return huc.getInputStream();
		} else {
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			return huc.getInputStream();
		}
	}

	// "X-Naver-Client-Id","698asdflawj626"
	// "X-Naver-Client-Secret","sdfdsagaqwadsf"
	// [], List, set, Map
	// 서버에 요청해서 다운받기 (해더처리)
	public static InputStream download(String address, HashMap<String, String> headers) throws IOException {
		URL u = new URL(address);
		if (address.startsWith("https")) {

			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			Set<String> headerName = headers.keySet();
			for (String hn : headerName) {
				huc.addRequestProperty(hn, headers.get(hn));
			}
			return huc.getInputStream();
		} else {
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			Set<String> headerName = headers.keySet();
			for (String hn : headerName) {
				huc.addRequestProperty(hn, headers.get(hn));
			}
			return huc.getInputStream();
		}
	}
	
	// 다운받아온 내용을 String으로 바꾸기
	public static String convert(InputStream is, String charset) throws IOException {
		InputStreamReader isr = new InputStreamReader(is,charset);
		BufferedReader br = new BufferedReader(isr);
		
		String line = null;
		StringBuffer sb = new StringBuffer();
		
		while((line = br.readLine())!= null) {
			sb.append(line);
		}
		return sb.toString();
		
	}
}
