
public class T1_EscapeSequence {
	public static void main(String[] args) {
//		System.out.println("안녕하세요?");
		// Escape Sequence(이스케이프 문자)
		// 		Java에서 사용하는 문법, 코드 등이
		//		실제로 사용하는 글자와 동일할 때 구분지어 주는 방법
		//		특수문자 사용에도 쓰임
		
		// 이스케이프 문자는 대부분의 언어에서 공통되게 활용
		// 1. tap 역할 : \t
		System.out.println("이름 : 정지희");
		System.out.println("이름\t정지희");
		System.out.println("날짜\t: 0920");
		System.out.println("우편번호\t: 12345");
		System.out.println("============");
		// 2. 줄바꿈(New Line) 역할 : \n
		System.out.println("안녕");
		System.out.println("디지몬");
		System.out.println("안녕\n디지몬");
		System.out.println("============");
		// 3. 커서를 맨 앞으로(Carriage return) : \r
		System.out.println("잘\r부탁드립니다");
		// 4. 말그대로 엔터 : \r\n
		System.out.println("우리 강의장은\r\n1강의장");
		/////////////////////////////
		System.out.println("============");
		System.out.println("안녕하세요?");
		// \" : "(따옴표를 문자로 표현하고 싶을 때)
		System.out.println("\"안녕하세요?\"라고 말했다");
		// 콘솔에 : \r\n은 엔터를 뜻한다
		System.out.println("\\r\\n은 엔터를 뜻한다");
	}
}







