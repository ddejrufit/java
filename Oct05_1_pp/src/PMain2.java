
import java.util.Random;
import java.util.Scanner;

// 함수 ver.
// 로또
// 		1. 로또 번호는 총 6개 번호 (중복 숫자x)
//		2. 내가 숫자 6개 입력
//		3. 6개 일치 : 1등 / 5개 일치: 2등 / 4개 일치 :3등 / 그외 : 꽝
//		4. 로또 번호의 범위 : 1~45
public class PMain2 {
	// 숫자 입력 제한(1~45 사이만 가능하게)
	public static int getNum() {
		Scanner k = new Scanner(System.in);
		int num = k.nextInt();
		if (num < 1 || num > 45) {
			System.out.print("다시 입력 >");
		}
		return (num >= 1 && num <= 45) ? num : getNum();
	}
// 숫자 6개 입력 받는 함수
	public static int[] getNums() {
		int[] myAnswer = new int[6];
		for (int i = 0; i < myAnswer.length; i++) {
			System.out.printf("%d번째 숫자 입력 > ", i + 1);
			myAnswer[i] = getNum();//위의 getNum()함수 불러오기
		}
		return myAnswer;
	}

	// 내가 입력한 숫자 정리해서 보여주기
	public static void printMyAnswer(int[] myAnswer) {
		System.out.println("나의 번호!!");
		for (int i : myAnswer) {
			System.out.println("[" + i + "]");
		}
		System.out.println();
		System.out.println("=================================");
	}

	// 랜덤으로 로또 번호 뽑기 -> 중복 빼고
	public static int[] getLotto() {
		int[] lottoNum = new int[6];
		Random r = new Random();
		for (int i = 0; i < lottoNum.length; i++) {
			lottoNum[i] = r.nextInt(45) + 1;
//			System.out.println(lottoNum[i]);
			// 앞의 배열 요소와 뒤의 배열 요소 값을 구별하기 위해 반복문 하나 더 추가
			for (int j = 0; j < i; j++) {
//				System.out.println(lottoNum[i] + "" + lottoNum[j]);
				if (lottoNum[i] == lottoNum[j]) {
					i--;//중복 값이 있으면 index 하나 되돌려서 다시 for문 돌게
				}
			}
		}
		return lottoNum;
	}
	public static void printLottoNum(int[]lottoNum) {
		System.out.println("로또번호!!");
		for (int i : lottoNum) {
			System.out.println("["+i+"]");
		}
		System.out.println();
		System.out.println("===================================");
	}
	
	//내가 쓴 번호와 랜덤으로 뽑은 번호를 모든 경우의 수로 값이 같은지 확인
	// 같으면 카운트를 올리게
	public static int checkNum(int[] myAnswer, int[] lottoNum) {
		int count = 0 ;
		for (int i = 0; i < lottoNum.length; i++) {
			for (int j = 0; j < myAnswer.length; j++) {
				if (lottoNum[i] == myAnswer[j]) {
					count++;
				}
			}
		}
		return count;
	}
	public static void printResult(int count) {
		System.out.printf("%d 개 맞춰서...",count);
		if (count == 6) {
			System.out.println("1등!!");
		}else if (count == 5) {
			System.out.println("2등!!");
		}else if (count == 4) {
			System.out.println("3등!!");
		}else {
			System.out.println("꽝!");
		}
	}

	public static void main(String[] args) {
//		System.out.println(getNums());
		int[] myAnswer = getNums();
		printMyAnswer(myAnswer);
		int[] lottoNum = getLotto();
		printLottoNum(lottoNum);
		int count = checkNum(myAnswer,lottoNum);
		printResult(count);
	}
}
