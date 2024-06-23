package com.kang.oct102ex;

//String[] hand = {"","가위","바위","보"}
public class Judge {
	String[] rulebook;

	public Judge() {
		rulebook = new String[] { "", "가위", "바위", "보" };
	}

	public void showRuleBook() {
		System.out.println("========================");
		for (int i = 1; i < rulebook.length; i++) {
// 			System.out.println(i + "." + rulebook[i]);
			System.out.printf("%d. %s\r\n", i, rulebook[i]);
		}
		System.out.println("========================");
	}

	public int askAns(Me m) {
		System.out.println("뭐? >>");
		int what = m.fire();
		return (what >= 1 && what <= 3) ? what : askAns(m);
	}

	// 위의 method와 오버로딩(pverloading)
	public int askAns(Computer c) {
		return c.fire();
	}

	// 누가 뭐 냈는지 출력
	public void printResult(int a, int b) {
		System.out.println("나는 >>" + rulebook[a]);
		System.out.println("컴퓨터는 >>" + rulebook[b]);
	}

	public boolean getResult(int a, int b, Me m) {
		int result = a - b;
		// boolean의 ture인 경우 return / false인 경우 return X
		if (result == -1 || result == 2) {
			System.out.println("패배");
		} else if (result == 0) {
			System.out.println("비김");
			m.draw++;
		}else {
			System.out.println("승리");
			m.win++;
		}return(result == -1 || result == 2);
	}
	
	public void sayIWin(Me m) {
		System.out.printf("%d 승, %d 무",m.win,m.draw);
	}

	public void gameStart(Me m, Computer c) {
		showRuleBook();
		int me = askAns(m);
		int com = askAns(c);
		while (true) {
			me = askAns(m);
			com = askAns(c);
			printResult(me, com);
			System.out.println("=====================");
			if (getResult(me,com,m)) {
				sayIWin(m);
				break;
			}
			System.out.println("=====================");
		}
	}

}
