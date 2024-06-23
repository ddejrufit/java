package sep25_2_conditionalStmt;
//조건문,반복문, 배열(java는 배열 예외)을 얼마나 잘쓰냐

// 조건문 (conditional statement)
//		if문 : 조건의 결과가 boolean(true 아니면 false)로 실행문이 결정

public class CMain1 {
	public static void main(String[] args) {
//		if - else 조건문 : 하나의 조건이 만족하면 나머지 부분은 수행하지 않음
		//**조건이 성립하는 순간 그 아래에 나오는 다른 조건식은 무시 
//		if (조건식1) {
//			조건식1이 true일 때 실행될 내용
//		}else if{ (조건식2) {
//		조건식1 이 성립하지 않지만 조건식2가 성립할 때 실행 될 내용
//		}else if{ (조건식3) {
//		조건식1,2가 성립하지 않지만 조건식 3이 성립할때 실행될 내용
//		}else{
//		조건식이 성립하지 않을 때 (false일 때) 실행될 내용
//		}
		
//		if - if 조건문 : 각각 다른 조건문으로 인식-> 각각 따로 수행
//		** 조건이 성립해도 아래 if문 확인 다시 함
//		if (조건식1) {
//		조건식1이 true일 때 실행될 내용
//		}
//		if (조건식2) {
//		조건식1이 true일 때 실행될 내용
//		}
		int a = 10;
		if (a == 5) {
			System.out.println("5 입니다.");
		} else if (a == 10) {
			System.out.println("10입니다.");
		} else {
			System.out.println("5,10이 아님");
		}

		if (a == 5) {
			System.out.println("5입니다");
		if (a == 10) {
			System.out.println("10입니다.");
			}

		}
	}
}