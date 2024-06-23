package com.kang.oct201.main;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.kang.oct183.main.client.KangHttpClient;

//REST API 키	d422bbb8e4b653097744b4d9a1a6320f
//JavaScript 키	1397585099bdaf0bfcbdea3ecc5b45a1

// 우리집 주변 반경 5km 이내에 내가 검색한 키워드가 포함된 가게를 거리 기준으로 15개 정렬
// 구글 주소창에서 !3d, !4d 부분 찾기
//37.50516667526(위도-y)  127.0269282584854(경도-y)

// 위도(Latitude)/ 경도 (Longitude)

// 위도 : 적도 (0도) 기준으로 북/ 남으로 구분
//		적도 기준으로 얼마나 떨어져있는지 나타내는 위치
//		북극점 (북위 90도) / 남극점 (남위 90도) : 최고 숫자가 90을 넘을수 없다

//경도 : 그리니치 천문대를 기준으로 동/서 로 구분
//		날짜변경선이 동경 180도/서경 180도 만나는 곳
public class LocSearchMain {
	public static void main(String[] args) {
		try {
			Scanner k = new Scanner(System.in);
			System.out.print("검색 > ");
			String search = k.next();
			search = URLEncoder.encode(search, "UTF-8");
//			System.out.println(search);

			String addr = "https://dapi.kakao.com/v2/local/search/keyword.json";
			addr += "?query=" + search; // 검색어
			addr += "&x=127.0269282584854&y=37.50516667526";// 좌표설정(중심)
			addr += "&radius=5000"; // 중심주변 반경거리
			addr += "&sort=distance"; // 정렬방법(거리순)

//		Authorization: KakaoAK d422bbb8e4b653097744b4d9a1a6320f
			HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("Authorization", "KakaoAK d422bbb8e4b653097744b4d9a1a6320f");
			InputStream is = KangHttpClient.download(addr, headers);
			String str = KangHttpClient.convert(is, "UTF-8");
//			System.out.println(str);

			// 패키지명 우클릭 -> New -> file -> 파일명 : location.json
			// -> 복붙 -> ctrl + shift + f
			JSONParser jp = new JSONParser();

			JSONObject jo = (JSONObject) jp.parse(str);
			JSONArray documents = (JSONArray) jo.get("documents");
			for (int i = 0; i < documents.size(); i++) {

				JSONObject jo2 = (JSONObject) documents.get(i);
				// 주소
				String address_name = (String) jo2.get("address_name");
				System.out.println(address_name);
//			전화번호
				String phone = (String) jo2.get("phone");
				System.out.println(phone);
//			상호명
				String place_name = (String) jo2.get("place_name");
				System.out.println(place_name);
//		우리집과의 거리
				String distance = (String) jo2.get("distance");
				System.out.println("거리 : " + distance + "m");
				System.out.println("==============================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
