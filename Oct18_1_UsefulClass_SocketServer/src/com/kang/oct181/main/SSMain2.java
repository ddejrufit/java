package com.kang.oct181.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Oct18_1_UsefulClass_SocketServer
public class SSMain2 {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(7876); // port번호 넣기
			
				System.out.println("..연결중..");
			

				
	
			Socket s = ss.accept();
			
			System.out.println("연결됨!!");
			
			Scanner k = new Scanner(System.in);
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			while (true) {
				System.out.print("나] ");
				String msg = k.next();
				bw.write(msg +"\r\n");
				bw.flush();
			}
					
					
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
