// 배열(Array)
// 		변수 1 = 데이터 1
//		배역 : 변수 1 = 데이터 n << 변수 하나에 데이터 여러개
//		배열은 참조형 -> 데이터가 heap에 임시저장 -> stack에는 번지수만 저장!!
public class AMain1 {
	public static void main(String[] args) {
		int a = 10;
		int[] eng = new int[3];
		eng[0] = 100;
		eng[1] = 50;
		eng[2] = 30;
		System.out.println(eng);// heap영역에 저장된 번지수(주소값)
		System.out.println(eng[0]);
		System.out.println("------------------------------");
		// 배열 안에 있는 모든 데이터를 한번에 보고 싶으면 : 반복문
		for (int i = 0; i < eng.length; i++) {
			System.out.println(eng[i]);
		}
		System.out.println("--------------1----------------");
		int[] math = new int[] { 10, 30, 21 };
		for (int i = 0; i < math.length; i++) {
			System.out.println(math[i]);
		}
		System.out.println("--------------2----------------");
		int[] kor = {10,20,30};//약식, 안되는 경우 바루위의 선언 방법 사용
		System.out.println(kor.length);// 배열의 길이 (데이터 수)
		System.out.println("--------------3----------------");
//		//2차원 배열 -> 배열속의 배열
//		int[][] score = {{50,30},{100,60},{70,50}};
//		System.out.println(score);
//		System.out.println(score[1][0]);
	}
}
