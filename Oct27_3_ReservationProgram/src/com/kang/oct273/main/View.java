package com.kang.oct273.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import javax.tools.DocumentationTool.Location;

import com.kang.oct273.restaurant.Restaurant;
import com.kang.reservation.Reservation;

public class View {

	public static int showMainMenu() {
		Scanner k = new Scanner(System.in);
		System.out.println("=========================");
		System.out.println("1. 예약하기");
		System.out.println("2. 매장등록");
		System.out.println("3. 전체 예약 확인");
		System.out.println("4. 전체 매장 조회");
		System.out.println("5. 매장찾기");
		System.out.println("6. 예약찾기");
		System.out.println("7. 예약정보수정");
		System.out.println("8. 예약취소");
		System.out.println("9. 프로그램 종료");
		System.out.println("=========================");
		System.out.println("번호 입력 > ");
		return k.nextInt();
	}

	public static void printResult(String result) {
		System.out.println(result);
	}
	// 1. 예약하기 (직접 입력, 날짜는 연-월-일/시:분)
	public static Reservation showRsvMenu() throws ParseException {
		Scanner k = new Scanner(System.in);
		
		System.out.print("예약자 > ");
		String name = k.next();
		
		System.out.println("예약 날짜(YYYY-MM-DD/HH:mm)>");
		String when = k.next();
		// String으로 받은 내용을 Date로 : parse
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm");
		Date when2 = sdf.parse(when);
		
		System.out.print("연락처 > ");
		String phone = k.next();
		
		System.out.println("지점명 > ");
		String location = k.next();
		
		//  View에서 만든 내용 return해서 Controller 거쳐서 DAO(moder)로 이동해야만 함
		//	return이 필요한데, Java는 리턴값이 하나만 가능
		// 	근데 우리는 지금 4개를 return 시켜야 함! => JavaBean(네개를 세트로 하니 포장을 해서)
		// 포장 자체를 return 시키면 된다!
		
		//JavaBean 객서 하나 꺼냄
		Reservation r = new Reservation(0,name,when2,phone,location);
		return r;
		}
	
	//2. 매장등록
	public static Restaurant showRstMenu() {
		Scanner k = new Scanner(System.in);
		
		System.out.print("지점 : ");
		String location = k.next();
		
		System.out.print("지점장 : ");
		String owner = k.next();
		
		System.out.print("좌석수 : ");
		int seat = k.nextInt();
		
		// javabean의 생성자 오버로딩 쪽 피라미터 확인해서 순서 check
		return new Restaurant(location, owner, seat);
		
	}

	// 3. 전체 예약 확인 (날짜 연-월-일 요일 오전/오후 시:분) - CRUD ?
	public static void showRsvResult(ArrayList<Reservation> rsvs) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd E a hh:mm");
		for (Reservation r : rsvs) {
			System.out.printf("%d) ",r.getR_no());
			System.out.printf("[%s - ",r.getR_name());
			System.out.printf("%s] : ",r.getR_phone());
			System.out.printf(r.getR_location()+" - ");
			System.out.printf(sdf.format(r.getR_time())+"\r\n");
		}
	}
	
	
/*	public static void showRsvResult(ArrayList<Reservation> rsvs) {
		for (Reservation r : rsvs) {
			System.out.printf("%d, %s, YYYY-MM-DD e a HH24:MI, %s, %s",r.getR_no(),r.getR_name(),r.getR_time(),r.getR_phone(),r.getR_location());
		
		}
	}
	*/
	// 4. 전체 매장 조회 [위치(좌석수) - 지점장 이름] / 인천(120) - 박길동 - CRUD ?
	public static void showRstResult(ArrayList<Restaurant> rsts) {
		for (Restaurant r : rsts) {
			System.out.printf("%s()%d - ",r.getR_location(),r.getR_seat());
		System.out.printf("[%s]\r\n",r.getR_owner());
		
		
		}
	}
	
	// 5. 매장찾기 (최소 좌석수를 입력 -> 좌석수 이상의 매장 정보 출력) - CRUD ?
	public static Restaurant showSearchRst() {
		Scanner k = new Scanner(System.in);
		System.out.println("최소 좌석수 >");
		int seat = k.nextInt();
		// 새 restaurant 객체를 꺼내서 내가 입력하는 부분만 넣고 return
		return new Restaurant(null, null, seat);
	}
	
	
	/*public static int surchRst() {
		Scanner k = new Scanner(System.in);
		System.out.print("예약할 좌석 갯수 :");
		int a = k.nextInt();
		
		return a;
	}*/
	
	
	// 6. 예약찾기 (예약자 이름으로 예약찾기) - CRUD ?
	
	public static Reservation showSearchRsv() {
		Scanner k = new Scanner(System.in);
		System.out.println("예약자명 >");
		String name = k.next();
		// name에 해당하는 부분을 제외하고 나머지는 자료형 초기값으로
		return new Reservation(0, name, null, null, null);
	}
	
	
	
	
	
/*	public static String rsvName() {
		Scanner k = new Scanner(System.in);
		System.out.println("예약자 성함 >");
		String b = k.next();
		
		return b;
		
	}
	*/
	
	
	// 7. 예약정보수정 (예약번호를 입력하면, 연락처를 변경) - CRUD ?
	public static Reservation showUpdaterrsv() {
		Scanner k = new Scanner(System.in);
		System.out.print("예약번호 >");
		int no = k.nextInt();
		System.out.print("변경할 연락처 :");
		String phone = k.next();
		return new Reservation(no, null, null, phone, null);
	}

	
	
	
	/*public static int reRsv() {
		Scanner k = new Scanner(System.in);
		System.out.print("예약 번호 >");
		int c = k.nextInt();
		return c;
	
	}
	public static String reRsv2() {
		Scanner k = new Scanner(System.in);
		System.out.print("수정할 연락처 > ");
		String d = k.next();
		return d;
	}
	*/
	// 8. 예약 취소 (예약번호로 취소) - CRUD ?
		public static Reservation deletersv() {
			Scanner k = new Scanner(System.in);
			System.out.print("예약번호 >");
			int no = k.nextInt();
			return new Reservation(no, null, null, null, null);
		}
	
/*public static int deleteRsv() {
	Scanner k = new Scanner(System.in);
	System.out.println("예약취소할 예약번호 >");
	int f = k.nextInt();
	return f;
} 
*/
}
