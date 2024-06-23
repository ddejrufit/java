import java.util.Scanner;

public class FMain3 {

	//1. (3보다 작은) 정수를 하나 입력 받아서 다른데서 사용할 함수
	//	3보다 큰 정수를 적었을 때 다시 입력하게(recursive)
	
	
	
	public static int aa() {
		Scanner k = new Scanner(System.in);
		System.out.print("3 미만:");
		int a = k.nextInt();
		return (a < 3)? a : aa();
	}
	//2. 홀수만 입력받는 함수
	public static int bb() {
		Scanner l = new Scanner(System.in);
		System.out.print("홀수만:");
		int a = l.nextInt();
		return (a % 2 == 1)? a : bb();
	}
	//3. 0부터 100까지의 정수만 입력받는 함수
	public static int cc() {
		Scanner q = new Scanner(System.in);
		System.out.print("0 부터 100까지만:");
		int a = q.nextInt();
		return ( a >= 0) && (a <= 100) ? a : cc();
	}
	public static void main(String[] args) {
		aa();
		bb();
		cc();
		
	}
}

