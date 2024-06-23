package com.kang.oct183.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// 통신
//		socket통신
//		HTTP통신 ->  client가 요청(request)하면 server가 그 요청에 맞게 응답(response)

//	과거 Java에는 HTTP 통신을 위한 client 기능이 [없었음] >> 개발을 했어야 함
// 현재 Java에는 다른 개발자가 개발을 해서 공개를 해놨음 -jar파일로-> 코드는 못봄 -> 기능 사용은 가능
// 개발을 할때 남이 만들어놓은거 가져다가 잘 쓰기만 하면 됨!

// chrome에서 apache.org 검색 -> 스크롤로 가장 아랫부분 가기 (APACHE PROJECT LIST)
//-> H목록에 HttpComponents -> 왼쪽에 다운로드 클릭
//-> HttpClient 4.5.14찾기 -> Binary -> 4.5.14.zip 클릭

// jar파일 넣기
//		Package Explorer 에서 jar파일 넣을 프로젝트 찾아서 이름 클릭 -> 마우스 우클릭
//		Build path -> Configure build path
//-> 상단의 Libraries -> 우측 add External JARs
// ->넣을 jar파일이 이쓴ㄴ 경로까지 가서 선택후->finish
//->apply ->appli and close
// -> 다 하면 프로젝트 안에 Referenced Libraries에 내가 넣은 jar파일 확인 가능

public class HMain1 {
	public static void main(String[] args) {
		try {

			// 서버에 접속
			DefaultHttpClient dhc = new DefaultHttpClient();

			// HTTP요청(request) : get(기본) / POST
			HttpGet hg = new HttpGet("https://www.naver.com/");

			// 응답
			HttpResponse hr = dhc.execute(hg);// org.apache.http.httpResponse

			// 응답 내용
			HttpEntity he = hr.getEntity();

			// 내용을 가져올 수 있는 빨대
			InputStream is = he.getContent();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
