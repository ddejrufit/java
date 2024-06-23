package com.kang.oct172.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class EncodingMain {
	// Encoding : 정보의 형태나 형식을 변환하는 처리방식
	// 컴퓨터 : 전자기계(전기가 흐르거나, 안흐르거나)
	// 'ㅋ' -> 전기의 흐름으로 표현 : encoding

	// Decoding : 인코딩 된 데이터 통신 전송 및 파일을 원래의 상태로 변환
	// 전기의 흐름으로 표현 -> 'ㅋ' : decoding

	// encoding 방식의 종류
	// 크리스마스 -A-> 1010111000 -A-> 크리스마스
	// 크리스마스 -B-> 0101000111 -c-> 새해

	// 전세계적으로 주력 : UTF -8(Unicode Transform Format)
	// 한국만 타겟 : EUC-KR
	// MS전용 : MS949
	// 인코딩을 따로 지정하지 않으면 OS에서 사용하는 인코딩으로 데이터를 저장

	// 사람이 [문자] <-> 컴퓨터 [binary data]
	// 사람이 작성한 문자는 numberic codes 숫자 표현 코드로 변환되어야 컴퓨터가 이해
	public static void main(String[] args) {
		// 빈파일 생성 -> 글을 쓰기(Program)
		// 파일을 열어서 확인(I/O Device)
		// C:\Users\sdedu\Desktop\230919\classDoc
/*		FileOutputStream fos = null;
		try {
			// 경로에 해당하는 이름의 파일이 없으면 새로 생성
			// 경로에 해당하는 이름의 파일이 있으면 그 파일 찾아주기
			fos = new FileOutputStream("C:\\Users\\sdedu\\Desktop\\230919\\classDoc\\Oct171.txt", true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 인코딩 방식 설정
		OutputStreamWriter osw = null;
		try {
			osw = new OutputStreamWriter(fos, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// 상단 경로 부분에 true를 써야 append가 적용
		// true를 사용하지 않으면 appemd를 해도 덮어쓰기
		// 이어쓰기가 가능해지려면 true를 경로 뒤 옵션에 적어야!
		BufferedWriter bw = new BufferedWriter(osw);
		try {
			bw.write("피카츄 라이츄\r\n");
			bw.write("파이리 꼬부기 \r\n");
			bw.write("버터풀 야도란\r\n");
			bw.write("피존투 또가스 \r\n");	//.write() : 덮어쓰기
			bw.append("으아아아아아아아악\r\n");// .append() : 이어쓰기
			bw.append("안녕 디지몬");
			bw.flush(); // BufferedWriter 쓸때 마지막에 꼭 써줘야!
			System.out.println("the end");
		} catch (IOException e) {
			e.printStackTrace();
			
			
		}		*/
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\sdedu\\Desktop\\230919\\classDoc\\Oct171.txt");
					InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
					
					br = new BufferedReader(isr);
					String line = null;
					while ((line = br.readLine()) !=null) {
						System.out.println(line);
					}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
