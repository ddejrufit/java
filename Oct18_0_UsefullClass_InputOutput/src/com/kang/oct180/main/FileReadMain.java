package com.kang.oct180.main;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReadMain {
	public static void main(String[] args) {

		// fr 위에 br을 덧씌운 상태
		// 연관된 것들 중에 하나만 닫으면 다 닫힘처리가 됨!

		BufferedReader br = null;
		try {
			// 파일 -> 프로그램(InputStreamReader 개조형)
			FileReader fr = new FileReader("c:/Users/sdedu/desktop/oct1.txt");
			br = new BufferedReader(fr);

			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
