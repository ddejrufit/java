import java.util.Random;
import java.util.Scanner;

//홀짝게임 -> 함수 ver.
// 범위 : 1 ~ 100

public class FMain1 {
	
	//랜덤한 숫자를 받는 함수
	/*public static void beRed() {
		Random r = new Random();
		int a = r.nextInt(100)+1;
		System.out.println(a);		
	}
	
	public static int beBlue() {
		Random r = new Random();
		int a = r.nextInt(100)+1;
		return a;		
	}
	*/
	public static int getNum() {
		Random r = new Random();
		int num = r.nextInt(100) + 1;
		return num;
	}
	//위 함수에서 만든 숫자가 홀, 짝 인지 판단한는 함수 - 4번함수
	
	public static String judgeHJ(int a) {
		String hj = (a % 2 == 0)? "짝" : "홀";
//		String s = (x % 2 == 1)? "홀" : "짝";
	  return hj;
	}
	
	//사용자가 홀,짝을 입력하는 함수
	/*public static String guess() {
		Scanner k = new Scanner(System.in);
		System.out.print("홀?짝?:");
		String holjjak = k.toString ();
		return holjjak;
		*/
	public static String writeHJ() {
		Scanner k = new Scanner(System.in);
		System.out.println("홀? 짝?:");
		String s = k.next();
		//3항연산자 , (짝 or 홀이 아니면) 다시 쓰게 -> 함수의 재귀적 호출
		return (s.equals("홀") || s.equals("짝"))? s : writeHJ();
	}
	
	
	
	//정답, 땡 판단하는 함수
	public static String judgeCorrect(String a, String b) {
		String correct = (a.equals(b)) ? "정답" : "땡";
		return correct;
	}
	 //결과 출력하는 함수
	public static void printResult(String a) {
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		/*beRed();
		String z = begreen(0);
		int y = guess();
		int randomA = beBlue();
		System.out.println(randomA);
		begreen(randomA);
		int randomB = beBlue();
		String an =  ( z = y ) != null ? "정답" : "땡";
		System.out.printf("[%s].\r\n", an);
		 */
		int n = getNum();
	//	System.out.println(n);  확인용
		String w = judgeHJ(n);
	//	System.out.println(w);  확인용
		String choose = writeHJ();
		String judge = judgeCorrect(w, choose);
		printResult(judge);
	
	
	

	
	
	

}
}
