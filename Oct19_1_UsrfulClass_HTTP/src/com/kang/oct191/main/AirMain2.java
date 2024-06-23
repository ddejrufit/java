package com.kang.oct191.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.kang.oct183.main.client.KangHttpClient;

//미세먼지 -> 파싱 -> 값들을 -> txt 파일에 담기
// 날짜, 측정구,미세먼지, 초미세먼지,오존,통합대기환경지수
//현재,

//연-월-일-오후-시,강동구,25,21,0.014,59
public class AirMain2 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			String fileName = "C:/Users/sdedu/Desktop/air.txt";

			fos = new FileOutputStream(fileName, true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);

			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-a-hh:mm", Locale.KOREAN);
			String s1 = sdf.format(now);

			String addr = "http://openapi.seoul.go.kr:8088/" + "70646b63596a69683437716f794e49/"
					+ "xml/RealtimeCityAir/1/25/";

			InputStream is = KangHttpClient.download(addr);

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
						System.out.println(s1);
						bw.write(s1 + ",");

						System.out.printf("측정 구 : %s\r\n", xpp.getText());
						bw.write(xpp.getText() + ",");

					} else if (tagName.equals("PM10")) {
						System.out.printf("미세먼지 : %s\r\n", xpp.getText());
						bw.write(xpp.getText()+",");
					} else if (tagName.equals("PM25")) {
						System.out.printf("초미세먼지 : %s\r\n", xpp.getText());
						bw.write(xpp.getText()+",");
					} else if (tagName.equals("O3")) {
						System.out.printf("오존 : %s\r\n", xpp.getText());
						bw.write(xpp.getText()+",");
					} else if (tagName.equals("IDEX_MVL")) {
						System.out.printf("통합대기환경지수 : %s\r\n", xpp.getText());
						bw.write(xpp.getText()+",");
						System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
						bw.write(xpp.getText()+"\r\n");
						bw.flush();
					}

				} else if (type == XmlPullParser.END_TAG) {// 종료태그에 갔을 때
					tagName = "";// 정부기관에서 만든 xml파일은 필수
					// XML에서는 띄어쓰기를 텍스트로 인식하는 경우가 있음!
				}
				xpp.next();// 다음 data호 넘어가게
				type = xpp.getEventType();// 다음 태그(<data>)값을 가짐
			}
			System.out.println("파일 쓰기 완료");

		} catch (Exception e) {
			e.printStackTrace();

		}try {
			fos.close();
		} catch (IOException e) {
		e.printStackTrace();
		}

	}
}
