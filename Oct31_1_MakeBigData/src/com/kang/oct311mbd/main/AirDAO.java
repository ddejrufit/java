package com.kang.oct311mbd.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.kang.db.manager.KangDBManager;
import com.kang.oct183.main.client.KangHttpClient;


//서울시 권역별 실시간 대기환경 현황
//http://openapi.seoul.go.kr:8088/70646b63596a69683437716f794e49/xml/RealtimeCityAir/1/25/

// 가장 먼저 : DB테이블 만들기
//	xml 파싱 -> DB에 insert -> select * 확인해서 arrayList담기 -> .csv파일로 내보내기

// jar파일
//		1. JDBC를 위한 jar	:ojdbc 8.jar
//		2. xml을 위한 jar1	: kxml2.jar
//		3. xml을 위한 jar2	: HttpClient.jar
//		4. Java와 DB 연결을 해주는 jar	: DBManager.jar

// Model -> DAO
//		원래 method는 알파벳 순으로 정렬!!★
public class AirDAO {
	
	// 0. xml파싱 -> console에 찍히는지!!
	//		Oct19_1_UsrfulClass_HTTP 프로젝트 참고해서
	
	
	// 1. xml파싱 -> Javabean에 맞추어 담고 -> ArrayList
	public static ArrayList<Air> getAir() {
		try {
			// 서버에 요청해서 다운받기
			String addr="http://openapi.seoul.go.kr:8088/70646b63596a69683437716f794e49/xml/RealtimeCityAir/1/25/";
			InputStream is = KangHttpClient.download(addr);
			// xml 시작할 준비
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			
			XmlPullParser xpp = xppf.newPullParser();
			
			xpp.setInput(is, "UTF-8");
			
			// 현재 xpp가 보고있는 line
			int type = xpp.getEventType();
			// xml 찾을 때 사용할 임시변수
			String tagName = null;
			
			// 빈 arraylist
			ArrayList<Air> airs = new ArrayList<Air>();
			// air용 자바빈
			Air a = null;
			
			
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
					if (tagName.equals("row")) {
						// row가 새로 나올 때마다 새로운 객체 생성
						a = new Air();
					}
				}else if (type == XmlPullParser.TEXT) {
					// javabean의 멤버 변수에 맞추어 데이터 setting하기
					if (tagName.equals("MSRSTE_NM")) {
//						System.out.println(xpp.getText());
						a.setSa_msrste_nm(xpp.getText());
					}else if (tagName.equals("PM10")) {
//						System.out.println(xpp.getText());
						// xml에서는 String -> javabean 멤버 변수 int
						// String -> int로 형변환
//						int ii = Integer.parseInt(xpp.getText());
//						a.setSa_pm10(ii);
						a.setSa_pm10(Integer.parseInt(xpp.getText()));
					}else if (tagName.equals("PM25")) {
//						System.out.println(xpp.getText());
						a.setSa_pm25(Integer.parseInt(xpp.getText()));
					}else if (tagName.equals("O3")) {
//						System.out.println(xpp.getText());
						a.setSa_o3(Double.parseDouble(xpp.getText()));
					}else if (tagName.equals("IDEX_NM")) {
//						System.out.println(xpp.getText());
						a.setSaa_idex_nm(xpp.getText());
						// ▲ 여기까지 javabean하나 채우기 완성!
						//	하나 완성되면 arrayList에 javabean 담기
						airs.add(a);
					}
					
				}else if (type == XmlPullParser.END_TAG) {
					tagName ="";
				}
				xpp.next(); type = xpp.getEventType();
			}
			// 반복문 다 돌았을 떄 ArrayList 자체를 return
			return airs;
			
		} catch (Exception e) {
			// 개발자가 error 확인하는 용도, 배포시에는 주석처리 하고
			e.printStackTrace();
			return null;
		}
	}

	// 2. javabean에 담겨있는 정보를 DB에 c(insert) 하는 작업 -> GetAirController에서 실행 
