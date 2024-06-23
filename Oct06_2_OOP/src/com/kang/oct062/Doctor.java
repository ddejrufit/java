package com.kang.oct062;

//지역변수(Local Variable):
//	 method 안에서 만든 것>> 그 행동을 하는 동안'만 필요한 임시변수

//멤버변수 (Member Variable) :
//		객체의 속성
public class Doctor {

	// 손님을 불러와야
	public Guest callGuest() {
		Guest g = new Guest();
		return g;
	}

	// 이름 입력받기
	public String askName(Guest g) {
		System.out.print("이름 : ");
		String name = g.tellName();
		return name;
	}

	// 1.키 입력 받는 method (m만 입력 받게)
	public double askHeight(Guest g) {

		System.out.print("키 m로 : ");
		double height = g.ki();
//		return (height > 3) ? askHeight(g) : height;
		return (height < 3) ? height : askHeight(g);

	}

	// 2. 몸무게 입력 받는 method
	public double askWeight(Guest g) {
		System.out.print("몸무게 : ");
		double weight = g.muge();
		return weight;
	}

	// 3. bmi 계산하는 method bmi = 몸무게 / (키m*키m)
	public double BMI(Guest g) {
		double bmi = g.weight / (g.height * g.height);

		return bmi;
	}

	// 4. 상태 체크하는 method
	// 18.5미만 저체중 // 18.5이상 정상
	// 25 이상 과체중// 30이상 경도비만
	// 35이상 중등도비만// 40이상 고도비만
	private String checkStatus(Guest g) {
		g.status = "저체중";
		if (g.bmi >= 40) {
			g.status = "고도비만";
		} else if (g.bmi >= 35) {
			g.status = "중등도비만";
		} else if (g.bmi >= 30) {
			g.status = "경도비만";
		} else if (g.bmi >= 25) {
			g.status = "과체중";
		} else if (g.bmi >= 18.5) {
			g.status = "정상";
		}
		return g.status;
	}

	// 5. 정보 출력 (이름, 키, 몸무게, bmi 수치, bmi결과)
	public void printBMI(Guest g) {
		System.out.println("======================");
		System.out.printf("이름 : %s\r\n", g.name);
		System.out.printf("키 : %1fm\r\n", g.height);
		System.out.printf("몸무게 : %1fkg\r\n", g.weight);
		System.out.printf("bmi : %.1f%%\r\n", g.bmi);
		System.out.printf("결과 : %s\r\n", g.status);
		System.out.println("======================");
	}

	// main역할을 하는 start() method
	public void start() {
		Guest g = callGuest(); // 1. Guest class 불러오기
		g.name = askName(g); // 2. 이름 입력받은 것 Guest 객체 속성에 넣기
		g.height = askHeight(g);// 3. 키 입력받기
		g.weight = askWeight(g);// 4. 몸무게 입력받기
		g.bmi = BMI(g);
		g.status = checkStatus(g);
		printBMI(g);

	}
}
