import java.util.Scanner;

//함수 없이
//1. 학생수 2. 점수 입력 3. 점수리스트 4.분석 5.종료
//1.학생수 입력 : 2
//2. 1번째 학생 점수 입력 : 100
//   2번째 학생 점수 입력 : 80
//3. 1번째 학생 점수 : 100
//	2번째 학생 점수 80
//4. 분석: 최고점 가지고 있는학생의 최고 점수,
//		  +모든 학생의 총점 + 모든학생 점수의 평균
//5. 종료 
public class PMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		int selectMenu = 0;// 메뉴입력용
		int studentNo = 0;// 학생 수 입력용
		int[] scores = null;// 점수 입력용
		int max = 0;// 최고점
		int sum = 0;// 합계
		double avg = 0;// 점수 평균용
		while (true) {

			System.out.println("=======================================");
			System.out.println("1.학생수|2.점수 입력|3.점수리스트|4.분석|5.종료");
			System.out.println("=======================================");
			System.out.println("메뉴선택>");
			selectMenu = k.nextInt();// 메뉴 선택
			if (selectMenu == 5) {
				System.out.println("종료합니다.");
				break;

			} else if (selectMenu == 1) {
				System.out.print("학생수 : ");
				studentNo = k.nextInt();
				// 몇명 넣을 지 특정 할 수 없으므로 변수명 자체를 넣기
				// 점수 입력할 학생 수만큼의 자리 만들기
				scores = new int[studentNo];
			} else if (selectMenu == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("%d번 학생 점수 입력 :", i + 1);
					scores[i] = k.nextInt();// 배열의 해당하는 자리에 점수 하나씩
				}
			} else if (selectMenu == 3) {
//				for (int i = 0; i < scores.length; i++) {
//					System.out.printf("%d번 학생 점수 : %d 점 \r\n",i+1,scores[i]);
//				}
				int index = 1;
				for (int i : scores) {
					System.out.printf("%d번 학생 점수 : %d점\r\n", index++, i);
				}
			} else if (selectMenu == 4) {
//				for (int i : scores) {
//					// 만약 i번째 요소에 있는 점수가 기존의 max 변수그릇에 있는 점수보다 크면 자리 바꾸기, 아니면 그대로
//					max = (max < i) ? i : max;
//					sum += i;
//					avg = (double) sum / scores.length;
//				}
				for (int i = 0; i < scores.length; i++) {
					max = (max < scores[i]) ? scores[i] : max;
					sum += scores[i];
					avg = (double) sum / scores.length;
				}
				System.out.printf("최고점수 : %d점\r\n", max);
				System.out.printf("총점 : %d점\r\n", sum);
				System.out.printf("평균 : %.2f점\r\n", avg);
			}
		}
	}
}
