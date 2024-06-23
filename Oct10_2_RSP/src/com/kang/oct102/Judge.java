package com.kang.oct102;

public class Judge {
	public Me joinMe() {// 나 참여
		Me m = new Me();
		return m;
	}// 컴퓨터 참여

	public Computer joinCom() {
		Computer c = new Computer();
		return c;
	}

	// 유저 값 입력받기
	public String myPick(Me m) {
		System.out.println("가위 바위 보? : ");
		String hand = m.pick();
		return (hand.equals("가위") || hand.equals("바위") || hand.equals("보")) ? hand : myPick(m);
	}

	// 컴퓨터가 낸거
	private String cpuPick(Computer c) {
		int auto = c.com();
		if (auto == 1) {
			c.cpu = "가위";
		} else if (auto == 2) {
			c.cpu = "바위";
		} else if (auto == 3) {
			c.cpu = "보";
		}
		return c.cpu;
	}

	// 승리 판단
	private String judge(Me m, Computer c) {

		if (m.hand.equals(c.cpu)) {
			m.judge = "무승부";
			m.draw++;
		} else {
			if (m.hand.equals("가위")) {
				if (c.cpu.equals("바위")) {
					m.judge = "cpu의 승리";
					m.stop++;
				} else if (c.cpu.equals("보")) {
					m.judge = "나의 승리";
					m.win++;
				}
			} else if (m.hand.equals("바위")) {
				if (c.cpu.equals("보")) {
					m.judge = "cpu의 승리";
					m.stop++;
				} else if (c.cpu.equals("가위")) {
					m.judge = "나의 승리";
					m.win++;
				}
			} else if (m.hand.equals("보")) {
				if (c.cpu.equals("가위")) {
					m.judge = "cpu의 승리";
					m.stop++;
				} else if (c.cpu.equals("바위")) {
					m.judge = "나의 승리";
					m.win++;
				}
			}
		}

		return m.judge;
	}

	public void printInfo(Me m, Computer c) {
		System.out.println("=======================");
		System.out.println("내가 낸 거 : " + m.hand);
		System.out.println("컴퓨터가 낸 거 : " + c.cpu);
		System.out.println(m.judge);
		System.out.println(m.win + "번 승리");
		System.out.println(m.draw + "번 무승부");
		System.out.println("=======================");
	}

	// main 역할
	public void start() {
		Me m = joinMe();
		Computer c = joinCom();
		while (true) {
			c.cpu = cpuPick(c);
			m.hand = myPick(m);
			m.judge = judge(m, c);
			printInfo(m, c);
			if (m.stop !=0) {
				System.out.println("********패배하여 게임이 종료됩니다********");
				break;
			}
		
		}
	}
}
