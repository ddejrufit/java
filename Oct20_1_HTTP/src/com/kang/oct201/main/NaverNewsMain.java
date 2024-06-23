package com.kang.oct201.main;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import javax.print.CancelablePrintJob;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.kang.oct183.main.client.KangHttpClient;

//nTEwcf7zf3rrcxmhOeww
//4DKFVY5j3t

public class NaverNewsMain {
	public static void main(String[] args) {
		try {
			// 인터넷 주소창에 한글 X -> 인코딩 방식을 설정
			Scanner k = new Scanner(System.in);
			System.out.print("검색 > ");
			String search = k.next();
			System.out.println(search);
			search = URLEncoder.encode(search, "UTF-8");
//			System.out.println(search);

			String addr = "https://openapi.naver.com/v1/search/news.xml";
			addr += "?query=" + search;

//			InputStream is = KangHttpClient.download(addr);
//			String result = KangHttpClient.convert(is, "UTF-8");
//			System.out.println(result);

			// 헤더처리
			// HTTP해더 : client와 server가 요청하고 응답하는 것으로
			// 부가적인 정보 전송이 가능하게 하는 것
			HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("X-Naver-Client-Id", "nTEwcf7zf3rrcxmhOeww");
			headers.put("X-Naver-Client-Secret", "4DKFVY5j3t");
			InputStream is = KangHttpClient.download(addr, headers);
//			String result = KangHttpClient.convert(is, "UTF-8");
//			System.out.println(result);

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "UTF-8");

			int type = xpp.getEventType();
			String tagName = null;
			String t = null; // 임시변수 변수명 : t
			boolean item = false;
			
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
					//<item>에 있는 title과 description만 가져오도록 하기 위해
					if (tagName.equals("item")) {
						item = true;
					}
				} else if (type == XmlPullParser.TEXT) {
					if (item) {
						
					
					if (tagName.equals("title")) {
						t = xpp.getText();
						t = t.replace("<b>", "[");
						t = t.replace("</b>", "]");
						System.out.println("제목 : " + t);
					} else if (tagName.equals("description")) {
						t = xpp.getText();
						t = t.replace("<b>", "[");
						t = t.replace("</b>", "]");
						System.out.println("내용 : "+t);
						System.out.println("=-=-=-=-=-=-=-=-=-");
					}
				}
				} else if (type == XmlPullParser.END_TAG) {
					tagName = "";
				}
				xpp.next();
				type = xpp.getEventType();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}