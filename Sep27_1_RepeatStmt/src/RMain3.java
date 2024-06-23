import java.util.Random;
import java.util.Scanner;

//up & down 게임
// 컴퓨터 vs 나 (범위는 1~1000까지)
// 컴퓨터가 숫자를 생각해 내면 내가 맞히는 ->같은 숫자면종료
// 예) 컴퓨터가 숫자 5를 생각함
//		내가 10이라고 입력 -> DOWN!
//		내가 3이라고 입력 -> UP!
//		몇번만에 정답을 맞췄는지
//   for문과 if문 사용

// 뭐? 10
// DOWN!
// 뭐? 3
// UP!
// 뭐? 5
// 정답! 3번만에 정답을 찾았습니다.
// 반복문 종료
public class RMain3 {
	public static void main(String[] args) {

		Random r = new Random();

		int a = r.nextInt(1000) + 1;
		
		for (int i = 1;; i++) {
			System.out.println("숫자는?:");
			Scanner k = new Scanner(System.in);
			int b = k.nextInt();
			if (a > b) {
				System.out.println("UP!");
			} else if (a < b) {
				System.out.println("DOWN!");
			} else if (a == b) {
				System.out.println("정답!");
				System.out.println(i + "번만에 정답을 찾았습니다!");
				break;
			}
		}

	}
}
