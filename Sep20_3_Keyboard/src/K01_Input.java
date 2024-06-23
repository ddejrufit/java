import java.util.Scanner;

public class K01_Input {
	public static void main(String[] args) {
		// keyboard 입력받을 준비 - 한번 꺼내면 해당 파일에서는 더이상 꺼낼 필요 X
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("이름이 뭐야? : ");
		String name = keyboard.next(); // 실제로 콘솔에 입력이 가능하게
		System.out.println(name);
		
		System.out.print("나이가 몇살? : ");
		int age = keyboard.nextInt();
		System.out.println(age);
		
		System.out.print("키 입력하기 : ");
		double height = keyboard.nextDouble();
		System.out.println(height);
		
		keyboard.close(); // 안해도 됨
	}
}




