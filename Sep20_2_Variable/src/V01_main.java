// Sep20_2_Variable
public class V01_main {
	public static void main(String[] args) {
//		System.out.println("확인");
		// Variable(변수) : 변하는 수, data를 저장하는 공간
		// CPU : 연산장치(intel, ...)
		// HDD(SSD) : 파일 형태로 저장하는 장치 (영구저장)
		// RAM : 변수 형태로 저장하는 장치
		//			임시저장 -> 컴퓨터 종료하면 메모리도 함께 증발
		// GPU : (CPU + HDD + RAM) 그래픽 처리용
		
		// 데이터를 임시보존 : RAM에 변수로 저장
		// 데이터를 영구보존 : HDD에 파일로 저장
		
		// 변수 : data를 저장하는 공간(그릇)
		// 변수를 만든다 : 변수를 [선언]한다
		// 자료형 변수명;
		String s; // String(글자데이터)이라는 자료형을 가진 데이터를 담는 s라는 변수
		int i; // int(정수데이터)라는 자료형을 가진 데이터를 담는 i라는 이름의 변수
		// 자료형 변수명 = 값;
		//	우항의 값을 좌항에 넣어라
		//	값을 변수에 넣어라
		String name = "정지희";
		System.out.println(name);   // 정지희
		System.out.println("name"); // name
		
		int floor = 5;
		System.out.println(floor);
	}
}




