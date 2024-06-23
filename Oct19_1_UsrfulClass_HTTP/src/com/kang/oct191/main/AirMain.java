package com.kang.oct191.main;

import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.kang.oct183.main.client.KangHttpClient;

//http://openapi.seoul.go.kr:8088/70646b63596a69683437716f794e49/xml/RealtimeCityAir/1/25/

public class AirMain {
	public static void main(String[] args) {
		try {
			String addr = "http://openapi.seoul.go.kr:8088/" 
					+ "70646b63596a69683437716f794e49/"
					+ "xml/RealtimeCityAir/1/25/";
			
			InputStream is = KangHttpClient.download(addr);
//			String result = KangHttpClient.convert(is, "UTF-8");
//			System.out.println(result); // xml 파일 만들기 위한 코드 가져오기

			// 측정 구, 미세먼지, 초미세먼지, 오존, 이산화질소, 일산화탄소, 아황산가스
			// 토합대기환경등급, 통합대기환경지수
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "UTF-8");

			int type = xpp.getEventType();
			String tagName = null;

			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {// 시작태그에 갔을 때
					tagName = xpp.getName();

				} else if (type == XmlPullParser.TEXT) {// 텍스트에 갔을 때
					if (tagName.equals("MSRSTE_NM")) {
						System.out.printf("측정 구 : %s\r\n", xpp.getText());
					} else if (tagName.equals("PM10")) {
						System.out.printf("미세먼지 : %s\r\n", xpp.getText());
					} else if (tagName.equals("PM25")) {
						System.out.printf("초미세먼지 : %s\r\n", xpp.getText());
					} else if (tagName.equals("O3")) {
						System.out.printf("오존 : %s\r\n", xpp.getText());
					} else if (tagName.equals("NO2")) {
						System.out.printf("이산화질소 : %s\r\n", xpp.getText());
					} else if (tagName.equals("CO")) {
						System.out.printf("일산화탄소 : %s\r\n", xpp.getText());
					} else if (tagName.equals("SO2")) {
						System.out.printf("아황산가스 : %s\r\n", xpp.getText());
					} else if (tagName.equals("IDEX_NM")) {
						System.out.printf("통합대기환경등급 : %s\r\n", xpp.getText());
					} else if (tagName.equals("IDEX_MVL")) {
						System.out.printf("통합대기환경지수 : %s\r\n", xpp.getText());
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					}

				} else if (type == XmlPullParser.END_TAG) {// 종료태그에 갔을 때
					tagName = "";// 정부기관에서 만든 xml파일은 필수
					// XML에서는 띄어쓰기를 텍스트로 인식하는 경우가 있음!

				}
				xpp.next();// 다음 data호 넘어가게
				type = xpp.getEventType();// 다음 태그(<data>)값을 가짐
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
