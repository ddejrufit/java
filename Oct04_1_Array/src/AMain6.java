import java.util.Scanner;

// 함수 ver.
public class AMain6 {
	
	//물건 가격
	public static int getPrice() {
		Scanner k = new Scanner(System.in);
		System.out.println("상품 가격 :");
		int price = k.nextInt();
		return price;

	}
	//낸돈
	private static int payMoney(int price) {
		Scanner k = new Scanner(System.in);
		System.out.print("지불금액:");
		int money = k.nextInt();
		if (money<price) {
			System.out.println("돈이 부족합니다. 다시입력하세요.");
		}
		return(money>=price) ? money : payMoney(price);
	}

	//거스름돈 계싼
	private static int getChange(int price,int money) {
		return money - price;
		
	}
	
	//3개 출력
	public static void printResult(int price,int money, int change) {
		System.out.println("========================================");
		System.out.printf("물건 가격 :%,d원\n\r", price);
		System.out.printf("낸 금액 :%,d원\n\r", money);
		System.out.printf("거스름돈 :%,d원\n\r", change);
		System.out.println("==========================================");
	}	
	public static void printChange(int change) {
		int[]currency = {50000,10000,5000,1000,500,100,50,10};
		
		for (int i = 0; i < currency.length; i++) {
			if (change>=currency[i]) {
				System.out.printf("%d원권 : %d개\r\n",currency[i],(change/currency[i]));
				change %= currency[i];
				
			}
		}
	}
	public static void main(String[] args) {
		int price = getPrice();
		int money = payMoney(price);
		int change = getChange(price,money);
		printResult(price,money,change);
		printChange(change);
		
	

	
		
			}
	

	
}
