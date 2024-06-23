import java.util.Scanner;

// 오버로딩(Overloading)
//		그 본질이 같다면 함수명을 같게,파라미터를 다르게
public class AMain2 {
	// 정수 2개 넣으면 그 합을 출력하는 함수
	public static void sum1(int a, int b) {
		System.out.println(a+b);
	}
	// 정수 3개 넣으면 그 합을 출력하는 함수
	public static void sum2(int a ,int b ,int c) {
		System.out.println(a+b+c);
		}
	
	//정수를 n개 넣으면 그 곱을 출력하는 함수
	// int...n << parameter 개수 무제한
	public static void gop(int...n) {
		int multiply = 1;
		for (int i = 0; i < n.length; i++) {
			multiply *= n[i];// multiply= multiply* n[i];
		}
		System.out.println(multiply);
	}
	public static void main(String[] args) {
		//여기서 함수 불러오기
		sum1(10,20);
		sum2(1,2,3);
		gop(1,2,3,4,5,6,7);
	}
}
