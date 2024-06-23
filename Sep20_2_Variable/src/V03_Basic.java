
public class V03_Basic {
	public static void main(String[] args) {
		// 변수를 선언
		int day;
		// 선언한 변수에 값을 넣어주기
		day = 20;
		System.out.println(day);
		// 학원 층 -> 5층
		// 변수를 선언한 후
		int floor;
		// 선언한 변수에 값을 넣어주기
		floor = 5;
		floor = 6; // 변수명 = 값;을 사용해서 값을 변경할 수도 있다~
//		floor = 5.5; -> 자료형을 정수형으로 했기때문에 실수는 사용 불가
//		floor = "soldesk";
		// console로 찍어보기
		System.out.println(floor);
		double abc;
		abc = 5; // 실수형에 정수형을 넣는 것은 가능!
		// Java는 자료형을 미리 지정해두기 때문에 자료형이 일치하지 않는 값이 들어가면
		// 오류가 발생!!
		
		// 자료형 변수명 = 값;
		// 생일 일자
		int bd = 17;
//		int bd = 14; // 불가능
		bd = 14; // 값을 변경하고 싶을 땐 자료형을 빼고
		///////////////////////////////
		// 변수 이름 정하는 규칙
		//	1. 같은 이름을 사용할 수 없다
		//	2. 대 소문자 구분함
		//		String soldesk; String solDesk; << 서로 다름
		//  3. 숫자로 시작하지 않음
		//		double 2example;(x), double example2(o)
		//	4. Java 예약어(Java에서 사용하는 문법)는 사용 불가
		//		public, static, void, class, ...
		//	5. 특수기호는 두가지(_, $) 빼고는 불가능
		//		int price_of_computer; // 뱀체
		//	6. 낙타체(카멜케이스) 사용 가능
		//		int priceOfComputer;
		//	7. 어떤 데이터를 담고 있는지 명확하게 파악할 수 있도록 짓는 것이 중요!
		
		// 자료형 변수명 = 값;
		// 핸드폰 기종 => iPhone 14Pro
		String phone = "iPhone 14Pro";
		// 점심시간에 먹고싶은 메뉴
		String lunchMenu = "김치찌개";
		// 키 >> cm, 소수점
		double height = 165.2;
		// 사는 층 13
		int myPlace = 13;
		// 점심시간이 끝나는 시간 : 2
		int lunchTime = 2;
		// 한번 지정한 변수명은 ctrl + space로 자동완성 하여 쓰는 것이
		// 오타 확률 줄일 수 있음!!(tip : 글자를 어느정도 쓴 후에 자동완성 하기)
		System.out.println(phone);
		System.out.println(lunchMenu);
		System.out.println(height);
		System.out.println(myPlace); // 13
		System.out.println(lunchTime);
		// 변수끼리 연산 가능
		System.out.println(myPlace + lunchTime);
		System.out.println(myPlace - lunchTime);
		System.out.println(myPlace * lunchTime);
		System.out.println(myPlace / lunchTime);
		// 변수에 변수를 대입
		// A = B // A에 B를 넣는다(좌항을 우항에 넣는다)
		// 13		2
		myPlace = lunchTime; // lunchTime의 데이터를 myPlace에 넣기
		System.out.println(myPlace); // 2
		System.out.println(lunchTime);
		
		
	}
}




