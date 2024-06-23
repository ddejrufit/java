package com.kang.oct181.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

// 통신
//		일반적인 통신(요청하면 응답이 오는 것 )- HTTP통신
//		실시간 통신 (냅다 답이 오는 것) - Socket통신

// 서버- 서비스를 제공하는 컴퓨터
// 클라이언트 - 서비스를 이용하는 컴퓨터

// IP주소 - 네트워크 통신을 할 때 사용하는 전화번호
//		확인 : 시작 - cmd - ipconfig
//		 IPv4 주소  : 192.168.0.146

// PORT번호 - 어떤 서비스 이용하러...
//			0~65535
//			웹서비스 : 80원
//			OracleDB:1521번
//			이미 약속된 포트번호가 있어서 4자리 넘게 지정(7876)
public class SSMain1 {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(7876); // 잠시 비워둠 (client 포트번호 입력할 예정)
			System.out.println("...");

			Socket s = ss.accept(); // import java.net.Socket
			System.out.println("연결됨!");

			Scanner k = new Scanner(System.in);
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);

			InputStream is = s.getInputStream(); // java.io.InputStream
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			JFrame jf = new JFrame(); // import javax.swing.JFrame;
			JTextArea jta = new JTextArea();
			jf.add(jta);
			jf.setSize(300, 500);
			jf.setVisible(true);

			Thread t = new Thread() {
				@Override
				public void run() {
					super.run();
					while (true) {
						try {
							jta.append("상대]" + br.readLine() + "\r\n");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}

			};
			t.start();
			while (true) {
				System.out.print("나] ");
				String msg = k.nextLine();
				bw.write(msg + "\r\n");
				jta.append("나]" + msg + "\r\n");
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ss.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
