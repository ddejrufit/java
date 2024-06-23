import java.util.Scanner;

// 반복문(Repeat Statement)
// for : 특정한 수의 범위나 정해진 횟수 반복이 필요할 때 주로 사용
// while: 반복횟수가 특정되어지지 않았거나 조건식의 결과가 boolean으로 나오는 경우
//		조건을 먼저 검사한 후에 수행
// do-while : 반복횟수가 특정되어지지 않았거나 조건식의 결과가 boolean으로 나오는 경우 
//		일단 실행을 한번은 먼저 한 후에 조건을 검사(한번 반복은 보장)
public class RMain1 {
	public static void main(String[] args) {
		// break;룰 사용하면 반복문을 멈출 수 있다
		// 콘솔에 글을 입력받을 건데, 안녕 이라는 말이 나오기 전까지는 계속 반복
		// 안녕 << 반복문이 종료되게

		/*
		 * Scanner k = new Scanner(System.in); 
		 * String a = null;// 반복문 안에서 변수 생성 자제 위해
		 * 밖에서 먼저 만들기 
		 * while (true) {// 반복 횟수를 모를 때 while(true)
		 * 
		 * System.out.print("안녕이라고해:"); 
		 * a = k.next(); 
		 * if (a.equals("안녕")) { // a에 담긴
		 * 문자열이 [안녕]과 같으면 
		 * System.out.println("나도 안녕"); 
		 * break;// 반복문을 제어할 때(반복문 멈추게 할 때)
		 * } }
		 */
		// for문 if문 break 사용
		// 정수 1부터 다 더해서 그 합이 100을 넘기는 순간 끝나고 합을 출력
		// 100은 넘음
		int a = 0; // 합을 담을 변수
		for (int i = 0;; i++) {// 조건식 비워둬도 됨
			a += i;
			// if문 속에 한줄만 있는 경우 중괄호{} 삭제하고 아래처럼 사용 가능

			if (a >= 100)
				break;
			System.out.println(a);
		}

	}

}