//	-> result쪽에서 잘 들어갔는지 확인!
	public static String writeAir(Air a) {
		Connection con = null;
		PreparedStatement pstmt =null;
		try {
			// 내 DB 서버와 연결
			con = KangDBManager.connect();
			
			// xml로 수집한 자료를 넣을 sql문
			String sql ="insert into seoul_air values(seoul_air_seq.nextval, sysdate, "
					+ "?,?,?,?,?)";
			
			// DB에 자료를 옮길 통로 하나 생성(총괄객체)
			pstmt = con.prepareStatement(sql);
			
			// ? 채우기 - a는 parameter로 가져온 javabean
			pstmt.setString(1, a.getSa_msrste_nm());
			pstmt.setInt(2, a.getSa_pm10());
			pstmt.setInt(3, a.getSa_pm25());
			pstmt.setDouble(4, a.getSa_o3());
			pstmt.setString(5, a.getSaa_idex_nm());
			
			// insert 덕분에 한줄 변화가 생기면
			if (pstmt.executeUpdate() == 1) {
				return "성공";
			}
			// 변화가 없으면
			return "실패";
		} catch (Exception e) {
			e.printStackTrace();
			// 뭐가 아예 안될때, error일 때
			return "에러";
		}finally {
			KangDBManager.close(con, pstmt, null);
		}
	}
	
	// 3. DB에 들어간 정보 받아와서 javabean 채우고, Arraylist에 담고
	//		ㄴ DB에 담긴 모든 data 시간순 정렬
	public static ArrayList<Air> getMyAir() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KangDBManager.connect();
			
			String sql = "select * from seoul_air order by sa_MSRDT ";
			
			pstmt = con.prepareStatement(sql);
			
			// select문에서만 해당하는 list랑 비슷한
			// select문으로 가지고 온 data를 rs에 담아줌
			rs = pstmt.executeQuery();
			
			// 완성된(포장된)자바빈 담을 빈 ArrayList 준비
			ArrayList<Air> airs = new ArrayList<Air>();
			
			// 빈 Javabean 준비
			Air a = null;
			while (rs.next()) {
				// while문 한 번 돌때마다 새로운 객체 생성
//				a = new Air();
				//DB필드명 그대로 get(가져와서) 새로운 객체에 set(담기)
//				a.setSa_no(rs.getInt("sa_no"));
				
				// 완성된 javabean을 arraylist에 담기
				airs.add(
						new Air(rs.getInt("sa_no"),
						rs.getDate("sa_MSRDT"),
						rs.getString("sa_MSRDT_NM"),
						rs.getInt("sa_PM10"),
						rs.getInt("sa_PM25"),
						rs.getDouble("sa_O3"),
						rs.getString("sa_IDEX_NM")));
			}
			return airs;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			KangDBManager.close(con, pstmt, rs);
		}
	}
	
	// 4. ArrayList에 담긴 정보를 csv file에 담기
	// 파일명.확장자(GetAir.jar / GetAir.bat / ...)
	// .확장자 -> Microsoft에만 있는 개념
	//		사람들이 보기 편하게
	//		리눅스 >> '확장자'가 없음
	
	// air.txt
	//		텍스트파일(문서)
	//		메모장이라는 프로그램에서 [잘]열리는 파일
	
	// air.xls : 엑셀에서 잘 열리는 파일
	// air.ppt : 파워포인트에서 잘 열리는 파일
	
	// .csv(Comma Separated Value)
	//		 각각의 값들이 ,(comma)로 구분된 파일
	//		엑셀에서 가장 잘 열림.. -> 엑셀에서 utf-8을 소화 못해
	//		메모장에서 열어볼 것.
	public static void writeToFile(ArrayList<Air> airs) {
//		FileWriter fW = null; // 인코딩 방식 지정이 안됨
		FileOutputStream fos = null;
		try {
			// 파일 저장될 위치 지정 + 누적으로 할지 안할지(누적 : true, 리셋 : 암것도 안함)
			fos = new FileOutputStream("C:\\Users\\chanwoo kang/air.csv", true);
			// 프로그램 -> 파일로 내보내기 : outputstream + 파일쓰기 : writer
			// + 인코딩 방식 지정
			OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
			// 더 큰 최대 용량까지 커버가 가능하도록
			BufferedWriter bw = new BufferedWriter(osw);
			
			// 날짜 바꿔주기 : Date(sysdate) - (형식지정) -> String
			// kk : 24시간제
			SimpleDateFormat sdf = new  SimpleDateFormat("yyyy,MM,dd,kk,mm");
			
			// ArrayList<Air>에 있는 JavaBean 하나하나 뜯어서 scv파일 한줄로 옮길 것
			// 하나의 큰 통(ArrayList)에 있던 낱개포장(Javabean)을 하나 하나 뜯어서 파일로 옮기겠다
			for (Air a : airs) {
//				bw.write(a.getSa_no()+","); >> sequence 준거라 순서 엉망이어서 의미 X
				// Date -> String : format / String -> Date : parse
				bw.write(sdf.format(a.getSa_msrdt()) + ",");
				bw.write(a.getSa_msrste_nm()+",");
				bw.write(a.getSa_pm10()+",");
				bw.write(a.getSa_pm25()+",");
				bw.write(a.getSa_o3()+",");
				bw.write(a.getSaa_idex_nm()+"\r\n");
				// BufferedWriter의 용량이 다 차지 않아도 그냥 일단 보내도록 하는
				bw.flush();
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
