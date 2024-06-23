package com.kang.oct182.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SCMain1 {
	public static void main(String[] args) {
		Socket s = null;
		try {
			s = new Socket("192.168.0.128", 2486); // (상대ip주소, port번호)
			System.out.println("연결됨 ! ");
			Scanner k = new Scanner(System.in);

			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);

			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			while (true) {
				System.out.printf("상대] %s\r\n", br.readLine());
				System.out.print("나] ");
				String msg = k.nextLine();
				bw.write(msg + "\r\n");
				bw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
