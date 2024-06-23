// 알고리즘의 시대 -> 유지보수의 시대

// PP(절차지향프로그래밍 - Procedural programming)
//		순서대로 잘 프로그래밍을 해서 결과를 내자
//		변수를 하나라도 덜 쓰고, 효율적으로 코드를 짜고,..
//		조건문(ifa문), 반복문 (while문)
//		시간의 흐름에 따라, 사건의 흐름에 따라 프로그래밍이 가능
// 
// OOP(객체지향프로그래밍 - Object Oriented Programming)
//		실생활을 묘사한다, 표현한다
//		코드를 볼 때 좀 더 편함 (익술해지면)
//		유지보수에 용이

public class OMain1 {
	public static void main(String[] args) {
		// pp
//		String	name = "솔데스크";
//		String place = "강남구";
//		double distance = 4.5;
//		System.out.println(name);
//		System.out.println(place);
//		System.out.println(distance);

		// 새 class파일 만들기
		Hackwon h = new Hackwon();
		h.name = "솔데스크";
		h.place = "강남구";
		h.distance = 4.5;
		System.out.println(h.name);
		System.out.println(h.place);
		System.out.println(h.distance);
		
		Hackwon h2 = new Hackwon();
		
		// 객체 : 실생활에 물리적으로 존재하는 것 (사람 자동차 에어컨 컴퓨터 ...)
		// [에어컨]
		//	속성 : 온도 풍향 바람
		// 동작 : 켜다 끄다
		// 하리보 통 안에 있는 낱개포장 생각하면~
		//객체를 만들려면 class가 필요
		// 인스터스 : class에서 만들어진 객체를 해당 클래스의 인스턴스
		// 클래스에는 객체 생성을 위한 함수와 필드가 정의되어 있음

	}
}
