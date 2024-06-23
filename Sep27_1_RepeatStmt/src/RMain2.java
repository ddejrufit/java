import java.util.Scanner;

// while / switch-case 문
//학생	: 공부 관련 기능
//강사	: 학생관리, 공부관련 기능
//매니저	: 시스템관리, 학생관리, 공부관련 기능

// 콘솔에 누구? : 강사
//		학생관리, 공부관련 기능
// 누구? : 매니저
//		시스템관리, 학생관리, 공부관련 기능
// 누구? : 끝<< if문 말고 case로
//		하면 반복문 멈추게

public class RMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		String a = null;
		
		b : while (true) {
			System.out.print("누구?:");
			a = k.next();
			switch (a) {
			case "학생":
				System.out.println("공부 관련 기능");
				break;
			case "강사":
				System.out.println("학생관리, 공부관련 기능");
				break;
			case "매니저":
				System.out.println("시스템관리,학생관리,공부관련기능");
				break;
			case "끝":
				System.out.println("종료");
				break b;
			default:
				System.out.println("해당사항 없습니다.");
				break;
			}
		//	if (a.equals("끋")) {
	//			break;
//			}
		}

	}

}
