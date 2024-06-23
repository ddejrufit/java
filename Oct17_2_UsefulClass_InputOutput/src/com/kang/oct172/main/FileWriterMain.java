package com.kang.oct172.main;


	
// CPU : 연산장치
// RAM : 저장장치(임시) - 재부팅하면 날아감
// 		static / stack - 프로그램 끄면(종료하면) 날아감
// 		heap - 자동으로 안날아감 (GC 있으면 자동으로 날아감)
// 	HDD (SSD) : 저장장치 (영구) - 폴더/ 파일
// 	GPU : 그래픽처리용(CPU + RAM + HDD)
	
// 프로그램에서는 data를 외부에서 읽고, 다시 외부로 출력하는 작업이 많이 일어남
// data는 사용자로부터 키보드를 이용하여 입력될 수도 있고(Scanner)
// 파일,네트워크(웹)에서 입력될 수도 있다>> Input

// 반대로 데이터는 모니터를 통해서 출력 될 수도 있다 (System.out.println)
// 파일, 네트워크(웹)으로도 출력될 수도 있다>> Output

// System.in -> InputStram
// System.out -> printStream

///////////////////////////////////////////////////////////////////////
// 'Stream' = '빨대'
//	기본형
//		InputStream : 장치(키보드, 파일, 네트워크, ...) -> 프로그램으로 입력 (1byte)
//		InputStreamReader : 장치 -> 프로그램 (2byte) (빨대 크기 up)
//		BufferedReader : (1String -> line) (빨대 크기 UP!)

//		OutputStream : 프로그램 결과 -> 장치(파일, 네트워크, ...) (1byte)
//		OutputStreamWriter : 2byte
//		BufferedWriter : 1String -> line

//	개조형
//		PrintStream (OutputStream개조) : 쓰기 편하게 유용한 메소드들 추가 - syso
//		FileReader (InputStreamReader 개조) : 파일에서 Data를 읽어오기 편하게
//		FileWriter	(OutputStreamWriter 개조) : 데이터 출력 편하게


public class FileWriterMain {
	public static void main(String[] args) {
		
	}
}
